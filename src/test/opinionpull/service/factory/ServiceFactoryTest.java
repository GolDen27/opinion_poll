package test.opinionpull.service.factory;

import by.tc.opinionpull.service.*;
import by.tc.opinionpull.service.factory.ServiceFactory;
import by.tc.opinionpull.service.impl.*;
import org.junit.Assert;
import org.junit.Test;

public class ServiceFactoryTest {
	@Test
	public void getInstance() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		Assert.assertTrue(serviceFactory instanceof ServiceFactory);
	}

	@Test
	public void getAnswerService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AnswerService answerService = serviceFactory.getAnswerService();
		Assert.assertTrue(answerService instanceof AnswerServiceImpl);
	}

	@Test
	public void getPollService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		PollService pollService = serviceFactory.getPollService();
		Assert.assertTrue(pollService instanceof PollServiceImpl);
	}

	@Test
	public void getQuestionService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		QuestionService questionService = serviceFactory.getQuestionService();
		Assert.assertTrue(questionService instanceof QuestionServiceImpl);
	}

	@Test
	public void getTestService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();

	}

	@Test
	public void getTopicService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		TopicService topicService = serviceFactory.getTopicService();
		Assert.assertTrue(topicService instanceof TopicServiceImpl);
	}

	@Test
	public void getUserService() throws Exception {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		Assert.assertTrue(userService instanceof UserServiceImpl);
	}

}