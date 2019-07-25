package perm.servlet;


import perm.dao.*;
import perm.model.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findapplicant")
public class FindApplicant extends HttpServlet {
protected ApplicantsDao applicantDao;
	
	@Override
	public void init() throws ServletException {
		applicantDao = ApplicantsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Applicants> applicants = new ArrayList<>();
        
        String birthCountry = req.getParameter("BirthCountry");
        if (birthCountry == null || birthCountry.trim().isEmpty()) {
            messages.put("success", "Please enter a valid birth country.");
        } else {
        	
        	try {
        		applicants = applicantDao.getApplicantsByBirthCountry(birthCountry);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + birthCountry);
        	
        	messages.put("previousBirthCountry", birthCountry);
        }
        req.setAttribute("applicants",applicants);
        
        req.getRequestDispatcher("/FindApplicant.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Applicants> applicants = new ArrayList<>();
        
        String birthCountry = req.getParameter("BirthCountry");
        if (birthCountry == null || birthCountry.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	
        	try {
        		applicants = applicantDao.getApplicantsByBirthCountry(birthCountry);
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + birthCountry);
        }
        req.setAttribute("applicants", applicants);
        
        req.getRequestDispatcher("/FindApplicant.jsp").forward(req, resp);
    }
}
