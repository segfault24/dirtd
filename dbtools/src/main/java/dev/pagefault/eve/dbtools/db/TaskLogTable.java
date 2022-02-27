package dev.pagefault.eve.dbtools.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dev.pagefault.eve.dbtools.model.TaskLog;
import dev.pagefault.eve.dbtools.util.Utils;

public class TaskLogTable {

	private static final String SELECT_LATEST_TASK_SQL = "SELECT `taskName`,`startTime`,`finishTime`,`success` FROM tasklog WHERE `taskName`=?";
	private static final String INSERT_TASK_SQL = "INSERT INTO tasklog (`taskName`,`startTime`,`finishTime`,`success`) VALUES (?,?,?,?)" +
			"ON DUPLICATE KEY UPDATE `startTime`=VALUES(`startTime`), `finishTime`=VALUES(`finishTime`), `success`=VALUES(`success`)";

	/**
	 * Get the latest TaskLog for the given taskName
	 * 
	 * @param db
	 * @param taskName
	 * @return
	 */
	public static TaskLog getLatestTaskLog(Connection db, String taskName) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		TaskLog t = null;
		try {
			stmt = db.prepareStatement(SELECT_LATEST_TASK_SQL);
			stmt.setString(1, taskName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				t = new TaskLog();
				t.setTaskName(taskName);
				t.setStartTime(rs.getTimestamp(2));
				t.setFinishTime(rs.getTimestamp(3));
				t.setSuccess(rs.getBoolean(4));
			}
		} catch (SQLException e) {
			t = null;
		} finally {
			Utils.closeQuietly(rs);
			Utils.closeQuietly(stmt);
		}
		return t;
	}

	/**
	 * Inserts the given TaskLog
	 * 
	 * @param db
	 * @param taskLog
	 * @throws SQLException
	 */
	public static void insertTaskLog(Connection db, TaskLog taskLog) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(INSERT_TASK_SQL);
		stmt.setString(1, taskLog.getTaskName());
		stmt.setTimestamp(2, taskLog.getStartTime());
		stmt.setTimestamp(3, taskLog.getFinishTime());
		stmt.setBoolean(4, taskLog.isSuccess());
		stmt.execute();
		Utils.closeQuietly(stmt);
	}

}
