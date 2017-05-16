package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Edit implements Command{
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		HttpSession session = request.getSession(true);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();

		try {
			Poll poll = pollService.getPoll(request.getParameter("id_poll"));
			session.setAttribute("poll", poll);
			response.sendRedirect(JspPath.JSP_PATH_EDIT_POLL);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ServiseIllegalArgumentException e) {
			e.printStackTrace();
		}



	}
}
