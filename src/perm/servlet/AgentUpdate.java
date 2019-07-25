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


@WebServlet("/agentupdate")
public class AgentUpdate extends HttpServlet {
	
	protected AgentDao agentDao;
	
	@Override
	public void init() throws ServletException {
		agentDao = AgentDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing message
		// s.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String agentName = req.getParameter("agentname");
        if (agentName == null || agentName.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {
        	try {
        		Agent agent = agentDao.getAgentByName(agentName);
        		if(agent == null) {
        			messages.put("success", "UserName does not exist.");
        		}
        		req.setAttribute("agent", agent);
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AgentUpdate.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve user and validate.
        String name = req.getParameter("agentname");
        if (name == null || name.trim().isEmpty()) {
            messages.put("success", "Please enter a valid UserName.");
        } else {

        		Agent agent = agentDao.getAgentByName(name);
        		if(agent == null) {
        			messages.put("success", "UserName does not exist. No update to perform.");
        		} else {

					String city = req.getParameter("city"));


					try {

						agent = agentDao.updateAgent(agent,city);
						messages.put("success", "Successfully created " + name);
					} catch (SQLException e) {
						e.printStackTrace();
						throw new IOException(e);
					}
        		}
        		req.setAttribute("agent", agent);

        }
        
        req.getRequestDispatcher("/AgentUpdate.jsp").forward(req, resp);
    }
}
