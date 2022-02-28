package dev.pagefault.eve.dbtools.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DbInfo {

	private final String dbDriver;
	private final String dbHost;
	private final String dbPort;
	private final String dbName;
	private final String dbUser;
	private final String dbPass;

	public DbInfo() {
		String filePath = System.getProperties().getProperty("config");
		if (filePath == null) {
			throw new RuntimeException("config property must be set to the location of the db.ini file");
		}
		File f = new File(filePath);
		if (!f.exists() || !f.canRead()) {
			throw new RuntimeException("the specified db.ini file does not exist or cannot be read");
		}

		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
			props.load(fis);
		} catch (IOException ignored) {
		} finally {
			Utils.closeQuietly(fis);
		}

		dbDriver = props.getProperty("dbdriver");
		dbHost = props.getProperty("dbhost");
		dbPort = props.getProperty("dbport");
		dbName = props.getProperty("dbname");
		dbUser = props.getProperty("dbuser");
		dbPass = props.getProperty("dbpass");

		if (dbDriver == null || dbHost == null || dbPort == null || dbName == null || dbUser == null
				|| dbPass == null) {
			throw new RuntimeException("bad db.ini file, please check your syntax");
		}

	}

	public String getDbConnectionString() {
		return "jdbc:" + dbDriver + "://" + dbHost + ":" + dbPort + "/" + dbName + "?useSSL=false&rewriteBatchedStatements=true";
	}

	public String getUser() {
		return dbUser;
	}

	public String getPass() {
		return dbPass;
	}

}
