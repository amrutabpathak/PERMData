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


@WebServlet("/resharecreate")
public class ReshareCreate extends HttpServlet {

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
        //Just render the JSP.
        req.getRequestDispatcher("/ReshareCreate.jsp").forward(req, resp);
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
            messages.put("success", "Invalid UserName");
        } else {
        	// Create the BlogUser.
//        	String agentName = req.getParameter("agentname");
			String employername = req.getParameter("employername");
			System.out.println("aaagent:"+name);
			System.out.println("employereeee:"+employername);
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	ReshareAgentEmployer reshare = new ReshareAgentEmployer(name, employername);
	        	reshare = reshareDao.create(reshare);
	        	messages.put("success", "Successfully created " + name);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }

        req.getRequestDispatcher("/ReshareCreate.jsp").forward(req, resp);
    }
}
