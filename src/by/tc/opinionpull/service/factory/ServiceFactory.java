package by.tc.opinionpull.service.factory;

import by.tc.opinionpull.service.*;
import by.tc.opinionpull.service.impl.*;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AnswerService answerService = new AnswerServiceImpl();
    private final PollService pollService = new PollServiceImpl();
    private final QuestionService questionService = new QuestionServiceImpl();
    private final TestService testService = new TestServiceImpl();
    private final TopicService topicService = new TopicServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private ServiceFactory() {}

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AnswerService getAnswerService() {
        return answerService;
    }

    public PollService getPollService() {
        return pollService;
    }

    public QuestionService getQuestionService() {
        return questionService;
    }

    public TestService getTestService() {
        return testService;
    }

    public TopicService getTopicService() {
        return topicService;
    }

    public UserService getUserService() {
        return userService;
    }
}
