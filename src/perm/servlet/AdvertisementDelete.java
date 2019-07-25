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

@WebServlet("/advertisementdelete")
public class AdvertisementDelete extends HttpServlet {
	
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
        messages.put("title", "Delete Advertisement");        
        req.getRequestDispatcher("/AdvertisementDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
     
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        Integer advertisementId = Integer.parseInt(req.getParameter("AdvertisementId"));
        if (advertisementId == null) {
            messages.put("title", "Invalid AdvertisementId");
            messages.put("disableSubmit", "true");
        } else {
        	
	        Advertisements advertisement = new Advertisements(advertisementId);
	        try {
	        	advertisement = advertisementDao.delete(advertisement);
		        if (advertisement == null) {
		            messages.put("title", "Successfully deleted " + advertisementId);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + advertisementId);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AdvertisementDelete.jsp").forward(req, resp);
    }
}
