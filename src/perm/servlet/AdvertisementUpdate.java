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

@WebServlet("/advertisementupdate")
public class AdvertisementUpdate extends HttpServlet {
	
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

        
        String advertisementId = req.getParameter("AdvertisementId");
        if (advertisementId == null || advertisementId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid advertisement id.");
        } else {
        	try {
        		Advertisements advertisement = advertisementDao.getAdvertisementById(Integer.parseInt(advertisementId));
        		if(advertisement == null) {
        			messages.put("success", "AdvertisementId does not exist.");
        		}
        		req.setAttribute("advertisement", advertisement);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AdvertisementUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
       
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

       
        String advertisementId = req.getParameter("AdvertisementId");
        if (advertisementId == null || advertisementId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid advertisement id.");
        } else {
        	try {
        		Advertisements advertisement = advertisementDao.getAdvertisementById(Integer.parseInt(advertisementId));
        		if(advertisement == null) {
        			messages.put("success", "AdvertisementId does not exist.");
        		} else {
        			Advertisements.AdvertiseMeans newMeans = Advertisements.AdvertiseMeans.valueOf(req.getParameter("Means"));
        			if (newMeans == null) {
        	            messages.put("success", "Please enter a valid means.");
        	        } else {
        	        	
        	        	advertisement = advertisementDao.updateAdvertisementMeans(advertisement, newMeans);
        	        	messages.put("success", "Successfully updated " + advertisementId);
        	        }
        		}
        		req.setAttribute("advertisement",advertisement);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AdvertisementUpdate.jsp").forward(req, resp);
    }
}

