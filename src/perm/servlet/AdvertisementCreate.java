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

@WebServlet("/advertisementcreate")
public class AdvertisementCreate extends HttpServlet{
	protected AdvertisementsDao advertisementDao;
	
	@Override
	public void init() throws ServletException {
		advertisementDao = AdvertisementsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages); 
        req.getRequestDispatcher("/AdvertisementCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        
        String advertisementId = req.getParameter("AdvertisementID");
        if (advertisementId == null || advertisementId.trim().isEmpty()) {
            messages.put("success", "Invalid AdvertisementId");
        } else {
        	JobDao jobsDao = JobDao.getInstance();
        	
        	int advertisementIdResult = Integer.parseInt(req.getParameter("AdvertisementID"));
        	Advertisements.AdvertiseMeans means = Advertisements.AdvertiseMeans.valueOf(req.getParameter("Means"));
			
			Long jobId = Long.parseLong(req.getParameter("JobID"));	
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        	String start = req.getParameter("StartDate");
        	String end = req.getParameter("EndDate");
        	
        	Date startDate = new Date();
        	Date endDate = new Date();
        	try {
        		startDate = dateFormat.parse(start);
        		endDate = dateFormat.parse(end);
        	
        	} catch (ParseException e) {
        		e.printStackTrace();
				throw new IOException(e);
        	}
			try {
				Job job = jobsDao.getJobById(jobId);
				
	        	Advertisements advertisement = new Advertisements(advertisementIdResult, means,startDate,endDate,job);
	        	advertisement = advertisementDao.create(advertisement);
	        	messages.put("success", "Successfully created AdvertisementId" + advertisementId);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AdvertisementCreate.jsp").forward(req, resp);
    }
}

