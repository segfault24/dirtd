package dev.pagefault.eve.dirtd.test;

import dev.pagefault.eve.dirtd.task.MaterializedPriceViewTask;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.util.ArrayList;
import java.util.List;

public class MaterializedPriceViewTest extends AbstractTest {

    public static void main(String[] args) {
        Configurator.setRootLevel(Level.TRACE);
        MaterializedPriceViewTest test = new MaterializedPriceViewTest();

        // jita + TTT
        List<Long> locations = new ArrayList<>();
        locations.add(60003760L);
        locations.add(1028858195912L);
        test.scheduleTask(new MaterializedPriceViewTask("vjitabestbuy", 10000002, locations, true));
        test.scheduleTask(new MaterializedPriceViewTask("vjitabestsell", 10000002, locations, false));

        // amarr
        locations.clear();
        locations.add(60008494L);
        test.scheduleTask(new MaterializedPriceViewTask("vamarrbestbuy", 10000043, locations, true));
        test.scheduleTask(new MaterializedPriceViewTask("vamarrbestsell", 10000043, locations, false));

        test.run();
        System.exit(0);
    }

}
