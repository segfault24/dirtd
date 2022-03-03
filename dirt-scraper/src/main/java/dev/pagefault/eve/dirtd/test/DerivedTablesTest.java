package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.task.CharacterTask;
import dev.pagefault.eve.dirtd.task.DerivedTableTask;
import dev.pagefault.eve.dirtd.task.DirtTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class DerivedTablesTest {

    public void run() {
        DbPool dbPool = new DbPool(new DbInfo());
        dbPool.setMinPoolSize(1);
        DirtTask t = new DerivedTableTask();
        t.setDbPool(dbPool);
        t.run();
        dbPool.closeAll();
    }

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        new DerivedTablesTest().run();
        System.exit(0);
    }

}
