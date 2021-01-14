package dev.pagefault.eve.dirtd.daemon;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
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
import dev.pagefault.eve.dirtd.task.DirtTask;

public class TaskExecutor extends ScheduledThreadPoolExecutor implements Taskable {

	private static Logger log = LogManager.getLogger();

	private final DbPool dbPool;
	private HashMap<String, TaskEntry> registry = new HashMap<String, TaskEntry>();

	public TaskExecutor(DbPool pool) {
		super(1);
		dbPool = pool;
	}

	public void init() throws SQLException {
		Connection db = dbPool.acquire();
		int threads = Utils.getIntProperty(db, DirtConstants.PROPERTY_NUM_THREADS);
		setCorePoolSize(threads);
		dbPool.setMinPoolSize(threads);
		log.info("Starting with " + threads + " worker threads");
		dbPool.release(db);
	}

	// TODO load tasks from db into registry

	public void start(String taskName) throws TaskNotFoundException {
		TaskEntry entry = findTask(taskName);
		if (!entry.task.isStarted()) {
			entry.task.setExecutor(this);
			entry.task.setDbPool(dbPool);
			entry.future = schedule(entry.task, 0, TimeUnit.MINUTES);
			entry.task.setStarted(true);
			log.debug("Queued " + entry.task.getTaskName());
		}
	}

	public void stop(String taskName, boolean force) throws TaskNotFoundException {
		TaskEntry entry = findTask(taskName);
		if (entry.future != null) {
			entry.future.cancel(force);
			entry.future = null;
		}
		entry.task.setStarted(false);
	}

	public void stopAll(){
		for (TaskEntry entry : registry.values()) {
			if (entry.future != null) {
				entry.future.cancel(false);
				entry.future = null;
			}
			entry.task.setStarted(false);
		}
		purge();
	}

	public void enable(String taskName) throws TaskNotFoundException {
		TaskEntry entry = findTask(taskName);
		entry.task.setEnabled(true);
		// TODO: update task table
	}

	public void disable(String taskName) throws TaskNotFoundException {
		TaskEntry entry = findTask(taskName);
		entry.task.setEnabled(false);
		// TODO: update task table
	}

	public String status(String taskName) throws TaskNotFoundException {
		TaskEntry entry = findTask(taskName);
		return "enabled: " + entry.task.isEnabled() + ", started: " + entry.task.isStarted();
	}

	/**
	 * @param task
	 */
	@Override
	public void scheduleTask(DirtTask task) {
		task.setExecutor(this);
		task.setDbPool(dbPool);
		schedule(task, 0, TimeUnit.MINUTES);
		log.debug("Queued " + task.getTaskName());
	}

	/**
	 * @param tasks
	 */
	@Override
	public void scheduleTasks(Collection<DirtTask> tasks) {
		for (DirtTask task : tasks) {
			scheduleTask(task);
		}
	}

	/**
	 * @param db
	 * @param task
	 * @param period in minutes
	 */
	public void schedulePeriodicTask(Connection db, DirtTask task, long period) {
		TaskLog ts = TaskLogTable.getLatestTaskLog(db, task.getTaskName());
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
		task.setExecutor(this);
		task.setDbPool(dbPool);
		TaskEntry te = new TaskEntry();
		te.future = scheduleAtFixedRate(task, initialDelay, period, TimeUnit.MINUTES);
		te.task = task;
		registry.put(task.getTaskName(), te);
		log.debug("Queued " + task.getTaskName() + " with period=" + period + " initialDelay=" + initialDelay);
	}

	private TaskEntry findTask(String search) throws TaskNotFoundException {
		TaskEntry entry = registry.get(search.toLowerCase());
		if (entry == null) {
			throw new TaskNotFoundException();
		} else {
			return entry;
		}
	}

	private static class TaskEntry {
		public DirtTask task;
		public ScheduledFuture<?> future;
	}

	public static class TaskNotFoundException extends Exception {
		private static final long serialVersionUID = -1217549797920148675L;
	}

}
