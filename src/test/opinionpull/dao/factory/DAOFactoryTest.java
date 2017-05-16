package test.opinionpull.dao.factory;

import by.tc.opinionpull.dao.*;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.dao.impl.*;
import org.junit.Assert;
import org.junit.Test;

public class DAOFactoryTest {
	@Test
	public void getInstance() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		Assert.assertTrue(daoFactory instanceof DAOFactory);
	}

	@Test
	public void getAnswerDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();
		Assert.assertTrue(answerDAO instanceof AnswerDAOImpl);
	}

	@Test
	public void getPollDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		PollDAO pollDAO = daoFactory.getPollDAO();
		Assert.assertTrue(pollDAO instanceof PollDAOImpl);
	}

	@Test
	public void getQuestionDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();
		Assert.assertTrue(questionDAO instanceof QuestionDAOImpl);
	}

	@Test
	public void getTestDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		TestDAO testDAO = daoFactory.getTestDAO();
		Assert.assertTrue(testDAO instanceof TestDAOImpl);
	}

	@Test
	public void getTopicDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();
		Assert.assertTrue(topicDAO instanceof TopicDAOImpl);
	}

	@Test
	public void getUserDAO() throws Exception {
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		Assert.assertTrue(userDAO instanceof UserDAOImpl);
	}

}