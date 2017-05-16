package by.tc.opinionpull.controller.command.impl;

import by.tc.opinionpull.controller.JspPath;
import by.tc.opinionpull.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WrongRequest implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect(JspPath.JSP_ERR_PATH);
    }
}
