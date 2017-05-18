package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Topic;
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
import java.io.IOException;

public class AddPoll implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String titlePoll = request.getParameter("title");
		String description = request.getParameter("description");
		String topic = request.getParameter("topic");

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
