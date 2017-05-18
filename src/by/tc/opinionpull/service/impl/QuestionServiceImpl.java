package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.dao.QuestionDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.QuestionService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

	private final static Logger LOGGER = LogManager.getLogger();


	@Override
	public void addQuestion(String idTopic, String title) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException {


		if (!ValidateDate.checkPositiveNumber(idTopic) || !ValidateDate.checkText(title)) {
			throw new ServiseIllegalArgumentException("Illegal data for question");
		}

		Integer checkInteger = Integer.parseInt(idTopic);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.addQuestion(checkInteger, title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (DAODuplicateException e) {
			throw new ServiceDuplicateException(e);
		}
	}

	@Override
	public Question getQuestion(String idQuestion) throws ServiceException , ServiseIllegalArgumentException {


		if (!ValidateDate.checkPositiveNumber(idQuestion)) {
			throw new ServiseIllegalArgumentException("Illegal id of question");
		}

		Integer checkedId = Integer.parseInt(idQuestion);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		Question question = null;

		try {
			question = questionDAO.getQuestion(checkedId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return question;
	}

	@Override
	public Question getQuestionByTitle(String title) throws ServiceException, ServiseIllegalArgumentException {


		if (!ValidateDate.checkText(title)) {
			throw new ServiseIllegalArgumentException("Illegal id of question");
		}


		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		Question question = null;

		try {
			question = questionDAO.getQuestionByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return question;
	}

	@Override
	public void changeQuestion(String oldIdQuestion, String newIdQuestion, String newIdTopic, String newTitle) throws ServiceException , ServiseIllegalArgumentException {

		if (!ValidateDate.checkPositiveNumber(oldIdQuestion) || !ValidateDate.checkPositiveNumber(newIdQuestion) || !ValidateDate.checkPositiveNumber(newIdTopic) || !ValidateDate.checkText(newTitle)) {
			throw new ServiseIllegalArgumentException("Illegal data for change question");
		}

		Integer checkedOldIdQuestion = Integer.parseInt(oldIdQuestion);
		Integer checkedNewIdQuestion = Integer.parseInt(newIdQuestion);
		Integer checkedNewIdTopic = Integer.parseInt(newIdTopic);


		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.changeQuestion(checkedOldIdQuestion, checkedNewIdQuestion, checkedNewIdTopic, newTitle);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteQuestion(String idQuestion) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idQuestion)) {
			throw new ServiseIllegalArgumentException("Illegal id of question");
		}

		Integer checkedIdQuestion = Integer.parseInt(idQuestion);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.deleteQuestion(checkedIdQuestion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}



	@Override
	public void addAnswer (String idQuestion, String idAnswer) throws ServiceException, ServiceDuplicateException , ServiseIllegalArgumentException {

		if (!ValidateDate.checkPositiveNumber(idQuestion) || !ValidateDate.checkPositiveNumber(idAnswer)) {
			throw new ServiseIllegalArgumentException("Illegal data for add answer to question");
		}

		Integer checkedIdQuestion = Integer.parseInt(idQuestion);
		Integer checkedIdAnswer = Integer.parseInt(idAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.addAnswer(checkedIdQuestion, checkedIdAnswer);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (DAODuplicateException e) {
			throw new ServiceDuplicateException(e);
		}

	}

	@Override
	public void deleteAnswer (String idQuestion, String idAnswer) throws ServiceException , ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idQuestion) || !ValidateDate.checkPositiveNumber(idAnswer)) {
			throw new ServiseIllegalArgumentException("Illegal data for delete answer at question");
		}

		Integer checkedIdQuestion = Integer.parseInt(idQuestion);
		Integer checkedIdAnswer = Integer.parseInt(idAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.deleteAnswer(checkedIdQuestion, checkedIdAnswer);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void changeAnswer (String oldIdQuestion, String oldIdAnswer, String newIdAnswer)  throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(oldIdQuestion) || !ValidateDate.checkPositiveNumber(oldIdAnswer) || !ValidateDate.checkPositiveNumber(newIdAnswer)) {
			throw new ServiseIllegalArgumentException("Illegal data for change answer at question");
		}

		Integer checkedOldIdQuestion = Integer.parseInt(oldIdQuestion);
		Integer checkedOldIdAnswer = Integer.parseInt(oldIdAnswer);
		Integer checkedNewIdAnswer = Integer.parseInt(newIdAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		try {
			questionDAO.changeAnswer(checkedOldIdQuestion, checkedOldIdAnswer, checkedNewIdAnswer);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Question> getQuestionsByPopular(String count) throws ServiceException , ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(count)) {
			throw new ServiseIllegalArgumentException("Illegal count of question");
		}

		Integer checkedCount = Integer.parseInt(count);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		List<Question> questions;

		try {
			questions = questionDAO.getQuestionsByPopular(checkedCount);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return questions;
	}


	@Override
	public List<Question> getQuestionsFromPoll (String idPoll) throws ServiceException , ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idPoll)) {
			throw new ServiseIllegalArgumentException("Illegal id of poll");
		}

		Integer checkedIdPoll = Integer.parseInt(idPoll);

		DAOFactory daoFactory = DAOFactory.getInstance();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();

		List<Question> questions;

		try {
			questions = questionDAO.getQuestionsFromPoll(checkedIdPoll);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return questions;
	}
}
