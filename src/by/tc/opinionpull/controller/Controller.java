package by.tc.opinionpull.controller;

import by.tc.opinionpull.controller.command.Command;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.connection.ConnectionPool;
import by.tc.opinionpull.dao.exception.DAOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class Controller extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executeTask(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        executeTask(req, resp);
    }

    private void executeTask (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName;
        Command executionCommand;

        commandName = request.getParameter("command");
        executionCommand = provider.getCommand(commandName);

        executionCommand.execute(request, response);
    }

    @Override
    public void destroy() {
        //FOR DEBUG
        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        ConnectionPool connectionPool = connectionFactory.getConnectionPool();
        try {
            connectionPool.closeAll();
        } catch (DAOException e) {
            //TODO
        }
        //FOR DEBUG
    }
}
