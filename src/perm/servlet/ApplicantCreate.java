package perm.servlet;

import perm.dao.*;
import perm.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/applicantcreate")
public class ApplicantCreate extends HttpServlet{
	protected ApplicantsDao applicantDao;
	
	@Override
	public void init() throws ServletException {
		applicantDao = ApplicantsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages); 
        req.getRequestDispatcher("/ApplicantCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

   
        	JobDao jobsDao = JobDao.getInstance();
			EmployerDao employersDao = EmployerDao.getInstance();
        	String city = req.getParameter("City");
			String state = req.getParameter("State");
			String code = req.getParameter("Code");
			String citizenship = req.getParameter("Citizenship");
			String birthCountry = req.getParameter("BirthCountry");
			String admissionClass = req.getParameter("AdmissionClass");
			Applicants.EducationLevel education = Applicants.EducationLevel.valueOf(req.getParameter("Education"));
			String educationOther = req.getParameter("EducationOther");
			String major = req.getParameter("Major");
			String yearCompleted = req.getParameter("YearCompleted");
			String institution = req.getParameter("Institution");
			long jobId = Long.parseLong(req.getParameter("JobId"));	
			String employerName = req.getParameter("EmployerName");
		
			try {
				Job job = jobsDao.getJobById(jobId);
				Employer employer = employersDao.getEmployerByName(employerName);
	        	Applicants applicant = new Applicants(city,state,code,citizenship,birthCountry,admissionClass,education,educationOther,major,yearCompleted,institution,job,employer);
	        	applicant = applicantDao.create(applicant);
	        	messages.put("success", "Successfully created " + applicant.getApplicantId());
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        
        
			req.getRequestDispatcher("/ApplicantCreate.jsp").forward(req, resp);
    }
}

