package perm.servlet;

import perm.dao.*;
import perm.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/employercreate")
public class EmployerCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/EmployerCreate.jsp").forward(req, resp);
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
            messages.put("success", "Invalid UserName");
        } else {
        	// Create the BlogUser.
        	String employerName = req.getParameter("employername");
        	String address1 = req.getParameter("Address1");
			String address2 = req.getParameter("Address2");
			String city = req.getParameter("City");
			String state = req.getParameter("State");
			String country = req.getParameter("Country");
			int postalCode = Integer.parseInt(req.getParameter("PostalCode"));
			String phone = req.getParameter("Phone");
			int phoneExt = Integer.parseInt(req.getParameter("PhoneExt"));
			int numOfEmployee = Integer.parseInt(req.getParameter("NumOfEmployee"));
			int establishedYear = Integer.parseInt(req.getParameter("EstablishedYear"));
			boolean fwOwnerShip = req.getParameter("FwOwnership").equals("true")? true: false;
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Employer employer = new Employer(employerName, address1, address2, city, state,country,postalCode,phone,phoneExt,numOfEmployee,establishedYear,fwOwnerShip);
	        	employer = employerDao.create(employer);
	        	messages.put("success", "Successfully created " + employerName);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/EmployerCreate.jsp").forward(req, resp);
    }
}
