package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
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

public class UserSettings implements Command {


	private final static Logger LOGGER = LogManager.getLogger();

	private final static String USER = "user";
	private final static String LOGIN = "email";
	private final static String SURNAME = "firstname";
	private final static String NAME = "lastname";
	private final static String AGE = "year";
	private final static String PASSWORD = "password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(USER);

		String login = request.getParameter(LOGIN);
		String surname = request.getParameter(SURNAME);
		String name = request.getParameter(NAME);
		String age = request.getParameter(AGE);
		String password = request.getParameter(PASSWORD);

		try {
			String typeOfUser = user.getTypeOfUser()?"1":"0";
			userService.changeUser(user.getLogin(),login,password,surname,name,typeOfUser,user.getPhotoPath(),age);
			User newUser = userService.getUser(login);
			session.setAttribute(USER,newUser);
			response.sendRedirect(JspPath.JSP_MAIN_PATH);
		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		}
	}
}
