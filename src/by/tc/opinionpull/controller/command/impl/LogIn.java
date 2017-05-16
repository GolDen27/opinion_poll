package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.UserService;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiceFailLoginException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogIn implements Command {

    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String login = request.getParameter("email");
        String pass = request.getParameter("password");

        HttpSession session = request.getSession(true);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            userService.checkUser(login, pass);
            User user = userService.getUser(login);
            session.setAttribute("user",user);

            response.sendRedirect("/Controller?command=load_content");

        } catch (ServiceException e) {

            LOGGER.error(e);
            //TODO

        } catch (ServiceFailLoginException e) {

            session.setAttribute("faillogin",true);
            response.sendRedirect(JspPath.JSP_MAIN_PATH);
            LOGGER.warn(e);

        } catch (ServiseIllegalArgumentException e) {

            //TODO
            LOGGER.warn(e);

        }


    }


}
