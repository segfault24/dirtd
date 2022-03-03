package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.MarketHistoryTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class MarketHistoryTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        MarketHistoryTest test = new MarketHistoryTest();
        test.scheduleTask(new MarketHistoryTask(10000002));
        test.run();
        System.exit(0);
    }

}
