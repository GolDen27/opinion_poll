package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.QuestionService;
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

public class AddQuestion implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO  title topic;


		String title = request.getParameter("title");
		String topic = request.getParameter("topic");
		String idpoll = request.getParameter("pollid");

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();
		QuestionService questionService = serviceFactory.getQuestionService();
		TopicService topicService = serviceFactory.getTopicService();

		try {
			Topic topicSearch = topicService.searchTopic(topic);
			if(topicSearch == null) {
				topicService.addTopic(topic);
				topicSearch = topicService.searchTopic(topic);
			}
			questionService.addQuestion(topicSearch.getId().toString(), title);
			Question question = questionService.getQuestionByTitle(title);
			Poll poll = pollService.getPoll(idpoll);
			pollService.addQuestion(poll.getId().toString(), question.getId().toString());
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
