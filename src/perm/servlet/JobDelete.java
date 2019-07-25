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


@WebServlet("/jobdelete")
public class JobDelete extends HttpServlet {
	
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
        // Provide a title and render the JSP.
        messages.put("title", "Delete Job");        
        req.getRequestDispatcher("/JobDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String jobIdStr = req.getParameter("jobid");
        if (jobIdStr == null || jobIdStr.trim().isEmpty()) {
            messages.put("title", "Invalid Job Id");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	long jobId = Long.parseLong(jobIdStr);
	        Job job = new Job(jobId);
	        try {
	        	job = jobDao.delete(job);
	        	// Update the message.
		        if (job == null) {
		            messages.put("title", "Successfully deleted " + jobId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + jobId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/JobDelete.jsp").forward(req, resp);
    }
}
