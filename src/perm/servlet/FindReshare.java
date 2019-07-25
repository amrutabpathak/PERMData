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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet("/findreshare")
public class FindReshare extends HttpServlet {

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

        List<ReshareAgentEmployer> reshare = new ArrayList<ReshareAgentEmployer>();

        // Retrieve and validate name.
        // firstname is retrieved from the URL query string.
        String name = req.getParameter("agentname");
        if (name == null || name.trim().isEmpty()) {
            messages.put("success", "Please enter a valid name.");
        } else {
        	// Retrieve BlogUsers, and store as a message.
        	try {
                String employername = req.getParameter("employername");
            	ReshareAgentEmployer temp = reshareDao.getReshareByName(name,employername);
            	List<ReshareAgentEmployer> tempList = new ArrayList<>();
            	tempList.add(temp);
            	reshare = tempList;
            } catch (SQLException e) {
    			e.printStackTrace();
    			throw new IOException(e);
            }
        	messages.put("success", "Displaying results for " + name);
        	// Save the previous search term, so it can be used as the default
        	// in the input box when rendering FindUsers.jsp.
        	messages.put("previousFirstName", name);
        }

        req.setAttribute("reshares", reshare);

        req.getRequestDispatcher("/FindReshare.jsp").forward(req, resp);
	}

	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        req.getRequestDispatcher("/FindReshare.jsp").forward(req, resp);
    }
}
