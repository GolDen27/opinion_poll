package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.AnswerService;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAnswer implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String id = request.getParameter("id");
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AnswerService answerService = serviceFactory.getAnswerService();
		try {
			answerService.deleteAnswer(id);
		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		}

	}
}
