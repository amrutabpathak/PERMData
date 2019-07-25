package perm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import perm.model.Application;

/**
 * 
 * 
CREATE TABLE Application (
CaseNumber VARCHAR(255),
DecistionDate DATE,
CaseStatus ENUM('Denied', 'Certified-Expired', 'Certified'),
CaseReceivedDate DATE,
Refile BOOLEAN,
OriginalFileDate DATE,
Scheduled BOOLEAN,
EmployerName VARCHAR(255),
ApplicantID BIGINT,
AgentFirmName VARCHAR(255),
CONSTRAINT pk_Application_CaseNumber PRIMARY KEY (CaseNumber),
CONSTRAINT fk_Application_EmployerName FOREIGN KEY (EmployerName)
REFERENCES Employer (EmployerName)
ON UPDATE CASCADE ON DELETE SET NULL,
CONSTRAINT fk_Application_ApplicantId FOREIGN KEY (ApplicantID)
REFERENCES Applicants (ApplicantID)
ON UPDATE CASCADE ON DELETE SET NULL,
CONSTRAINT fk_Application_AgentFirmName FOREIGN KEY (AgentFirmName)
REFERENCES Agent (FirmName)
ON UPDATE CASCADE ON DELETE SET NULL
);
 *
 */


public class ApplicationDao {
	
	protected ConnectionManager connectionManager;

	private static ApplicationDao instance = null;
	
	protected ApplicationDao() {
		connectionManager = new ConnectionManager();
	}
	public static ApplicationDao getInstance() {
		if(instance == null) {
			instance = new ApplicationDao();
		}
		return instance;
	}
	
	public Application create(Application application) throws SQLException {
		String selectApplication = "INSERT INTO Application(CaseNumber,DecistonDate,CaseStatus,CaseReceivedDate,Refile,OriginalFileDate,Scheduled,EmployerName,ApplicantID,AgentFirmName) VALUES(?,?,?,?,?,?,?,?,?,?);";	
		Connection connection = null;
		PreparedStatement selectStmt = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplication);
			selectStmt.setString(1,  application.getCaseNumber());
			selectStmt.setDate(2,application.getDecistionDate());
			selectStmt.setString(3, application.getCaseStatus().name());
			selectStmt.setDate(4, application.getCaseReceivedDate());
			selectStmt.setBoolean(5,  application.isRefile());			
			selectStmt.setDate(6, application.getOriginalFileDate());
			selectStmt.setBoolean(7, application.isScheduled());
			selectStmt.setString(8, application.getEmployerName());
			selectStmt.setLong(9, application.getApplicantId());
			selectStmt.setString(10, application.getAgentFirmName());
			selectStmt.executeUpdate();
			return application;
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
		}
	}
	

	/**
	 * Update the Scheduled of the Application instance.
	 */
	public Application updateScheduled(Application application, boolean scheduled) throws SQLException {
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
	 * Delete the Application instance.
	 */
	public Application delete(Application application) throws SQLException {
		String deleteApplication = "DELETE FROM Application WHERE CaseNumber =?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteApplication);
			deleteStmt.setString(1, application.getCaseNumber());
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
	 * Get the Application record by fetching it from your MySQL instance.
	 * This runs a SELECT statement and returns a single Application instance.
	 */
	public Application getApplicationFromCaseNumber(String caseNumber) throws SQLException {
		String selectApplication = "SELECT CaseNumber, DecisionDate ,CaseStatus ,CaseReceivedDate ," + 
				"Refile ,OriginalFileDate ,Scheduled ,EmployerName ," + 
				"ApplicantID ,AgentFirmName FROM Application WHERE CaseNumber =?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplication);
			selectStmt.setString(1, caseNumber);
			results = selectStmt.executeQuery();
			if(results.next()) {
				String resultCaseNumber = results.getString("CaseNumber");
				Date decistionDate = results.getDate("DecistionDate");
				Application.CaseStatus caseStatus = Application.CaseStatus.valueOf(results.getString("CaseStatus"));
				Date caseReceivedDate = results.getDate("caseReceivedDate");
				boolean refile = results.getBoolean("Refile");
				Date originalFileDate = results.getDate("OriginalFileDate");
				boolean scheduled = results.getBoolean("Scheduled");
				String employerName = results.getString("EmployerName");
				long applicantId= results.getLong("ApplicantId");
				String agentFirmName = results.getString("AgentFirmName");
				return new Application(resultCaseNumber, decistionDate, caseStatus, caseReceivedDate, refile, originalFileDate, scheduled, employerName, applicantId, agentFirmName);
				
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



}
