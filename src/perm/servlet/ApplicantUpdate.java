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

@WebServlet("/applicantupdate")
public class ApplicantUpdate extends HttpServlet {
	
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

        // Retrieve user and validate.
        String applicantId = req.getParameter("ApplicantID");
        if (applicantId == null || applicantId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid applicant id.");
        } else {
        	try {
        		Applicants applicant = applicantDao.getApplicantById(Long.parseLong(applicantId));
        		if(applicant == null) {
        			messages.put("success", "ApplicantId does not exist.");
        		}
        		req.setAttribute("applicant", applicant);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
       
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

       
        String applicantId = req.getParameter("ApplicantID");
        if (applicantId == null || applicantId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid applicant id.");
        } else {
        	try {
        		Applicants applicant = applicantDao.getApplicantById(Long.parseLong(applicantId));
        		if(applicant == null) {
        			messages.put("success", "ApplicantId does not exist.");
        		} else {
        			String newAdmissionClass = req.getParameter("AdmissionClass");
        			if (newAdmissionClass == null || newAdmissionClass.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid Admission Class.");
        	        } else {
        	        	applicant = applicantDao.updateAdmissionClass(applicant, newAdmissionClass);
        	        	messages.put("success", "Successfully updated " + applicantId);
        	        }
        		}
        		req.setAttribute("applicant", applicant);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantUpdate.jsp").forward(req, resp);
    }
}

