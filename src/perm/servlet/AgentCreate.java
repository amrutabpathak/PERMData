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


@WebServlet("/agentcreate")
public class AgentCreate extends HttpServlet {
	
	protected AgentDao agentDao;
	
	@Override
	public void init() throws ServletException {
		agentDao = AgentDao.getInstance();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/AgentCreate.jsp").forward(req, resp);
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
        	String name = req.getParameter("agentname");
			String city = req.getParameter("City");
			String state = req.getParameter("State");
	        try {
	        	// Exercise: parse the input for StatusLevel.
	        	Agent agent = new Agent(name, city, state);
	        	agent = agentDao.create(agent);
	        	messages.put("success", "Successfully created " + name);
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        
        req.getRequestDispatcher("/AgentCreate.jsp").forward(req, resp);
    }
}
