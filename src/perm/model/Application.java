package perm.model;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import perm.model.Job.EducationLevel;

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



public class Application {
	protected String caseNumber;
	protected Date decistionDate;
	protected CaseStatus caseStatus;
	protected boolean refile;
	protected Date caseReceivedDate;
	protected Date originalFileDate;
	protected boolean scheduled;
	protected String employerName;
	protected long applicantId;
	protected String agentFirmName;
	
	
	
	
	public enum CaseStatus {
		Denied("Denied"),
		CertifiedExpired("CertifiedExpired"),
		Certified("Certified");
		
	    private String name;

	    CaseStatus(String name) {
	        this.name = name;
	    }

	    public static CaseStatus fromString(String s) {
	    	for (CaseStatus e : values()) {
	    		if (e.name.equals(s)) {
	    			return e;
	    		}
	    	}
	    	return Denied;
		}
	}
	
	public Application(String caseNumber,Date decistionDate, CaseStatus caseStatus, Date caseReceivedDate, boolean refile, 
			Date originalFileDate, boolean scheduled, String employerName, long applicantId, String agentFirmName) {
		super();
		this.caseNumber = caseNumber;
		this.decistionDate = decistionDate;
		this.caseStatus = caseStatus;
		this.refile = refile;
		this.caseReceivedDate = caseReceivedDate;
		this.originalFileDate = originalFileDate;
		this.scheduled = scheduled;
		this.employerName = employerName;
		this.applicantId = applicantId;
		this.agentFirmName = agentFirmName;
	}
	
	public Application(String caseNumber) {
		this.caseNumber = caseNumber; 
	}


	public Application() {
		// TODO Auto-generated constructor stub
	}

	public String getCaseNumber() {
		return caseNumber;
	}


	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}


	public Date getDecistionDate() {
		return decistionDate;
	}


	public void setDecistionDate(Date decistionDate) {
		this.decistionDate = decistionDate;
	}


	public CaseStatus getCaseStatus() {
		return caseStatus;
	}


	public void setCaseStatus(CaseStatus caseStatus) {
		this.caseStatus = caseStatus;
	}


	public boolean isRefile() {
		return refile;
	}


	public void setRefile(boolean refile) {
		this.refile = refile;
	}


	public Date getCaseReceivedDate() {
		return caseReceivedDate;
	}


	public void setCaseReceivedDate(Date caseReceivedDate) {
		this.caseReceivedDate = caseReceivedDate;
	}


	public Date getOriginalFileDate() {
		return originalFileDate;
	}


	public void setOriginalFileDate(Date originalFileDate) {
		this.originalFileDate = originalFileDate;
	}


	public boolean isScheduled() {
		return scheduled;
	}


	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}


	public String getEmployerName() {
		return employerName;
	}


	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}


	public long getApplicantId() {
		return applicantId;
	}


	public void setApplicantId(long applicantId) {
		this.applicantId = applicantId;
	}


	public String getAgentFirmName() {
		return agentFirmName;
	}


	public void setAgentFirmName(String agentFirmName) {
		this.agentFirmName = agentFirmName;
	}
	


	

}
