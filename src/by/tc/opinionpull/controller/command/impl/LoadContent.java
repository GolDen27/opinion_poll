package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.TestService;
import by.tc.opinionpull.service.UserService;
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
import java.util.Map;

public class LoadContent implements Command {

	private final static Logger LOGGER = LogManager.getLogger();
	private final static String PAGE_COUNT = "pageCount";
	private final static String POLLS = "polls";
	private final static String USER_COUNT = "10";
	private final static String USERS = "users";
	private final static String POLL_COUNT = "10";
	private final static String POPULAR_POLL = "poppoll";
	private final static String POLL_USER = "polluser";
	private final static String USER_POLLS = "userpolls";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate" );


		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if (user==null) {
			response.sendRedirect(JspPath.JSP_MAIN_PATH);
		} else {

			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			PollService pollService = serviceFactory.getPollService();
			UserService userService = serviceFactory.getUserService();
			TestService testService = serviceFactory.getTestService();

			try {
				int pageCount = pollService.getPageCount();
				request.setAttribute(PAGE_COUNT, pageCount);

				List<Poll> polls = pollService.getPolls("1");
				request.setAttribute(POLLS, polls);

				Map<User, Integer> users = userService.getUsersByActivity(USER_COUNT);
				request.setAttribute(USERS, users);

				Map<Poll, Integer> pollIntegerMap = pollService.getPollsByPopular(POLL_COUNT);
				request.setAttribute(POPULAR_POLL, pollIntegerMap);

				Map<User, List<Poll>> pollsByUser = userService.userPoll(USER_COUNT);
				request.setAttribute(POLL_USER, pollsByUser);


				List<Poll> polls1 = pollService.getPollsByUser(user.getLogin());
				request.setAttribute(USER_POLLS, polls1);

				request.getRequestDispatcher(JspPath.JSP_CONTENT_PATH).forward(request, response);

			} catch (ServiceException e) {
				//TODO
				LOGGER.error(e);
			} catch (ServiseIllegalArgumentException e) {
				//TODO
				LOGGER.warn(e);
			}
		}




	}
}
