package perm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import perm.dao.NaicsDao;
import perm.model.Naics;



@WebServlet("/naicscreate")
public class NaicsCreate extends HttpServlet {
	
protected NaicsDao naicsDao;
	
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
        //Just render the JSP.   
        req.getRequestDispatcher("/NaicsCreate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate naics codes.
        int naicsCode = req.getParameter("naicscode");
        String naicsTitle = req.getParameter("naicstitle");

	        try {
	        	Naics naics = new Naics(naicsCode, naicsTitle);
	        	naics = naicsDao.create(naics);
	        	messages.put("success", "Successfully created " + naicsCode);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
	        req.getRequestDispatcher("/NaicsCreate.jsp").forward(req, resp);
        }
        
}
