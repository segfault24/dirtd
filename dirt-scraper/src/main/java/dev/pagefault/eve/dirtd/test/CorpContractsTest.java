package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.CorpContractsTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class CorpContractsTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        CorpContractsTest test = new CorpContractsTest();
        test.scheduleTask(new CorpContractsTask());
        test.run();
        System.exit(0);
    }

}
