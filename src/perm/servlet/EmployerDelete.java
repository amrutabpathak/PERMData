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


@WebServlet("/employerdelete")
public class EmployerDelete extends HttpServlet {
	
	protected EmployerDao employerDao;
	
	@Override
	public void init() throws ServletException {
		employerDao = EmployerDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Employer");
        req.getRequestDispatcher("/EmployerDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String name = req.getParameter("employername");
        if (name == null || name.trim().isEmpty()) {
            messages.put("title", "Invalid Name");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
	        Employer employer = new Employer(name);
	        try {
	        	employer = employerDao.delete(employer);
	        	// Update the message.
		        if (employer == null) {
		            messages.put("title", "Successfully deleted " + name);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + name);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/EmployerDelete.jsp").forward(req, resp);
    }
}
