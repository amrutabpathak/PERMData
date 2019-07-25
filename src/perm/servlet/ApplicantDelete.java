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

@WebServlet("/applicantdelete")
public class ApplicantDelete extends HttpServlet {
	
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
        messages.put("title", "Delete Applicant");        
        req.getRequestDispatcher("/ApplicantDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
     
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        String applicantId = req.getParameter("ApplicantID");
        if (applicantId == null || applicantId.trim().isEmpty()) {
            messages.put("title", "Invalid ApplicantId");
            messages.put("disableSubmit", "true");
        } else {
        	
	        Applicants applicant = new Applicants(Long.parseLong(applicantId));
	        try {
	        	applicant = applicantDao.delete(applicant);
		        if (applicant == null) {
		            messages.put("title", "Successfully deleted " + applicantId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + applicantId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/ApplicantDelete.jsp").forward(req, resp);
    }
}
