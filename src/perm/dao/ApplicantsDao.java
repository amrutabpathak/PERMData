package perm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import perm.model.*;

public class ApplicantsDao {
	protected ConnectionManager connectionManager;

	private static ApplicantsDao instance = null;

	protected ApplicantsDao() {
		connectionManager = new ConnectionManager();
	}

	public static ApplicantsDao getInstance() {
		if (instance == null) {
			instance = new ApplicantsDao();
		}
		return instance;
	}

	public Applicants create(Applicants applicant) throws SQLException {
		String insertApplicant = "INSERT INTO Applicants(City,State,Code,Citizenship,BirthCountry,AdmissionClass,Education,EducationOther,Major,YearCompleted,Institution,JobID,EmployerName,ApplicantID) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			insertStmt = connection.prepareStatement(insertApplicant, Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, applicant.getCity());
			insertStmt.setString(2, applicant.getState());
			insertStmt.setString(3, applicant.getCode());
			insertStmt.setString(4, applicant.getCitizenship());
			insertStmt.setString(5, applicant.getBirthCountry());
			insertStmt.setString(6, applicant.getAdmissionClass());
			insertStmt.setString(7, applicant.getEducation().name());
			insertStmt.setString(8, applicant.getEducationOther());
			insertStmt.setString(9, applicant.getMajor());
			insertStmt.setString(10, applicant.getYearCompleted());
			insertStmt.setString(11, applicant.getInstitution());
			insertStmt.setLong(12, applicant.getJob().getJobId());
			insertStmt.setString(13, applicant.getEmployer().getName());
			insertStmt.setLong(14, applicant.getApplicantId());

			insertStmt.executeUpdate();
			return applicant;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (insertStmt != null) {
				insertStmt.close();
			}
			if (resultKey != null) {
				resultKey.close();
			}
		}
	}

	public Applicants updateAdmissionClass(Applicants applicant, String newAdmissionClass) throws SQLException {
		String updateApplicant = "UPDATE Applicants SET AdmissionClass=? WHERE ApplicantID=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateApplicant);
			updateStmt.setString(1, newAdmissionClass);
			updateStmt.setLong(2, applicant.getApplicantId());
			updateStmt.executeUpdate();

			
			applicant.setAdmissionClass(newAdmissionClass);

			return applicant;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (updateStmt != null) {
				updateStmt.close();
			}
		}
	}

	public Applicants delete(Applicants applicant) throws SQLException {
		String deleteApplicant = "DELETE FROM Applicants WHERE ApplicantID=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteApplicant);
			deleteStmt.setLong(1, applicant.getApplicantId());
			deleteStmt.executeUpdate();

			// Return null so the caller can no longer operate on the BlogComments instance.
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (deleteStmt != null) {
				deleteStmt.close();
			}
		}
	}

	public Applicants getApplicantById(long applicantId) throws SQLException {
		String selectApplicant = "SELECT City,State,Code,Citizenship,BirthCountry,AdmissionClass,Education,EducationOther,Major,YearCompleted,Institution,JobID,EmployerName "
				+ "FROM Applicants " + "WHERE ApplicantID=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplicant);
			selectStmt.setLong(1, applicantId);
			results = selectStmt.executeQuery();

			JobDao jobsDao = JobDao.getInstance();
			EmployerDao employersDao = EmployerDao.getInstance();

			if (results.next()) {
				String city = results.getString("City");
				String state = results.getString("State");
				String code = results.getString("Code");
				String citizenship = results.getString("Citizenship");
				String birthCountry = results.getString("BirthCountry");
				String admissionClass = results.getString("AdmissionClass");
				Applicants.EducationLevel education = Applicants.EducationLevel.fromString(results.getString("Education"));
				String educationOther = results.getString("EducationOther");
				String major = results.getString("Major");
				String yearCompleted = results.getString("YearCompleted");
				String institution = results.getString("Institution");
				Long jobId = results.getLong("JobId");
				String employerName = results.getString("EmployerName");

				Job job = jobsDao.getJobById(jobId);
				Employer employer = employersDao.getEmployerByName(employerName);
				Applicants applicant = new Applicants(applicantId, city, state, code, citizenship, birthCountry,
						admissionClass, education, educationOther, major, yearCompleted, institution, job, employer);
				return applicant;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return null;
	}

	
	public List<Applicants> getApplicantsByAdmissionClass(String admissionClass) throws SQLException {
		List<Applicants> applicants = new ArrayList<Applicants>();
		String selectApplicants = "SELECT ApplicantID,City,State,Code,Citizenship,BirthCountry,AdmissionClass,Education,EducationOther,Major,YearCompleted,Institution,JobID,EmployerName "
				+ "From Applicants "
				+ "WHERE AdmissionClass=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplicants);
			selectStmt.setString(1, admissionClass);
			results = selectStmt.executeQuery();
			
			JobDao jobsDao = JobDao.getInstance();
			EmployerDao employersDao = EmployerDao.getInstance();
			while (results.next()) {
				long resultApplicantId = results.getLong("ApplicantID");
				String city = results.getString("City");
				String state = results.getString("State");
				String code = results.getString("Code");
				String citizenship = results.getString("Citizenship");
				String birthCountry = results.getString("BirthCountry");
				String resultAdmissionClass = results.getString("AdmissionClass");
				Applicants.EducationLevel education = Applicants.EducationLevel.fromString((results.getString("Education")));
				String educationOther = results.getString("EducationOther");
				String major = results.getString("Major");
				String yearCompleted = results.getString("YearCompleted");
				String institution = results.getString("Institution");
				Long jobId = results.getLong("JobId");					
				String employerName = results.getString("EmployerName");

				Job job = jobsDao.getJobById(jobId);
				Employer employer = employersDao.getEmployerByName(employerName);
				Applicants applicant = new Applicants(resultApplicantId, city, state, code, citizenship, birthCountry,
						resultAdmissionClass, education, educationOther, major, yearCompleted, institution, job, employer);
				applicants.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return applicants;
	}

	
	public List<Applicants> getApplicantsByBirthCountry(String birthCountry) throws SQLException {
		List<Applicants> applicants = new ArrayList<Applicants>();
		String selectApplicants = "SELECT ApplicantID,City,State,Code,Citizenship,BirthCountry,AdmissionClass,Education,EducationOther,Major,YearCompleted,Institution,JobID,EmployerName "
				+ "From Applicants "
				+ "WHERE BirthCountry=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectApplicants);
			selectStmt.setString(1, birthCountry);
			results = selectStmt.executeQuery();
			
			JobDao jobsDao = JobDao.getInstance();
			EmployerDao employersDao = EmployerDao.getInstance();
			while (results.next()) {
				long resultApplicantId = results.getLong("ApplicantID");
				String city = results.getString("City");
				String state = results.getString("State");
				String code = results.getString("Code");
				String citizenship = results.getString("Citizenship");
				String resultBirthCountry = results.getString("BirthCountry");
				String admissionClass = results.getString("AdmissionClass");
				Applicants.EducationLevel education = Applicants.EducationLevel.fromString((results.getString("Education")));
				String educationOther = results.getString("EducationOther");
				String major = results.getString("Major");
				String yearCompleted = results.getString("YearCompleted");
				String institution = results.getString("Institution");
				Long jobId = results.getLong("JobId");					
				String employerName = results.getString("EmployerName");

				Job job = jobsDao.getJobById(jobId);
				Employer employer = employersDao.getEmployerByName(employerName);
				Applicants applicant = new Applicants(resultApplicantId, city, state, code, citizenship, resultBirthCountry,admissionClass, education, educationOther, major, yearCompleted, institution, job, employer);
				applicants.add(applicant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (connection != null) {
				connection.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (results != null) {
				results.close();
			}
		}
		return applicants;
	}
}
