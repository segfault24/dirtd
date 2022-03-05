package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.OrderReaperTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class OrderReaperTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        OrderReaperTest test = new OrderReaperTest();
        test.scheduleTask(new OrderReaperTask());
        test.run();
        System.exit(0);
    }

}
