package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.DerivedTableTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class DerivedTablesTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        DerivedTablesTest test = new DerivedTablesTest();
        test.scheduleTask(new DerivedTableTask());
        test.run();
        System.exit(0);
    }

}
