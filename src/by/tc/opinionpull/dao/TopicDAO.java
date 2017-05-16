package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;

public interface TopicDAO {

	void addTopic (String title) throws DAOException, DAODuplicateException;
	Topic getTopic (Integer id) throws DAOException;
	void changeTopic (Integer oldId, Integer newId, String newTitle) throws DAOException;
	void deleteTopic (Integer id) throws DAOException;
	Topic searchTopic (String topic) throws DAOException;

}
