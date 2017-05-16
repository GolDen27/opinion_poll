package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOut implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.setAttribute("user",null);
		request.getRequestDispatcher(JspPath.JSP_MAIN_PATH).forward(request,response);
	}
}
