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


@WebServlet("/socsystemupdate")
public class SOcSystemUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String socCode = req.getParameter("prevailingwagesoccode");
        if (socCode == null || socCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid soc Code.");
        } else {
        	try {
        		SOCSystem socSystem = socSystemDao.getSocSystemFromSocCode(socCode);
        		if(socSystem == null) {
        			messages.put("success", "SOc System record does not exist.");
        		}
        		req.setAttribute("socsystem", socSystem);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/SocSystemUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String socCode = req.getParameter("prevailingwagesoccode");
        if (socCode == null || socCode.trim().isEmpty()) {
            messages.put("success", "Please enter a valid socCode.");
        } else {
        	try {
        		SOCSystem socSystem= socSystemDao.getSocSystemFromSocCode(socCode);
        		if(socSystem == null) {
        			messages.put("success", "Soc System record does not exist. No update to perform.");
        		} else {
        			String newSocTitle = req.getParameter("prevailingwagesoctitle");
        			if (newSocTitle == null || newSocTitle.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Soc Title.");
        	        } else {
        	        	socSystem = socSystemDao.updateSocTitle(socSystem, newSocTitle);
        	        	messages.put("success", "Successfully updated " + socCode);
        	        }
        		}
        		req.setAttribute("socsystem", socSystem);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/SOcSystemUpdate.jsp").forward(req, resp);
    }
}
