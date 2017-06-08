package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.PollService;
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
import java.io.PrintWriter;
import java.util.List;

public class CheckBecomeAdmin implements Command {
	private final static Logger LOGGER = LogManager.getLogger();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		//TODO

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();

		try {
			List<Poll> pollList = pollService.getPollsByUser(user.getLogin());
			boolean isFivePolls = pollList.size()>=5;
			boolean isGenderNotEmpty = user.getGender()>=0;
			boolean isCountryNotEmpty = !user.getCountry().equals("");
			boolean isPhoneNotEmpty = !user.getPhone().equals("");
			boolean isSiteLinkNotEmpty = !user.getSiteLink().equals("");


			PrintWriter writer = response.getWriter();
			if (isFivePolls && isGenderNotEmpty && isCountryNotEmpty && isPhoneNotEmpty && isSiteLinkNotEmpty) {
				writer.print("1");
			} else {
				writer.print("0");
			}

		} catch (ServiceException e) {
			LOGGER.error(e);
			//TODO
		} catch (ServiseIllegalArgumentException e) {
			LOGGER.error(e);
			//TODO
		}






	}
}
