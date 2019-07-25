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


@WebServlet("/findadvertisement")
public class FindAdvertisement extends HttpServlet {
	
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
        Advertisements advertisement = null;
        
        String advertisementId = req.getParameter("AdvertisementId");
        if (advertisementId == null || advertisementId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid advertisementId.");
        } else {
        	
        	try {
        		advertisement = advertisementDao.getAdvertisementById(Integer.parseInt(advertisementId));
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + advertisementId);
      
        }
        req.setAttribute("advertisement", advertisement);
        
        req.getRequestDispatcher("/FindAdvertisement.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
       
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        Advertisements advertisement = null;
  
        String advertisementId = req.getParameter("AdvertisementId");
        if (advertisementId == null || advertisementId.trim().isEmpty()) {
            messages.put("success", "Please enter a valid advertisementId.");
        } else {
        	
        	try {
        		advertisement = advertisementDao.getAdvertisementById(Integer.parseInt(advertisementId));
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + advertisementId);
        }
        req.setAttribute("advertisement", advertisement);
        
        req.getRequestDispatcher("/FindAdvertisement.jsp").forward(req, resp);
    }
}
