package perm.servlet;

import perm.dao.JobDao;
import perm.model.Job;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jobupdate")
public class JobUpdate extends HttpServlet {
	
	protected JobDao jobDao;
	
	@Override
	public void init() throws ServletException {
		jobDao = JobDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String jobIdStr = req.getParameter("jobid");
        if (jobIdStr== null || jobIdStr.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Job Id.");
        } else {
        	try {
        		int jobId = Integer.parseInt(jobIdStr);
        		Job job = jobDao.getJobById(jobId);
        		if(job == null) {
        			messages.put("success", "Job record does not exist.");
        		}
        		req.setAttribute("job", job);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/JobUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String jobIdStr = req.getParameter("jobid");
        if (jobIdStr== null || jobIdStr.trim().isEmpty()) {
            messages.put("success", "Please enter a valid Job Id.");
        } else {
        	try {
        		int jobId = Integer.parseInt(jobIdStr);
        		Job job = jobDao.getJobById(jobId);
        		if(job == null) {
        			messages.put("success", "Job record does not exist. No update to perform.");
        		} else {
        			String newJobTitle = req.getParameter("jobtitle");
        			String newAmountStr = req.getParameter("amount");
        			if (newJobTitle == null || newJobTitle.trim().isEmpty()) {
        	            messages.put("success", "Please enter a valid job title.");
        	        }else if(newAmountStr == null || newAmountStr.trim().isEmpty()) {
        	        	messages.put("success", "Please enter a valid amount.");
        	        }
        			else {
                		int newAmount = Integer.parseInt(newAmountStr);

        	        	job = jobDao.updateContent(job, newJobTitle, newAmount);
        	        	messages.put("success", "Successfully updated " + jobId);
        	        }
        		}
        		req.setAttribute("job", job);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/JobUpdate.jsp").forward(req, resp);
    }
}
