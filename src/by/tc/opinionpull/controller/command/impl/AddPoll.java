package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.TopicService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
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

public class AddPoll implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String titlePoll = request.getParameter("title");
		String description = request.getParameter("description");
		String topic = request.getParameter("topic");

		HttpSession session = request.getSession();

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();
		TopicService topicService = serviceFactory.getTopicService();

		try {
			Topic topicSearch = topicService.searchTopic(topic);
			if(topicSearch == null) {
				topicService.addTopic(topic);
				topicSearch = topicService.searchTopic(topic);
			}
			pollService.addPoll(titlePoll, description, topicSearch.getId().toString());
			Poll poll = pollService.getPollByTitle(titlePoll);
			session.setAttribute("poll", poll);
			response.sendRedirect(JspPath.JSP_PATH_EDIT_POLL);

		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiceDuplicateException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		}

	}
}
