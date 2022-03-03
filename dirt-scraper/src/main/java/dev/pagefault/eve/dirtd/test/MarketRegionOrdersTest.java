package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.MarketRegionOrdersTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class MarketRegionOrdersTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        MarketRegionOrdersTest test = new MarketRegionOrdersTest();
        int[] regions = { 10000002, 10000043, 10000032, 10000030, 10000042 };
        for (int r : regions) {
            test.scheduleTask(new MarketRegionOrdersTask(r));
        }
        test.run();
        System.exit(0);
    }

}
