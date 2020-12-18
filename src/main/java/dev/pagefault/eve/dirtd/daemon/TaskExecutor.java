package dev.pagefault.eve.dirtd.daemon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dev.pagefault.eve.dbtools.db.TaskLogTable;
import dev.pagefault.eve.dbtools.model.TaskLog;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.DirtConstants;
import dev.pagefault.eve.dirtd.Taskable;
import dev.pagefault.eve.dirtd.task.DirtTask;

public class TaskExecutor extends ScheduledThreadPoolExecutor implements Taskable {

	private static Logger log = LogManager.getLogger();

	private final DbPool dbPool;
	private HashMap<String, ScheduledFuture<?>> futures = new HashMap<String, ScheduledFuture<?>>();

	public TaskExecutor(DbPool pool) throws SQLException {
		super(1);
		dbPool = pool;

		log.info("=======================================");
		log.info("==  dirtd task executor starting up  ==");
		log.info("=======================================");
		Connection db = dbPool.acquire();
		int threads = Utils.getIntProperty(db, DirtConstants.PROPERTY_NUM_THREADS);
		setCorePoolSize(threads);
		dbPool.setMinPoolSize(threads);
		log.info("Starting with " + threads + " worker threads");
		dbPool.release(db);
	}

	/**
	 * @param t
	 */
	@Override
	public void addTask(DirtTask t) {
		t.setDaemon(this);
		t.setDbPool(dbPool);
		schedule(t, 0, TimeUnit.MINUTES);
		log.debug("Queued " + t.getTaskName());
	}

	/**
	 * @param ts
	 */
	@Override
	public void addTasks(Collection<DirtTask> ts) {
		for (DirtTask t : ts) {
			addTask(t);
		}
	}

	/**
	 * @param db
	 * @param t
	 * @param period in minutes
	 */
	public void addPeriodicTask(Connection db, DirtTask t, long period) {
		TaskLog ts = TaskLogTable.getLatestTaskLog(db, t.getTaskName());
		long initialDelay = 0;
		if (ts != null) {
			long lastRun = ts.getFinishTime().getTime() / 1000 / 60;
			long now = System.currentTimeMillis() / 1000 / 60;
			long minSinceLastRun = now - lastRun;
			if (minSinceLastRun < period) {
				initialDelay = period - minSinceLastRun;
			} else {
				initialDelay = 0;
			}
		}
		t.setDaemon(this);
		t.setDbPool(dbPool);
		futures.put(t.getTaskName(), scheduleAtFixedRate(t, initialDelay, period, TimeUnit.MINUTES));
		log.debug("Queued " + t.getTaskName() + " with period=" + period + " initialDelay=" + initialDelay);
	}

	/**
	 * @return
	 */
	public Set<String> getTaskNames() {
		return futures.keySet();
	}

	/**
	 * @param taskName
	 * @param force
	 * @return
	 */
	public boolean stopTask(String taskName, boolean force) {
		ScheduledFuture<?> future = futures.get(taskName);
		if (future != null) {
			return future.cancel(force);
		} else {
			return false;
		}
	}

	/**
	 * 
	 */
	public void stopAllTasks() {
		for (ScheduledFuture<?> f : futures.values()) {
			f.cancel(false);
		}
		purge();
		futures.clear();
	}
}
