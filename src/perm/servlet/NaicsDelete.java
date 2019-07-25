package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import perm.dao.NaicsDao;
import perm.model.Naics;

public class NaicsDelete extends HttpServlet{
	
	NaicsDao naicsDao;
	
	@Override
	public void init() throws ServletException {
		naicsDao = NaicsDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete NAICS");
        req.getRequestDispatcher("/NaicsDelete.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String naicsCodestr = req.getParameter("naicscode");
        if (naicsCodestr == null || naicsCodestr.trim().isEmpty()) {
            messages.put("title", "Invalid Naics code");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
        	int naicsCode = Integer.parseInt(naicsCodestr);
	        Naics naics = new Naics(naicsCode);
	        try {
	        	naics = naicsDao.delete(naics);
	        	// Update the message.
		        if (naics == null) {
		            messages.put("title", "Successfully deleted " + naicsCode);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + naicsCode);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/NaicsDelete.jsp").forward(req, resp);
    }

}
