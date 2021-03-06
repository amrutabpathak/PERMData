package perm.servlet;

import perm.dao.*;
import perm.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/findagent")
public class FindAgent extends HttpServlet {
	
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

        List<Agent> agent = new ArrayList<Agent>();
        
        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String name = req.getParameter("agentname");
        if (name == null || name.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
            	Agent temp = agentDao.getAgentByName(name);
            	List<Agent> tempList = new ArrayList<>();
            	tempList.add(temp);
            	agent = tempList;
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + name);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousFirstName", name);
        }
        if(!agent.isEmpty()) {
            System.out.println("~~~~~");
            System.out.println(agent.get(0).getFirmName());
            System.out.println(agent.get(0).getCity());
            System.out.println(agent.get(0).getState());
        }

        req.setAttribute("agents", agent);
        
        req.getRequestDispatcher("/FindAgent.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        List<Agent> agent = new ArrayList<Agent>();
        
        // Retrieve and validate name.
        // firstname is retrieved from the form POST submission. By default, it
        // is populated by the URL query string (in FindUsers.jsp).
        String name = req.getParameter("agentname");
        if (name == null || name.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
                Agent temp = agentDao.getAgentByName(name);
                List<Agent> tempList = new ArrayList<>();
                tempList.add(temp);
                agent = tempList;
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + name);
        }
        req.setAttribute("agents", agent);
        
        req.getRequestDispatcher("/FindAgent.jsp").forward(req, resp);
    }
}
