package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.dao.TopicDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.TopicService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TopicServiceImpl implements TopicService {

	private final static Logger LOGGER = LogManager.getLogger();

	@Override
	public void addTopic(String title) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException {

		if (!ValidateDate.checkText(title)) {
			throw new ServiseIllegalArgumentException("Illegal title for add topic");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();

		try {
			topicDAO.addTopic(title);
		} catch (DAOException e) {
			throw new ServiceException();
		} catch (DAODuplicateException e) {
			throw new ServiceDuplicateException(e);
		}
	}

	@Override
	public Topic getTopic(String idTopic) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idTopic)) {
			throw new ServiseIllegalArgumentException("Illegal id for get topic");
		}


		Integer checkedId = Integer.parseInt(idTopic);

		Topic topic = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();

		try {
			topic = topicDAO.getTopic(checkedId);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return topic;
	}

	@Override
	public void changeTopic(String oldIdTopic, String newIdTopic, String newTitle) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(oldIdTopic) || !ValidateDate.checkPositiveRealNumber(newIdTopic) || !ValidateDate.checkText(newTitle)) {
			throw new ServiseIllegalArgumentException("Illegal id for get topic");
		}

		Integer checkedOldIdTopic = Integer.parseInt(oldIdTopic);
		Integer checkedNewIdTopic = Integer.parseInt(newIdTopic);


		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();

		try {
			topicDAO.changeTopic(checkedOldIdTopic, checkedNewIdTopic, newTitle);
		} catch (DAOException e) {
			throw new ServiceException();
		}

	}

	@Override
	public void deleteTopic(String idTopic) throws ServiceException, ServiseIllegalArgumentException  {

		if (!ValidateDate.checkPositiveNumber(idTopic)) {
			throw new ServiseIllegalArgumentException("Illegal id for get topic");
		}

		Integer checkedId = Integer.parseInt(idTopic);

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();

		try {
			topicDAO.deleteTopic(checkedId);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public Topic searchTopic (String topic) throws ServiceException, ServiseIllegalArgumentException {

		if (!ValidateDate.checkText(topic)) {
			throw new ServiseIllegalArgumentException("Illegal title for get topic");
		}

		Topic searchTopic = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();

		try {
			searchTopic = topicDAO.searchTopic(topic);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		return searchTopic;
	}
}
