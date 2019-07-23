package perm.model;

import java.sql.Date;

public class Job {

	protected long jobId;
	protected String city;
	protected String state;
	protected String code;
	protected String jobTitle;
	protected EducationLevel education;
	protected String educationOther;
	protected String major;
	protected AspectRequired requiresTraining;
	protected int trainingMonths;
	protected String trainingField;
	protected AspectRequired requiresExp;
	protected int expMonths;
	protected AspectRequired requiresAltField;
	protected String altFieldName;
	protected EducationLevel comboEduExpDegree;
	protected String comboEduExpDegreeOther;
	protected String comboEduExpYrs;
	protected int wageOfferFrom9089;
	protected int wageOfferTo9089;
	protected PayUnit wageOfferUnit;
	protected Level level9089;
	protected int amount;
	protected PayUnit unitOfPay;
	protected Source sourceName;
	protected String sourceNameOther;
	protected Date determDate;
	protected Date expirationDate;
	protected NAICS naics;
	protected SOCSystem socSystem;
	
	public enum EducationLevel {
		HighSchool,Associate,Bachelor,Master,Doctorate,None,Other
	}

	public enum AspectRequired {
		Y,N
	}
	
	public enum PayUnit {
		Hour, Week, BiWeekly, Month, Year
	}
	
	public enum Level {
		LevelI, LevelII, LevelIII, LevelIV, NA
	}
	
	public enum Source {
		CBA, DBA, EmployerConducted, OES, Other, SCA	
	}

	public Job(long jobId, String city, String state, String code, String jobTitle, EducationLevel education,
			String educationOther, String major, AspectRequired requiresTraining, int trainingMonths,
			String trainingField, AspectRequired requiresExp, int expMonths, AspectRequired requiresAltField,
			String altFieldName, EducationLevel comboEduExpDegree, String comboEduExpDegreeOther, String comboEduExpYrs,
			int wageOfferFrom9089, int wageOfferTo9089, PayUnit wageOfferUnit, Level level9089, int amount,
			PayUnit unitOfPay, Source sourceName, String sourceNameOther, Date determDate, Date expirationDate,
			NAICS naics, SOCSystem socSystem) {
		super();
		this.jobId = jobId;
		this.city = city;
		this.state = state;
		this.code = code;
		this.jobTitle = jobTitle;
		this.education = education;
		this.educationOther = educationOther;
		this.major = major;
		this.requiresTraining = requiresTraining;
		this.trainingMonths = trainingMonths;
		this.trainingField = trainingField;
		this.requiresExp = requiresExp;
		this.expMonths = expMonths;
		this.requiresAltField = requiresAltField;
		this.altFieldName = altFieldName;
		this.comboEduExpDegree = comboEduExpDegree;
		this.comboEduExpDegreeOther = comboEduExpDegreeOther;
		this.comboEduExpYrs = comboEduExpYrs;
		this.wageOfferFrom9089 = wageOfferFrom9089;
		this.wageOfferTo9089 = wageOfferTo9089;
		this.wageOfferUnit = wageOfferUnit;
		this.level9089 = level9089;
		this.amount = amount;
		this.unitOfPay = unitOfPay;
		this.sourceName = sourceName;
		this.sourceNameOther = sourceNameOther;
		this.determDate = determDate;
		this.expirationDate = expirationDate;
		this.naics = naics;
		this.socSystem = socSystem;
	}

	public Job(long jobId) {
		super();
		this.jobId = jobId;
	}

	public Job(String city, String state, String code, String jobTitle, EducationLevel education, String educationOther,
			String major, AspectRequired requiresTraining, int trainingMonths, String trainingField,
			AspectRequired requiresExp, int expMonths, AspectRequired requiresAltField, String altFieldName,
			EducationLevel comboEduExpDegree, String comboEduExpDegreeOther, String comboEduExpYrs,
			int wageOfferFrom9089, int wageOfferTo9089, PayUnit wageOfferUnit, Level level9089, int amount,
			PayUnit unitOfPay, Source sourceName, String sourceNameOther, Date determDate, Date expirationDate,
			NAICS naics, SOCSystem socSystem) {
		super();
		this.city = city;
		this.state = state;
		this.code = code;
		this.jobTitle = jobTitle;
		this.education = education;
		this.educationOther = educationOther;
		this.major = major;
		this.requiresTraining = requiresTraining;
		this.trainingMonths = trainingMonths;
		this.trainingField = trainingField;
		this.requiresExp = requiresExp;
		this.expMonths = expMonths;
		this.requiresAltField = requiresAltField;
		this.altFieldName = altFieldName;
		this.comboEduExpDegree = comboEduExpDegree;
		this.comboEduExpDegreeOther = comboEduExpDegreeOther;
		this.comboEduExpYrs = comboEduExpYrs;
		this.wageOfferFrom9089 = wageOfferFrom9089;
		this.wageOfferTo9089 = wageOfferTo9089;
		this.wageOfferUnit = wageOfferUnit;
		this.level9089 = level9089;
		this.amount = amount;
		this.unitOfPay = unitOfPay;
		this.sourceName = sourceName;
		this.sourceNameOther = sourceNameOther;
		this.determDate = determDate;
		this.expirationDate = expirationDate;
		this.naics = naics;
		this.socSystem = socSystem;
	}

	public long getJobId() {
		return jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public EducationLevel getEducation() {
		return education;
	}

	public void setEducation(EducationLevel education) {
		this.education = education;
	}

	public String getEducationOther() {
		return educationOther;
	}

	public void setEducationOther(String educationOther) {
		this.educationOther = educationOther;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public AspectRequired getRequiresTraining() {
		return requiresTraining;
	}

	public void setRequiresTraining(AspectRequired requiresTraining) {
		this.requiresTraining = requiresTraining;
	}

	public int getTrainingMonths() {
		return trainingMonths;
	}

	public void setTrainingMonths(int trainingMonths) {
		this.trainingMonths = trainingMonths;
	}

	public String getTrainingField() {
		return trainingField;
	}

	public void setTrainingField(String trainingField) {
		this.trainingField = trainingField;
	}

	public AspectRequired getRequiresExp() {
		return requiresExp;
	}

	public void setRequiresExp(AspectRequired requiresExp) {
		this.requiresExp = requiresExp;
	}

	public int getExpMonths() {
		return expMonths;
	}

	public void setExpMonths(int expMonths) {
		this.expMonths = expMonths;
	}

	public AspectRequired getRequiresAltField() {
		return requiresAltField;
	}

	public void setRequiresAltField(AspectRequired requiresAltField) {
		this.requiresAltField = requiresAltField;
	}

	public String getAltFieldName() {
		return altFieldName;
	}

	public void setAltFieldName(String altFieldName) {
		this.altFieldName = altFieldName;
	}

	public EducationLevel getComboEduExpDegree() {
		return comboEduExpDegree;
	}

	public void setComboEduExpDegree(EducationLevel comboEduExpDegree) {
		this.comboEduExpDegree = comboEduExpDegree;
	}

	public String getComboEduExpDegreeOther() {
		return comboEduExpDegreeOther;
	}

	public void setComboEduExpDegreeOther(String comboEduExpDegreeOther) {
		this.comboEduExpDegreeOther = comboEduExpDegreeOther;
	}

	public String getComboEduExpYrs() {
		return comboEduExpYrs;
	}

	public void setComboEduExpYrs(String comboEduExpYrs) {
		this.comboEduExpYrs = comboEduExpYrs;
	}

	public int getWageOfferFrom9089() {
		return wageOfferFrom9089;
	}

	public void setWageOfferFrom9089(int wageOfferFrom9089) {
		this.wageOfferFrom9089 = wageOfferFrom9089;
	}

	public int getWageOfferTo9089() {
		return wageOfferTo9089;
	}

	public void setWageOfferTo9089(int wageOfferTo9089) {
		this.wageOfferTo9089 = wageOfferTo9089;
	}

	public PayUnit getWageOfferUnit() {
		return wageOfferUnit;
	}

	public void setWageOfferUnit(PayUnit wageOfferUnit) {
		this.wageOfferUnit = wageOfferUnit;
	}

	public Level getLevel9089() {
		return level9089;
	}

	public void setLevel9089(Level level9089) {
		this.level9089 = level9089;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public PayUnit getUnitOfPay() {
		return unitOfPay;
	}

	public void setUnitOfPay(PayUnit unitOfPay) {
		this.unitOfPay = unitOfPay;
	}

	public Source getSourceName() {
		return sourceName;
	}

	public void setSourceName(Source sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceNameOther() {
		return sourceNameOther;
	}

	public void setSourceNameOther(String sourceNameOther) {
		this.sourceNameOther = sourceNameOther;
	}

	public Date getDetermDate() {
		return determDate;
	}

	public void setDetermDate(Date determDate) {
		this.determDate = determDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public NAICS getNaics() {
		return naics;
	}

	public void setNaics(NAICS naics) {
		this.naics = naics;
	}

	public SOCSystem getSocSystem() {
		return socSystem;
	}

	public void setSocSystem(SOCSystem socSystem) {
		this.socSystem = socSystem;
	}
	
	
	

}
