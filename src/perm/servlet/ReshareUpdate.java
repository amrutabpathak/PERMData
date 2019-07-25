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


@WebServlet("/reshareupdate")
public class ReshareUpdate extends HttpServlet {

	protected ReshareEmployerAgentDao reshareDao;

	@Override
	public void init() throws ServletException {
		reshareDao = ReshareEmployerAgentDao.getInstance();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);

		// Retrieve user and validate.
		String name = req.getParameter("agentname");
		if (name == null || name.trim().isEmpty()) {
			messages.put("success", "Please enter a valid UserName.");
		} else {

			ReshareAgentEmployer reshare = null;
			try {
				String employername = req.getParameter("employername");
				reshare = reshareDao.getReshareByName(name,employername);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(reshare == null) {
				messages.put("success", "UserName does not exist. No update to perform.");
			} else {

				String newname = req.getParameter("newagentname");


				try {

					reshare = reshareDao.updateReshare(reshare,newname);
					messages.put("success", "Successfully created " + name);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException(e);
				}
			}
			req.setAttribute("reshare", reshare);

		}

		req.getRequestDispatcher("/ReshareUpdate.jsp").forward(req, resp);
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

			ReshareAgentEmployer reshare = null;
			try {
				String employername = req.getParameter("employername");
				reshare = reshareDao.getReshareByName(name,employername);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(reshare == null) {
        			messages.put("success", "UserName does not exist. No update to perform.");
        		} else {

					String newname = req.getParameter("newagentname");


					try {

						reshare = reshareDao.updateReshare(reshare,newname);
						messages.put("success", "Successfully created " + name);
					} catch (SQLException e) {
						e.printStackTrace();
						throw new IOException(e);
					}
        		}
        		req.setAttribute("reshare", reshare);

        }

        req.getRequestDispatcher("/ReshareUpdate.jsp").forward(req, resp);
    }
}
