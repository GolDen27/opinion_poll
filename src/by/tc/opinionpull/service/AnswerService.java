package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

import java.util.List;
import java.util.Map;

public interface AnswerService {

	void addAnswer (String reply) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException;
	Answer getAnswer (String id) throws ServiceException, ServiseIllegalArgumentException ;
	void changeAnswer (String oldId, String newId, String newReply) throws ServiceException, ServiseIllegalArgumentException ;
	void deleteAnswer (String id) throws ServiceException, ServiseIllegalArgumentException ;

	Map<Answer, Integer> getPopularAnswer (String idQuestion) throws ServiceException, ServiseIllegalArgumentException ;

	List<Answer> getAnswersFromQuestion (String idQuestion) throws ServiceException, ServiseIllegalArgumentException ;


}
