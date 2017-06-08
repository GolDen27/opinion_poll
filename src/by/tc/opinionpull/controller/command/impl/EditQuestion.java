package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
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

public class EditQuestion implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		QuestionService questionService = serviceFactory.getQuestionService();
		TopicService topicService = serviceFactory.getTopicService();

		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String topic = request.getParameter("topic");

		try {
			Topic searchTopic = topicService.searchTopic(topic);
			if (searchTopic==null){
				topicService.addTopic(topic);
				searchTopic = topicService.searchTopic(topic);
			}
			Question question = questionService.getQuestion(id);
			questionService.changeQuestion(question.getId().toString(), question.getId().toString(),searchTopic.getId().toString(),title);
			response.sendRedirect(JspPath.JSP_PATH_EDIT_POLL);
		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiceDuplicateException e) {
			LOGGER.error(e);
			//TODO
		}

	}
}
