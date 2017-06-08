package by.tc.opinionpull.filter;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.CommandName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SecurityFilter implements Filter {


	private final static Logger LOGGER = LogManager.getLogger();
	private Set<CommandName> userCommand = new HashSet<>();

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpServletResponse response = (HttpServletResponse)servletResponse;
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			if(!user.getTypeOfUser()){
				try {
					CommandName commandName = CommandName.valueOf(command.toUpperCase());
					boolean isAllowed = userCommand.contains(commandName);
					if(!isAllowed){
						LOGGER.warn("user attack with command " + commandName);
						response.sendRedirect(JspPath.JSP_ERR_PATH);
					} else {
						filterChain.doFilter(servletRequest, servletResponse);
					}
				} catch (IllegalArgumentException e) {
					LOGGER.error("illegal comand", e);
					response.sendRedirect(JspPath.JSP_ERR_PATH);
				}
			} else {
				filterChain.doFilter(servletRequest, servletResponse);
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userCommand.add(CommandName.LOGIN);
		userCommand.add(CommandName.LOGOUT);
		userCommand.add(CommandName.SIGNIN);
		userCommand.add(CommandName.CHANGE_LANGUAGE);
		userCommand.add(CommandName.LOAD_CONTENT);
		userCommand.add(CommandName.PASS_POLL);
		userCommand.add(CommandName.COMPLETE_POLL);
		userCommand.add(CommandName.USER_SETTINGS);
		userCommand.add(CommandName.CHECK_ADMIN_USER);
	}

	@Override
	public void destroy() {

	}
}
