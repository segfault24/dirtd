package dev.pagefault.eve.dirtd;

import dev.pagefault.eve.dbtools.db.StructAuthTable;
import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dbtools.util.Utils;
import dev.pagefault.eve.dirtd.task.StructureTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.sql.Connection;
import java.sql.SQLException;

public class MarketStructureAdder {

    private final DbPool dbPool;

    public MarketStructureAdder() {
        dbPool = new DbPool(new DbInfo());
        dbPool.setMinPoolSize(1);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> dbPool.closeAll()));
    }

    public void addStruct(long structId) {
        Connection db;
        try {
            db = dbPool.acquire();
        } catch (SQLException e) {
            System.err.println("Failed to acquire database connection");
            System.err.println(e);
            return;
        }

        int keyId;
        try {
            keyId = Utils.getIntProperty(db, DirtConstants.PROPERTY_SCRAPER_KEY_ID);
        } catch (NumberFormatException e) {
            // retry?
            keyId = Utils.getIntProperty(db, DirtConstants.PROPERTY_SCRAPER_KEY_ID);
        }
        // manually run the task
        StructureTask st = new StructureTask(structId, keyId);
        st.setExecutor(null);
        st.setDbPool(dbPool);
        st.run();
        // create a link between the struct and the key
        try {
            StructAuthTable.insert(db, structId, keyId);
        } catch (SQLException e) {
            System.err.println("Failed to insert structure auth");
            System.err.println(e);
        }
        dbPool.release(db);
    }

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.INFO);
        if (args.length <= 0) {
            System.err.println("A structure id must be provided");
            return;
        }
        long id;
        try {
            id = Long.parseLong(args[0]);
        } catch(NumberFormatException e) {
            System.err.println("Failed to parse structure id");
            return;
        }
        new MarketStructureAdder().addStruct(id);
        System.exit(0);
    }

}