package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.daemon.Taskable;
import dev.pagefault.eve.dirtd.task.DirtTask;
import dev.pagefault.eve.dirtd.task.MarketHistoryTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MarketHistoryTest implements Taskable {

    private final Queue<DirtTask> tasks = new ConcurrentLinkedQueue<>();
    private DbPool dbPool;

    public void run() {
        dbPool = new DbPool(new DbInfo());
        dbPool.setMinPoolSize(2);
        scheduleTask(new MarketHistoryTask(10000002));
        DirtTask t;
        while ((t = tasks.poll()) != null) {
            t.run();
        }
        dbPool.closeAll();
    }

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        new MarketHistoryTest().run();
        System.exit(0);
    }

    @Override
    public void scheduleTask(DirtTask t) {
        t.setExecutor(this);
        t.setDbPool(dbPool);
        tasks.add(t);
    }

    @Override
    public void scheduleTasks(Collection<DirtTask> ts) {
        ts.forEach(this::scheduleTask);
    }
}
