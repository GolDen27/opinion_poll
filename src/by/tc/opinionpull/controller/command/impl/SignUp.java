package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.service.UserService;
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

public class SignUp implements Command {
    private final static Logger LOGGER = LogManager.getLogger();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String year = request.getParameter("year");
        String email = request.getParameter("email");
        String password = request.getParameter("password1");

        HttpSession session = request.getSession(true);

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        try {
            userService.addUser(email, password, firstName, lastName, "0", "", year);
            request.getRequestDispatcher(JspPath.JSP_REGISTER_PATH).forward(request,response);
        }
        catch (ServiceException e) {

            response.sendRedirect(JspPath.JSP_ERR_PATH);
            LOGGER.error(e);

        } catch (ServiceDuplicateException e) {

            session.setAttribute("isduplicateregister", true);
            response.sendRedirect(JspPath.JSP_MAIN_PATH);
            LOGGER.warn(e);

        } catch (ServiseIllegalArgumentException e) {
            //TODO
            LOGGER.error(e);
        }


    }
}
