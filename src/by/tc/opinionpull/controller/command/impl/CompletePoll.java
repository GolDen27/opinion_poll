package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.AnswerService;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.TestService;
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
import java.util.List;

public class CompletePoll implements Command {
	private final static Logger LOGGER = LogManager.getLogger();

	private final static String POLL = "poll";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//TODO
		String pollId = request.getParameter(POLL);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();
		TestService testService = serviceFactory.getTestService();
		AnswerService answerService = serviceFactory.getAnswerService();

		try {
			Poll poll = pollService.getPoll(pollId);
			List<Question> questions = poll.getQuestions();
			for(Question question:questions) {
				Integer questionId = question.getId();
				String answerId = request.getParameter(questionId.toString());
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				testService.addTest(poll.getId().toString(), questionId.toString(), answerId, user.getLogin());
			}
			response.sendRedirect(JspPath.JSP_MAIN_PATH);
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiceDuplicateException e) {
			LOGGER.error(e);
			//TODO
		}

	}
}
