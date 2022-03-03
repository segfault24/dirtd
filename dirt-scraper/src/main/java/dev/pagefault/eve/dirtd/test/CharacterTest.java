package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.CharacterTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class CharacterTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        CharacterTest test = new CharacterTest();
        test.scheduleTask(new CharacterTask(93764661));
        test.run();
        System.exit(0);
    }

}
