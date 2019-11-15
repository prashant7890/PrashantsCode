package com.cloudamize.commonUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionUtils {

	private static final Logger LOG = LoggerFactory.getLogger(DbConnectionUtils.class);
	String initialConnUri = "jdbc:postgresql://";
	
	public Connection getDbConnection(final String dbIp, final String dbName, final String dbPort, final String dbUser, final String dbPassword) {

		final StringBuilder dbUri = new StringBuilder();

		dbUri.append(initialConnUri);
		dbUri.append(dbIp);
		dbUri.append(":");
		dbUri.append(dbPort);
		dbUri.append("/");
		dbUri.append(dbName);

		Connection dbConn = null;

		LOG.debug("SSL Db Uri is: {}", dbUri.toString());

		try {
			dbConn = DriverManager.getConnection(dbUri.toString(), dbUser, dbPassword);
		} catch (SQLException sqlE) {
			sqlE.printStackTrace();
		}

		return dbConn;
	}

}
