package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

public interface TopicService {

	void addTopic (String title) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException;
	Topic getTopic (String id) throws ServiceException, ServiseIllegalArgumentException ;
	void changeTopic (String oldId, String newId, String newTitle) throws ServiceException, ServiseIllegalArgumentException ;
	void deleteTopic (String id) throws ServiceException, ServiseIllegalArgumentException ;
	Topic searchTopic (String topic) throws ServiceException, ServiseIllegalArgumentException;

}
