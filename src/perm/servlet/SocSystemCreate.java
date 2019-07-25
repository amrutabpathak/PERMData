package perm.servlet;

import perm.dao.SOCSystemDao;
import perm.model.SOCSystem;

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


@WebServlet("/socsystemcreate")
public class SocSystemCreate extends HttpServlet {
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/SocSystemCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate soc code.
        String socCode = req.getParameter("prevailingwagesoccode");
        if (socCode == null || socCode.trim().isEmpty()) {
            messages.put("success", "Invalid Soc Code");
        } else {
        	// Create the BlogUser.
        	String socTitle = req.getParameter("prevailingwagesoctitle");
	        try {
	        	SOCSystem socSystem = new SOCSystem(socCode, socTitle);
	        	socSystem = socSystemDao.create(socSystem);
	        	messages.put("success", "Successfully created " + socCode);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/SocSystemCreate.jsp").forward(req, resp);
    }
}
