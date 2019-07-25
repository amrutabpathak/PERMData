package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import perm.dao.ApplicationDao;
import perm.model.Application;




@WebServlet("/findapplication")
public class FindApplication extends HttpServlet {
	
	ApplicationDao applicationDao;
	
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

        Application application; 
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String caseNumber = req.getParameter("caseNumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("success", "Please enter a valid caseNumber.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	application = applicationDao.getApplicationFromCaseNumber(caseNumber);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + caseNumber);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousCaseNumber", caseNumber);
        }
        req.setAttribute("application", application);
        
        req.getRequestDispatcher("/FindApplication.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Application application;
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String caseNumber = req.getParameter("casenumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("success", "Please enter a case number.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
        		application = applicationDao.getApplicationFromCaseNumber(caseNumber);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + caseNumber);
        }
        req.setAttribute("application", application);
        
        req.getRequestDispatcher("/FindApplication.jsp").forward(req, resp);
    }
}
