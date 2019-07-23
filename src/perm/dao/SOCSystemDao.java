package perm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import perm.model.SOCSystem;

public class SOCSystemDao {
	
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static SOCSystemDao instance = null;
	protected SOCSystemDao() {
		connectionManager = new ConnectionManager();
	}
	public static SOCSystemDao getInstance() {
		if(instance == null) {
			instance = new SOCSystemDao();
		}
		return instance;
	}
	
	/**
	 * Save the Persons instance by storing it in your MySQL instance.
	 * This runs a INSERT statement.
	 */
	public SOCSystem create(SOCSystem socSystem) throws SQLException {
		String socSystemQuery = "INSERT INTO SOCSystem(PrevailingWageSocCode ,PrevailingWageSocTitle ) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(socSystemQuery);
			insertStmt.setString(1, socSystem.getPrevailingWageSocCode());
			insertStmt.setString(2, socSystem.getPrevailingWageSocTitle());
			insertStmt.executeUpdate();
			return socSystem;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(insertStmt != null) {
				insertStmt.close();
			}
		}
	}


	/**
	 * Update the SocTitle of the SOcsystem instance.
	 */
	public SOCSystem updateSocTitle(SOCSystem socSystem, String socTitle) throws SQLException {
		String updateSocTitle = "UPDATE SOCSystem SET PrevailingWageSocTitle =? WHERE PrevailingWageSocCode =?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateSocTitle);
			updateStmt.setString(1, socTitle);
			updateStmt.setString(2, socSystem.getPrevailingWageSocCode());
			updateStmt.executeUpdate();
			socSystem.setPrevailingWageSocTitle(socTitle);
			return socSystem;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	/**
	 * Delete the SocSystem instance.
	 */
	public SOCSystem delete(SOCSystem socSystem) throws SQLException {
		String deleteSocSystem = "DELETE FROM SOCSystem WHERE PrevailingWageSocCode =?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteSocSystem);
			deleteStmt.setString(1, socSystem.getPrevailingWageSocCode());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the Persons instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	/**
	 * Get the Persons record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Persons instance.
	 */
	public SOCSystem getSocSystemFromSocCode(String socCode) throws SQLException {
		String selectSocSystem = "SELECT PrevailingWageSocCode , PrevailingWageSocTitle FROM SOCSystem WHERE PrevailingWageSocCode =?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSocSystem);
			selectStmt.setString(1, socCode);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultSocCode = results.getString("PrevailingWageSocCode");
				String socTitle = results.getString("PrevailingWageSocTitle");
				SOCSystem socSystem= new SOCSystem(resultSocCode, socTitle);
				return socSystem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return null;
	}

	/**
	 * Get the soc system records.
	 */
	public List<SOCSystem> getSOCSystemFromSOCTitle(String socTitle) throws SQLException {
		List<SOCSystem> socSystems = new ArrayList<SOCSystem>();
		String selectSocSystems=
			"SELECT PrevailingWageSocCode , PrevailingWageSocTitle FROM SOCSystem WHERE PrevailingWageSocTitle =?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectSocSystems);
			selectStmt.setString(1, socTitle);
			results = selectStmt.executeQuery();
			while(results.next()) {
				String socCode = results.getString("PrevailingWageSocCode");
				String resultSocTitle = results.getString("PrevailingWageSocTitle");
				SOCSystem socSystem = new SOCSystem(socCode, resultSocTitle);
				socSystems.add(socSystem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(connection != null) {
				connection.close();
			}
			if(selectStmt != null) {
				selectStmt.close();
			}
			if(results != null) {
				results.close();
			}
		}
		return socSystems;
	}
}




