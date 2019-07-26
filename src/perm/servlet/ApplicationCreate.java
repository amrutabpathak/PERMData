package perm.servlet;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perm.dao.ApplicationDao;
import perm.model.Agent;
import perm.model.Application;
import perm.model.Application.CaseStatus;


@WebServlet("/applicationcreate")
public class ApplicationCreate extends HttpServlet {
	
protected ApplicationDao applicationDao;
	
	@Override
	public void init() throws ServletException {
		applicationDao = ApplicationDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/ApplicationCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String caseNumber = req.getParameter("casenumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("success", "Invalid CaseNumber");
        } else {
        	// Create the BlogUser.
        	String decistionDatestr = req.getParameter("decistiondate"); //check
			Applicants.EducationLevel education = Applicants.EducationLevel.fromString(req.getParameter("Education"));
            Application.CaseStatus caseStatus = Application.CaseStatus.fromString(req.getParameter("casestatus"));
			String caseReceivedDatestr = req.getParameter("casereceiveddate"); //check
			boolean refile = req.getParameter("refile").equals("true")? true: false;
			String originalFileDatestr = req.getParameter("originalfiledate"); //check
			boolean scheduled = req.getParameter("scheduled").equals("true")? true: false;
			String employerName = req.getParameter("employername");
			int applicantId = Integer.parseInt(req.getParameter("applicantid"));
			String agentFirmName = req.getParameter("agentfirmname");
			
        	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	java.util.Date date = new java.util.Date();
        	
        	Date decistionDate = new Date(date.getTime());
			try {
				decistionDate = new Date(dateFormat.parse(decistionDatestr).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	Date caseReceivedDate =  new Date(date.getTime());
			try {
				caseReceivedDate = new Date(dateFormat.parse(caseReceivedDatestr).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
        	Date originalFileDate =  new Date(date.getTime());
			try {
				originalFileDate = new Date(dateFormat.parse(originalFileDatestr).getTime());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Application application = new Application(caseNumber, decistionDate, caseStatus, caseReceivedDate, refile, originalFileDate ,scheduled,employerName,applicantId,agentFirmName);
	        	application = applicationDao.create(application);
	        	messages.put("success", "Successfully created " + application.getCaseNumber());
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicationCreate.jsp").forward(req, resp);
    }

}
