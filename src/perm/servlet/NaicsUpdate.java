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

import perm.dao.NaicsDao;
import perm.model.Naics;
import perm.model.SOCSystem;


@WebServlet("/naicsupdate")
public class NaicsUpdate extends HttpServlet {
	
	NaicsDao naicsDao;
	
	@Override
	public void init() throws ServletException {
		naicsDao = NaicsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String naicsCodestr = req.getParameter("naicscode");
        if (naicsCodestr== null || naicsCodestr.trim().isEmpty()) {
            messages.put("success", "Please enter a valid naics code.");
        } else {
        	try {
        		int naicsCode = Integer.parseInt(naicsCodestr);
        		Naics naics = naicsDao.getNaicsFromNaicsCode(naicsCode);
        		if(naics == null) {
        			messages.put("success", "naics record does not exist.");
        		}
        		req.setAttribute("naics", naics);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/NaicsUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String naicsCodestr = req.getParameter("naicscode");
        if (naicsCodestr == null || naicsCodestr.trim().isEmpty()) {
            messages.put("success", "Please enter a valid socCode.");
        } else {
        	try {
        		int naicsCode = Integer.parseInt(naicsCodestr);
        		Naics naics= naicsDao.getNaicsFromNaicsCode(naicsCode);
        		if(naics == null) {
        			messages.put("success", "naics record does not exist. No update to perform.");
        		} else {
        			String newNaicsTitle = req.getParameter("naicstitle");
        			if (newNaicsTitle == null || newNaicsTitle.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Naics Title.");
        	        } else {
        	        	naics = naicsDao.updateNaicsTitle(naics, newNaicsTitle);
        	        	messages.put("success", "Successfully updated " + naicsCode);
        	        }
        		}
        		req.setAttribute("naics", naics);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/NaicsUpdate.jsp").forward(req, resp);
    }

}
