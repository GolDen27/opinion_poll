package by.tc.opinionpull.dao.factory;

import by.tc.opinionpull.dao.*;
import by.tc.opinionpull.dao.impl.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final AnswerDAO answerDAO = new AnswerDAOImpl();
    private final PollDAO pollDAO = new PollDAOImpl();
    private final QuestionDAO questionDAO = new QuestionDAOImpl();
    private final TestDAO testDAO = new TestDAOImpl();
    private final TopicDAO topicDAO = new TopicDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();


    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public AnswerDAO getAnswerDAO() {
        return answerDAO;
    }

    public PollDAO getPollDAO() {
        return pollDAO;
    }

    public QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    public TestDAO getTestDAO() {
        return testDAO;
    }

    public TopicDAO getTopicDAO() {
        return topicDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
