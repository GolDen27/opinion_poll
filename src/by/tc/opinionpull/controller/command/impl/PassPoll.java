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
import java.io.IOException;

public class PassPoll implements Command {
	private final static Logger LOGGER = LogManager.getLogger();

	private static final String POLL = "poll";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();

		String pollId = request.getParameter("id_poll");

		try {
			Poll poll = pollService.getPoll(pollId);
			request.setAttribute(POLL, poll);
			request.getRequestDispatcher(JspPath.JSP_PASS_POLL_PATH).forward(request,response);
		} catch (ServiceException e) {
			//TODO
			LOGGER.error(e);
		} catch (ServiseIllegalArgumentException e) {
			//TODO
			LOGGER.error(e);
		}
	}
}
