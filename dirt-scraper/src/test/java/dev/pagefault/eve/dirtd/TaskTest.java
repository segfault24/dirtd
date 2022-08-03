package dev.pagefault.eve.dirtd;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import dev.pagefault.eve.dbtools.util.DbInfo;
import dev.pagefault.eve.dbtools.util.DbPool;
import dev.pagefault.eve.dirtd.task.CharacterOrdersTask;
import dev.pagefault.eve.dirtd.task.DirtTask;

public class TaskTest {

	public void run() {
		DbPool dbPool = new DbPool(new DbInfo());
		dbPool.setMinPoolSize(2);
		//DirtTask t = new CharacterOrdersTask(96151338);
		DirtTask t = new CharacterOrdersTask(2114247422);
		t.setDbPool(dbPool);
		t.run();
	}

	public static void main(String[] args) {
		Configurator.setRootLevel(Level.DEBUG);
		new TaskTest().run();
	}

}
