package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import perm.dao.NaicsDao;
import perm.model.Naics;

@WebServlet("/findnaics")
public class FindNaics extends HttpServlet {
	
	NaicsDao naicsDao;
	
	@Override
	public void init() throws ServletException {
		naicsDao =  NaicsDao.getInstance();
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Naics naics = new Naics(); 
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String naicsCodestr = req.getParameter("naicscode");        
        if (naicsCodestr == null || naicsCodestr.trim().isEmpty()) {
            messages.put("success", "Please enter a valid caseNumber.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
    		int naicsCode = Integer.parseInt(naicsCodestr);
    		System.out.println("~~~int "+ naicsCode );
        	try {
            	naics = naicsDao.getNaicsFromNaicsCode(naicsCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + naicsCode);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousNaicsCode", naicsCodestr);
        }
        System.out.println("~~~naaa "+ naics.getNaicsCode() );
        req.setAttribute("naics", Arrays.asList(naics));
        
        req.getRequestDispatcher("/FindNaics.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Naics naics = new Naics();
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String naicsCodestr = req.getParameter("naicscode");        
        if (naicsCodestr == null || naicsCodestr.trim().isEmpty()) {
            messages.put("success", "Please enter a naics code.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
    		int naicsCode = Integer.parseInt(naicsCodestr);
        	try {
            	naics = naicsDao.getNaicsFromNaicsCode(naicsCode);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + naicsCode);
        }
        req.setAttribute("naics", naics);
        
        req.getRequestDispatcher("/FindNaics.jsp").forward(req, resp);
    }

}
