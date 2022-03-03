package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.UnknownIdsTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class UnknownsTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        UnknownsTest test = new UnknownsTest();
        test.scheduleTask(new UnknownIdsTask());
        test.run();
        System.exit(0);
    }

}
