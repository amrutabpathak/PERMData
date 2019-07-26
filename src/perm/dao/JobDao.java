package perm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import perm.model.Job;
import perm.model.SOCSystem;
import perm.model.Job.AspectRequired;
import perm.model.Job.EducationLevel;
import perm.model.Job.Level;
import perm.model.Job.PayUnit;
import perm.model.Job.Source;
import perm.model.Naics;

public class JobDao {

	protected ConnectionManager connectionManager;

	private static JobDao instance = null;
	protected JobDao() {
		connectionManager = new ConnectionManager();
	}
	public static JobDao getInstance() {
		if(instance == null) {
			instance = new JobDao();
		}
		return instance;
	}
	

	public Job create(Job job) throws SQLException {
		String insertJob =
			"INSERT INTO Job(City ,State ,Code ,JobTitle ,Education ,EducationOther , " + 
			" Major ,RequiresTraining, TrainingMonths ,TrainingField ,RequiresExp,ExpMonths ,RequiresAltField ,AltFieldName ,"+
			" ComboEduExpDegree ,ComboEduExpDegreeOther ,ComboEduExpYrs ,WageOfferFrom9089 ,WageOfferTo9089 ,"+
			" WageOfferUnit ,Level9089 ,Amount ,UnitOfPay ,SourceName ,SourceNameOther ,DetermDate ,ExpirationDate ,"+
			" PrevailingWageSocCode ,NAICSCode,JobID ) " +
			"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Connection connection = null;
		PreparedStatement insertStmt = null;
		ResultSet resultKey = null;
		try {
			connection = connectionManager.getConnection();
			// Job has an auto-generated key. So we want to retrieve that key.
			insertStmt = connection.prepareStatement(insertJob,
				Statement.RETURN_GENERATED_KEYS);
			insertStmt.setString(1, job.getCity());
			insertStmt.setString(2, job.getState());
			insertStmt.setString(3, job.getCode());
			insertStmt.setString(4, job.getJobTitle());
			insertStmt.setString(5, EducationLevel.valueOf(job.getEducation().name()).educationLevelValue());
			insertStmt.setString(6, job.getEducationOther());
			insertStmt.setString(7, job.getMajor());
			insertStmt.setString(8, job.getRequiresTraining().name());
			insertStmt.setInt(9, job.getTrainingMonths());
			insertStmt.setString(10, job.getTrainingField());
			insertStmt.setString(11, job.getRequiresExp().name());
			insertStmt.setInt(12, job.getExpMonths());
			insertStmt.setString(13, job.getRequiresAltField().name());
			insertStmt.setString(14, job.getAltFieldName());
			insertStmt.setString(15, EducationLevel.valueOf(job.getComboEduExpDegree().name()).educationLevelValue());
			insertStmt.setString(16, job.getComboEduExpDegreeOther());
			insertStmt.setString(17, job.getComboEduExpYrs());
			insertStmt.setInt(18, job.getWageOfferFrom9089());
			insertStmt.setInt(19, job.getWageOfferTo9089());
			insertStmt.setString(20, PayUnit.valueOf(job.getWageOfferUnit().name()).payUnitValues());
			insertStmt.setString(21, Level.valueOf(job.getLevel9089().name()).levelValue());
			insertStmt.setInt(22, job.getAmount());
			insertStmt.setString(23, PayUnit.valueOf(job.getUnitOfPay().name()).payUnitValues());
			insertStmt.setString(24, Source.valueOf(job.getSourceName().name()).sourceValue());
			insertStmt.setString(25, job.getSourceNameOther());
			insertStmt.setDate(26, job.getDetermDate());
			insertStmt.setDate(27, job.getExpirationDate());
			insertStmt.setString(28,job.getSocSystem().getPrevailingWageSocCode());
			insertStmt.setInt(29,  job.getNaics().getNaicsCode());
			insertStmt.setLong(30,job.getJobId());
			insertStmt.executeUpdate();
			return job;
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
			if(resultKey != null) {
				resultKey.close();
			}
		}
	}
	
	/**
	 * Update the job title, amount of the Job instance.
	 */
	public Job updateContent(Job job, String jobTitle, int amount) throws SQLException {
		String updateJob = "UPDATE Job SET JobTitle=?,Amount =? WHERE JobId=?;";
		Connection connection = null;
		PreparedStatement updateStmt = null;
		try {
			connection = connectionManager.getConnection();
			updateStmt = connection.prepareStatement(updateJob);
			updateStmt.setString(1, jobTitle);
			updateStmt.setInt(2, amount);
			updateStmt.setLong(3, job.getJobId());
			updateStmt.executeUpdate();

			// Update the blogPost param before returning to the caller.
			job.setJobTitle(jobTitle);
			job.setAmount(amount);
			return job;
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
	 * Delete the Job instance.
	 * This runs a DELETE statement.
	 */
	public Job delete(Job job) throws SQLException {
		String deleteJob = "DELETE FROM Job WHERE JobId=?;";
		Connection connection = null;
		PreparedStatement deleteStmt = null;
		try {
			connection = connectionManager.getConnection();
			deleteStmt = connection.prepareStatement(deleteJob);
			deleteStmt.setLong(1, job.getJobId());
			deleteStmt.executeUpdate();

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

	public Job getJobById(long jobId) throws SQLException {
		String selectJob =
			"SELECT JobID, City ,State ,Code ,JobTitle ,Education ,EducationOther , " + 
			"Major ,RequiresTraining, TrainingMonths ,TrainingField ,RequiresExp,ExpMonths ,RequiresAltField ,AltFieldName ," + 
			"ComboEduExpDegree ,ComboEduExpDegreeOther ,ComboEduExpYrs ,WageOfferFrom9089 ,WageOfferTo9089 ," + 
			"WageOfferUnit ,Level9089 ,Amount ,UnitOfPay ,SourceName ,SourceNameOther ,DetermDate ,ExpirationDate ," + 
			"PrevailingWageSocCode ,NAICSCode "+
			"FROM Job " +
			"WHERE JobId=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectJob);
			selectStmt.setLong(1, jobId);
			results = selectStmt.executeQuery();
			JobDao jobDao = JobDao.getInstance();
			NaicsDao naicsDao = NaicsDao.getInstance();
			SOCSystemDao socSystemDao = SOCSystemDao.getInstance();
			
			if(results.next()) {
				long resultJobId = results.getLong("JobID");
				String city = results.getString("City");
				String state = results.getString("State");
				String code = results.getString("Code");
				String jobTitle = results.getString("JobTitle");
				Job.EducationLevel education = Job.EducationLevel.get(results.getString("Education"));
				String educationOther = results.getString("EducationOther");
				String major = results.getString("Major");
				Job.AspectRequired requiresTraining = Job.AspectRequired.valueOf(results.getString("RequiresTraining"));
				int trainingMonths = results.getInt("TrainingMonths");
				String trainingField = results.getString("TrainingField");
				Job.AspectRequired requiresExp = Job.AspectRequired.valueOf(results.getString("RequiresExp"));
				int expMonths = results.getInt("ExpMonths");
				Job.AspectRequired requiresAltField = Job.AspectRequired.valueOf(results.getString("RequiresAltField"));
				String altFieldName = results.getString("AltFieldName");
				Job.EducationLevel comboEduExpDegree = Job.EducationLevel.get(results.getString("ComboEduExpDegree"));
				String comboEduExpDegreeOther = results.getString("ComboEduExpDegreeOther");
				String comboEduExpYrs = results.getString("ComboEduExpYrs");
				
				int wageOfferFrom9089 = results.getInt("WageOfferFrom9089");
				int wageOfferTo9089 = results.getInt("WageOfferTo9089");
				Job.PayUnit wageOfferUnit = Job.PayUnit.get(results.getString("WageOfferUnit"));
				Job.Level level9089 = Job.Level.get(results.getString("Level9089"));
				int amount = results.getInt("Amount");
				Job.PayUnit unitOfPay = Job.PayUnit.get(results.getString("UnitOfPay"));
				Job.Source sourceName = Job.Source.get(results.getString("SourceName"));	
				
				String sourceNameOther = results.getString("SourceNameOther");
				Date determDate = results.getDate("DetermDate");
				Date expirationDate = results.getDate("ExpirationDate");
				String prevailingWageSocCode = results.getString("PrevailingWageSocCode");
				int naicsCode = results.getInt("NAICSCode");
				
				Naics naics = naicsDao.getNaicsFromNaicsCode(naicsCode);
				SOCSystem socSystem = socSystemDao.getSocSystemFromSocCode(prevailingWageSocCode);
				//change null field of constructor to naics
				Job job = new Job(jobId,city, state, code, jobTitle, education, educationOther, major, requiresTraining,
						trainingMonths, trainingField, requiresExp, expMonths, requiresAltField, altFieldName, comboEduExpDegree
						,comboEduExpDegreeOther, comboEduExpYrs, wageOfferFrom9089, wageOfferTo9089, wageOfferUnit, level9089
						, amount, unitOfPay, sourceName, sourceNameOther, determDate, expirationDate, naics, socSystem);
				return job;
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
	 * Get the all the Jobs for a SOC Code.
	 */
	public List<Job> getJobForSOCCode(SOCSystem socSystem) throws SQLException {
		List<Job> jobs = new ArrayList<Job>();
		String selectJobs=
				"SELECT JobId, City ,State ,Code ,JobTitle ,Education ,EducationOther , " + 
						"Major ,RequiresTraining, TrainingMonths ,TrainingField ,RequiresExp,ExpMonths ,RequiresAltField ,AltFieldName ," + 
						"ComboEduExpDegree ,ComboEduExpDegreeOther ,ComboEduExpYrs ,WageOfferFrom9089 ,WageOfferTo9089 ," + 
						"WageOfferUnit ,Level9089 ,Amount ,UnitOfPay ,SourceName ,SourceNameOther ,DetermDate ,ExpirationDate ," + 
						"PrevailingWageSocCode ,NAICSCode "+
			"FROM Job " +
			"WHERE PrevailingWageSocCode=?;";
		Connection connection = null;
		PreparedStatement selectStmt = null;
		ResultSet results = null;
		try {
			connection = connectionManager.getConnection();
			selectStmt = connection.prepareStatement(selectJobs);
			selectStmt.setString(1, socSystem.getPrevailingWageSocCode());
			results = selectStmt.executeQuery();
			NaicsDao naicsDao = NaicsDao.getInstance();
			SOCSystemDao socSystemDao = SOCSystemDao.getInstance();
			while(results.next()) {
				long jobId = results.getLong("JobId");
				String city = results.getString("City");
				String state = results.getString("State");
				String code = results.getString("Code");
				String jobTitle = results.getString("JobTitle");
				Job.EducationLevel education = Job.EducationLevel.get(results.getString("Education"));
				String educationOther = results.getString("EducationOther");
				String major = results.getString("Major");
				Job.AspectRequired requiresTraining = Job.AspectRequired.valueOf(results.getString("RequiresTraining"));
				int trainingMonths = results.getInt("TrainingMonths");
				String trainingField = results.getString("TrainingField");
				Job.AspectRequired requiresExp = Job.AspectRequired.valueOf(results.getString("RequiresExp"));
				int expMonths = results.getInt("ExpMonths");
				Job.AspectRequired requiresAltField = Job.AspectRequired.valueOf(results.getString("RequiresAltField"));
				String altFieldName = results.getString("AltFieldName");
				Job.EducationLevel comboEduExpDegree = Job.EducationLevel.get(results.getString("ComboEduExpDegree"));
				String comboEduExpDegreeOther = results.getString("ComboEduExpDegreeOther");
				String comboEduExpYrs = results.getString("ComboEduExpYrs");
				
				int wageOfferFrom9089 = results.getInt("WageOfferFrom9089");
				int wageOfferTo9089 = results.getInt("WageOfferTo9089");
				Job.PayUnit wageOfferUnit = Job.PayUnit.get(results.getString("WageOfferUnit"));
				Job.Level level9089 = Job.Level.get(results.getString("Level9089"));
				int amount = results.getInt("Amount");
				Job.PayUnit unitOfPay = Job.PayUnit.get(results.getString("UnitOfPay"));
				Job.Source sourceName = Job.Source.get(results.getString("SourceName"));	
				
				String sourceNameOther = results.getString("SourceNameOther");
				Date determDate = results.getDate("DetermDate");
				Date expirationDate = results.getDate("ExpirationDate");
				String prevailingWageSocCode = results.getString("PrevailingWageSocCode");
				int naicsCode = results.getInt("NAICSCode");
				//change null field of constructor to naics
				Naics naics = naicsDao.getNaicsFromNaicsCode(naicsCode);
				Job job = new Job(jobId,city, state, code, jobTitle, education, educationOther, major, requiresTraining,
						trainingMonths, trainingField, requiresExp, expMonths, requiresAltField, altFieldName, comboEduExpDegree
						,comboEduExpDegreeOther, comboEduExpYrs, wageOfferFrom9089, wageOfferTo9089, wageOfferUnit, level9089
						, amount, unitOfPay, sourceName, sourceNameOther, determDate, expirationDate, naics, socSystem);
				
				jobs.add(job);
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
		return jobs;
	}




}
