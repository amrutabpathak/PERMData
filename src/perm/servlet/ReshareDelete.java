package perm.servlet;

import perm.dao.AgentDao;
import perm.dao.ReshareEmployerAgentDao;
import perm.model.Agent;
import perm.model.ReshareAgentEmployer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/resharedelete")
public class ReshareDelete extends HttpServlet {

	protected ReshareEmployerAgentDao reshareDao;

	@Override
	public void init() throws ServletException {
		reshareDao = ReshareEmployerAgentDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete Employer");
        req.getRequestDispatcher("/ReshareDelete.jsp").forward(req, resp);
	}

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String name = req.getParameter("agentname");
        if (name == null || name.trim().isEmpty()) {
            messages.put("title", "Invalid Name");
            messages.put("disableSubmit", "true");
        } else {
        	// Delete the BlogUser.
			String employername = req.getParameter("employername");
	        ReshareAgentEmployer reshare = new ReshareAgentEmployer(name,employername);
	        try {
	        	reshare = reshareDao.delete(reshare);
	        	// Update the message.
		        if (reshare == null) {
		            messages.put("title", "Successfully deleted " + name);
		            messages.put("disableSubmit", "true");
		        } else {
		        	messages.put("title", "Failed to delete " + name);
		        	messages.put("disableSubmit", "false");
		        }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }

        req.getRequestDispatcher("/ReshareDelete.jsp").forward(req, resp);
    }
}
