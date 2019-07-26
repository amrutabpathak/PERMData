package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perm.dao.ApplicationDao;
import perm.model.Application;



@WebServlet("/applicationupdate")
public class ApplicationUpdate extends HttpServlet {
	
	protected ApplicationDao applicationDao;
	
	
	@Override
	public void init() throws ServletException {
		applicationDao = ApplicationDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing message
		// s.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String caseNumber = req.getParameter("casenumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("success", "Please enter a valid caseNumber.");
        } else {
        	try {
        		Application application = applicationDao.getApplicationFromCaseNumber(caseNumber);
        		if(application == null) {
        			messages.put("success", "caseNumber does not exist.");
        		}
        		req.setAttribute("application", application);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicationUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String caseNumber = req.getParameter("caseNumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("success", "Please enter a valid caseNumber.");
        }else {
        		Application application = applicationDao.getApplicationFromCaseNumber(caseNumber);
        		if(application == null) {
        			messages.put("success", "caseNumber does not exist. No update to perform.");
        		} else {
					String scheduled = req.getParameter("scheduled");
					try {

						application = applicationDao.updateScheduled(application,Boolean.parseBoolean(scheduled));
						messages.put("success", "Successfully created " + caseNumber);
					} catch (SQLException e) {
						e.printStackTrace();
						throw new IOException(e);
					}
        		}
        		req.setAttribute("application", application);

        }
        
        req.getRequestDispatcher("/ApplicationUpdate.jsp").forward(req, resp);
    }
	

}
