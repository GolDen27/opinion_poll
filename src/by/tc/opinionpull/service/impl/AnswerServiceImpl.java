package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.dao.AnswerDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.AnswerService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class AnswerServiceImpl implements AnswerService {

	private final static Logger LOGGER = LogManager.getLogger();

	@Override
	public void addAnswer(String reply) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException {

		if (!ValidateDate.checkText(reply)) {
			throw new ServiseIllegalArgumentException("Illegal reply of answer");
		}

		Answer answer = new Answer();
		answer.setReply(reply);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		try {
			answerDAO.addAnswer(reply);
		} catch (DAOException e) {
			throw new ServiceException("", e);
		} catch (DAODuplicateException e) {
			throw new ServiceDuplicateException(e);
		}

	}

	@Override
	public Answer getAnswer(String idAnswer) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idAnswer)) {
			throw new ServiseIllegalArgumentException("Illegal id of answer");
		}

		Integer checkedId = Integer.parseInt(idAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		Answer answer = null;

		try {
			answer = answerDAO.getAnswer(checkedId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return answer;
	}

	@Override
	public void changeAnswer(String oldId, String newId, String newReply) throws ServiceException, ServiseIllegalArgumentException {

		if (!ValidateDate.checkPositiveNumber(oldId) || !ValidateDate.checkPositiveNumber(newId) || !ValidateDate.checkText(newReply)) {
			throw new ServiseIllegalArgumentException("illegal data on change answer");
		}

		Integer checkedOldId = Integer.parseInt(oldId);
		Integer checkedNewId = Integer.parseInt(newId);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		try {
			answerDAO.changeAnswer(checkedOldId, checkedNewId, newReply);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deleteAnswer(String idAnswer) throws ServiceException , ServiseIllegalArgumentException {


		if (!ValidateDate.checkPositiveNumber(idAnswer)) {
			throw new ServiseIllegalArgumentException("Illegal id of answer");
		}

		Integer checkedId = Integer.parseInt(idAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		try {
			answerDAO.deleteAnswer(checkedId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Map<Answer, Integer> getPopularAnswer(String idQuestion) throws ServiceException , ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idQuestion)) {
			throw new ServiseIllegalArgumentException("Illegal id of question");
		}

		Integer checkedIdQuestion = Integer.parseInt(idQuestion);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		Map<Answer, Integer> answerIntegerMap;

		try {
			answerIntegerMap = answerDAO.getPopularAnswer(checkedIdQuestion);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return answerIntegerMap;
	}


	@Override
	public List<Answer> getAnswersFromQuestion (String idQuestion)  throws ServiceException , ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idQuestion)) {
			throw new ServiseIllegalArgumentException("Illegal id of question");
		}

		Integer checkedId = Integer.parseInt(idQuestion);

		DAOFactory daoFactory = DAOFactory.getInstance();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		List<Answer> answers;

		try {
			answers = answerDAO.getAnswersFromQuestion(checkedId);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return answers;
	}

}
