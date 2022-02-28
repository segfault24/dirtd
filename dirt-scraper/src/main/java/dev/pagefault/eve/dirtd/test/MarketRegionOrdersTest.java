package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.task.DirtTask;
import dev.pagefault.eve.dirtd.task.MarketRegionOrdersTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.Arrays;

public class MarketRegionOrdersTest {

    public void run() {
        int[] regions = { 10000002, 10000043, 10000032, 10000030, 10000042 };
        DbPool dbPool = new DbPool(new DbInfo());
        dbPool.setMinPoolSize(2);
        for (int r : regions) {
            DirtTask t = new MarketRegionOrdersTask(r);
            t.setDbPool(dbPool);
            t.run();
        }
        dbPool.closeAll();
    }

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        new MarketRegionOrdersTest().run();
        System.exit(0);
    }

}
