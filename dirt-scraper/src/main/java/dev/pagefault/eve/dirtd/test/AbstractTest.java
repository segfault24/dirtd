package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.daemon.Taskable;
import dev.pagefault.eve.dirtd.task.DirtTask;

import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AbstractTest implements Taskable {

    private final Queue<DirtTask> tasks = new ConcurrentLinkedQueue<>();
    private final DbPool dbPool = new DbPool(new DbInfo());
    private int numThreads = 1;

    public AbstractTest() {
    }

    public AbstractTest(int numThreads) {
        this.numThreads = numThreads;
    }

    public final void run() {
        dbPool.setMinPoolSize(numThreads);
        DirtTask t;
        while ((t = tasks.poll()) != null) {
            t.run();
        }
        dbPool.closeAll();
    }

    @Override
    public final void scheduleTask(DirtTask t) {
        t.setExecutor(this);
        t.setDbPool(dbPool);
        tasks.add(t);
    }

    @Override
    public final void scheduleTasks(Collection<DirtTask> ts) {
        ts.forEach(this::scheduleTask);
    }
}
