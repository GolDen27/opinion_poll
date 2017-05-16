package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLanguage implements Command {



	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


		HttpSession session = request.getSession(true);
		String lang = String.valueOf(session.getAttribute("lang"));
		switch (lang){
			case "ru":
				session.setAttribute("lang","en");
				break;
			case "en":
				session.setAttribute("lang","ru");
				break;
			default:
				session.setAttribute("lang","en");

		}

		response.sendRedirect(JspPath.JSP_MAIN_PATH);
	}
}
