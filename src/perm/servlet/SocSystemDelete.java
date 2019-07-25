package perm.servlet;


import perm.dao.SOCSystemDao;
import perm.model.SOCSystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/socsystemdelete")
public class SocSystemDelete extends HttpServlet {
	
	protected SOCSystemDao socSystemDao;
	
	@Override
	public void init() throws ServletException {
		socSystemDao = SOCSystemDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete SOC System");        
        req.getRequestDispatcher("/SocSystemDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String socCode = req.getParameter("prevailingwagesoccode");
        if (socCode == null || socCode.trim().isEmpty()) {
            messages.put("title", "Invalid Soc Code");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
	        SOCSystem socSystem= new SOCSystem(socCode);
	        try {
	        	socSystem = socSystemDao.delete(socSystem);
	        	// Update the message.
		        if (socSystem == null) {
		            messages.put("title", "Successfully deleted " + socCode);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + socCode);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/SocSystemDelete.jsp").forward(req, resp);
    }
}
