package perm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import perm.model.Naics;
import perm.model.SOCSystem;

/**
 * NAICSCode INT,
 * NAICSTitle VARCHAR(255),
 * 
 *
 */

public class NaicsDao {
	
	protected ConnectionManager connectionManager;
	
	// Single pattern: instantiation is limited to one object.
	private static NaicsDao instance = null;
	protected NaicsDao() {
		 connectionManager = new ConnectionManager();
	}
	public static NaicsDao getInstance() {
		if(instance == null) {
			instance = new NaicsDao();
		}
		return instance;
	}
	
	public Naics create(Naics naics) throws SQLException {
		String insert = "INSERT INTO NAICS(NAICSCode ,NAICSTitle) VALUES(?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insert);
			insertStmt.setInt(1,  naics.getNaicsCode());
			insertStmt.setString(2, naics.getNaicsTitle());
			insertStmt.executeUpdate();
			return naics;
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
	 * Update the NaicsTitle of the Naics instance.
	 */
	public Naics updateNaicsTitle(Naics naics, String naicsTitle) throws SQLException {
		String updateNaicsTitle = "UPDATE NAICS SET NAICSTitle =? WHERE NAICSCode =?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateNaicsTitle);
			updateStmt.setInt(1,  naics.getNaicsCode());
			updateStmt.setString(2,naicsTitle);
			updateStmt.executeUpdate();
			naics.setNaicsTitle(naicsTitle);
			return naics;
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
	
	
	public Naics getNaicsFromNaicsCode(int naicsCode) throws SQLException {
		String selectNaics = "SELECT NAICSCode , NAICSTitle FROM NAICS WHERE NAICSCode =?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectNaics);
			selectStmt.setInt(1, naicsCode);
			results = selectStmt.executeQuery();
			if(results.next()) {
				int resultNaicsCode = results.getInt("NAICSCode");
				String naicsTitle = results.getString("NAICSTitle");
				return new Naics(resultNaicsCode, naicsTitle);
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
	
	
	public Naics delete(Naics naics) throws SQLException {
		String deleteNaics = "DELETE FROM NAICS WHERE NAICSCode =?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteNaics);
			deleteStmt.setInt(1, naics.getNaicsCode());
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
	

}
