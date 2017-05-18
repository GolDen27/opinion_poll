package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.AnswerService;
import by.tc.opinionpull.service.QuestionService;
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

public class AddAnswer implements Command {

	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String reply = request.getParameter("reply");
		String idQuestion = request.getParameter("questionid");

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AnswerService answerService = serviceFactory.getAnswerService();
		QuestionService questionService = serviceFactory.getQuestionService();

		try {
			answerService.addAnswer(reply);
			Answer answer = answerService.getAnswerByReply(reply);
			questionService.addAnswer(idQuestion, answer.getId().toString());
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
