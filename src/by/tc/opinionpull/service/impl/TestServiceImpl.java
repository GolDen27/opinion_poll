package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Test;
import by.tc.opinionpull.dao.TestDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.TestService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestServiceImpl implements TestService {

	private final static Logger LOGGER = LogManager.getLogger();

	@Override
	public void addTest(String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiceDuplicateException , ServiseIllegalArgumentException {

		if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(idQuestion) || !ValidateDate.checkPositiveNumber(idAnswer) || !ValidateDate.checkLogin(loginUser)) {
			throw new ServiseIllegalArgumentException("Illegal data for add user");
		}

		Integer checkedIdPoll = Integer.parseInt(idPoll);
		Integer checkedIdQuestion = Integer.parseInt(idQuestion);
		Integer checkedAnswer = Integer.parseInt(idAnswer);


		DAOFactory daoFactory = DAOFactory.getInstance();
		TestDAO testDAO = daoFactory.getTestDAO();

		try {
			testDAO.addTest(checkedIdPoll, checkedIdQuestion, checkedAnswer, loginUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		} catch (DAODuplicateException e) {
			throw new ServiceDuplicateException(e);
		}
	}

	@Override
	public Test getTest(String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(idQuestion) || !ValidateDate.checkPositiveNumber(idAnswer) || !ValidateDate.checkLogin(loginUser)) {
			throw new ServiseIllegalArgumentException("Illegal data for add user");
		}

		Integer checkedIdPoll = Integer.parseInt(idPoll);
		Integer checkedIdQuestion = Integer.parseInt(idQuestion);
		Integer checkedIdAnswer = Integer.parseInt(idAnswer);
		String checkedLoginUser = loginUser;

		Test test = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		TestDAO testDAO = daoFactory.getTestDAO();

		try {
			test = testDAO.getTest(checkedIdPoll, checkedIdQuestion, checkedIdAnswer, checkedLoginUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

		return test;
	}

	@Override
	public void changeTest(String oldIdPoll, String oldIdQuestion, String oldIdAnswer, String oldLoginUser, String newIdPoll, String newIdQuestion, String newIdAnswer, String newLoginUser) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(oldIdPoll) || !ValidateDate.checkPositiveNumber(oldIdQuestion) || !ValidateDate.checkPositiveNumber(oldIdAnswer) || !ValidateDate.checkLogin(oldLoginUser) ||
				!ValidateDate.checkPositiveNumber(newIdPoll) || !ValidateDate.checkPositiveNumber(newIdQuestion) || !ValidateDate.checkPositiveNumber(newIdAnswer) || !ValidateDate.checkLogin(newLoginUser) ) {
			throw new ServiseIllegalArgumentException("Illegal data for add user");
		}

		Integer checkedOldIdPoll = Integer.parseInt(oldIdPoll);
		Integer checkedOldIdQuestion = Integer.parseInt(oldIdQuestion);
		Integer checkedOldIdAnswer = Integer.parseInt(oldIdAnswer);
		Integer checkedNewIdPoll = Integer.parseInt(newIdPoll);
		Integer checkedNewIdQuestion = Integer.parseInt(newIdQuestion);
		Integer checkedNewIdAnswer = Integer.parseInt(newIdAnswer);

		DAOFactory daoFactory = DAOFactory.getInstance();
		TestDAO testDAO = daoFactory.getTestDAO();

		try {
			testDAO.changeTest(checkedOldIdPoll, checkedOldIdQuestion, checkedOldIdAnswer, oldLoginUser, checkedNewIdPoll, checkedNewIdQuestion, checkedNewIdAnswer, newLoginUser);

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void deleteTest(String idPoll, String idQuestion, String idAnswer, String loginUser) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(idQuestion) || !ValidateDate.checkPositiveNumber(idAnswer) || !ValidateDate.checkLogin(loginUser)) {
			throw new ServiseIllegalArgumentException("Illegal data for add user");
		}

		Integer checkedIdPoll = Integer.parseInt(idPoll);
		Integer checkedIdQuestion = Integer.parseInt(idQuestion);
		Integer checkedIdAnswer = Integer.parseInt(idAnswer);
		String checkedLoginUser = loginUser;

		DAOFactory daoFactory = DAOFactory.getInstance();
		TestDAO testDAO = daoFactory.getTestDAO();

		try {
			testDAO.deleteTest(checkedIdPoll, checkedIdQuestion, checkedIdAnswer, checkedLoginUser);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}


}
