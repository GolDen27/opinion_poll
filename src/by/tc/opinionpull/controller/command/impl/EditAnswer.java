package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.controller.JspPath;
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

public class EditAnswer implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO id  title
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AnswerService answerService = serviceFactory.getAnswerService();

		String id = request.getParameter("id");
		String title = request.getParameter("title");

		try {
			Answer answer = answerService.getAnswer(id);
			answerService.changeAnswer(answer.getId().toString(), answer.getId().toString(), title);
			response.sendRedirect(JspPath.JSP_PATH_EDIT_POLL);
		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		}
	}
}
