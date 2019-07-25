package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import perm.dao.ApplicationDao;
import perm.model.Application;



@WebServlet("/applicationdelete")
public class ApplicationDelete extends HttpServlet{

	
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
        // Provide a title and render the JSP.
        messages.put("title", "Delete Application");
        req.getRequestDispatcher("/ApplicationDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String caseNumber = req.getParameter("casenumber");
        if (caseNumber == null || caseNumber.trim().isEmpty()) {
            messages.put("title", "Invalid Name");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
	        Application application = new Application(caseNumber);
	        try {
	        	application = applicationDao.delete(application);
	        	// Update the message.
		        if (application == null) {
		            messages.put("title", "Successfully deleted " + caseNumber);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + caseNumber);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicationDelete.jsp").forward(req, resp);
    }
	
	
}
