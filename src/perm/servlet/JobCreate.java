package perm.servlet;

import perm.dao.JobDao;
import perm.model.Naics;
import perm.model.SOCSystem;
import perm.model.Job;
import perm.model.Job.AspectRequired;
import perm.model.Job.EducationLevel;
import perm.model.Job.Level;
import perm.model.Job.PayUnit;
import perm.model.Job.Source;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jobcreate")
public class JobCreate extends HttpServlet {
	
	protected JobDao jobDao;
	
	@Override
	public void init() throws ServletException {
		jobDao = JobDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/JobCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);


        	// Create the BlogUser.
        String city = req.getParameter("city");
		String state = req.getParameter("state");
		String code = req.getParameter("code");
		String jobTitle = req.getParameter("jobtitle");
		String education = req.getParameter("education");
		String educationOther = req.getParameter("educationother");
		String major = req.getParameter("major");
		String requiresTraining =req.getParameter("requirestraining");
		String trainingMonths = req.getParameter("TrainingMonths");
		
		String trainingField = req.getParameter("TrainingField");
		String requiresExp =req.getParameter("requiresexp");
		String expMonths = req.getParameter("expmonths");
		String requiresAltField = req.getParameter("requiresaltfield");
		String altFieldName = req.getParameter("altfieldname");
		String comboEduExpDegree = req.getParameter("comboeduexpdegree");
		String comboEduExpDegreeOther = req.getParameter("comboeduexpdegreeother");
		String comboEduExpYrs = req.getParameter("comboeduexpyrs");
		
		String wageOfferFrom9089 = req.getParameter("wageofferfrom9089");
		String wageOfferTo9089 = req.getParameter("wageofferto9089");
		
		String wageOfferUnit = req.getParameter("wageofferunit");
		String level9089 = req.getParameter("level9089");
		String amount = req.getParameter("amount");
		String unitOfPay = req.getParameter("unitofpay");
		String sourceName = req.getParameter("sourcename");	
		
		String sourceNameOther = req.getParameter("sourcenameother");
		String determDateStr = req.getParameter("determdate");
		String expirationDateStr = req.getParameter("expirationdate");
		String prevailingWageSocCode = req.getParameter("prevailingwagesoccode");
		String naicsCode = req.getParameter("naicscode");
		String socSystem = req.getParameter("socsystem");
		SOCSystem s = new SOCSystem(socSystem);
		
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	java.util.Date date = new java.util.Date();
        	
        	Date determDate = new Date(date.getTime());
			try {
				determDate = new Date(dateFormat.parse(determDateStr).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	Date expirationDate =  new Date(date.getTime());
			try {
				expirationDate = new Date(dateFormat.parse(expirationDateStr).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try {
	        	Job job = new Job(city,state,code, jobTitle, EducationLevel.get(education),  educationOther,
	        			 major, AspectRequired.valueOf(requiresTraining) , Integer.parseInt(trainingMonths) , trainingField,
	        			AspectRequired.valueOf(requiresExp) , Integer.parseInt(expMonths), AspectRequired.valueOf(requiresAltField) , altFieldName,
	        			EducationLevel.get(comboEduExpDegree) , comboEduExpDegreeOther, comboEduExpYrs,
	        			Integer.parseInt( wageOfferFrom9089), Integer.parseInt(wageOfferTo9089), PayUnit.get(wageOfferUnit) , Level.get(level9089) , Integer.parseInt(amount),
	        			PayUnit.get(unitOfPay) , Source.get(sourceName) , sourceNameOther, determDate, expirationDate,
	        			null, s);
	        	job = jobDao.create(job);
	        	messages.put("success", "Successfully created " + job.getJobId());
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        
        
        req.getRequestDispatcher("/JobCreate.jsp").forward(req, resp);
    }
}
