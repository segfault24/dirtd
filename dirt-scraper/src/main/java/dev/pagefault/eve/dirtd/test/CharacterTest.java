package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.task.CharacterTask;
import dev.pagefault.eve.dirtd.task.DirtTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class CharacterTest {

    public void run() {
        DbPool dbPool = new DbPool(new DbInfo());
        dbPool.setMinPoolSize(2);
        DirtTask t = new CharacterTask(93764661);
        t.setDbPool(dbPool);
        t.run();
        t = new CharacterTask(2119411560);
        t.setDbPool(dbPool);
        t.run();
        dbPool.closeAll();
    }

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        new CharacterTest().run();
        System.exit(0);
    }

}
