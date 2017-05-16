package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

import java.util.List;

public interface QuestionService {

	void addQuestion (String idTopic, String title) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException;
	Question getQuestion (String id) throws ServiceException, ServiseIllegalArgumentException ;
	void changeQuestion (String id, String newId, String newIdTopic, String newTitle) throws ServiceException, ServiseIllegalArgumentException ;
	void deleteQuestion (String id) throws ServiceException, ServiseIllegalArgumentException ;

	void addAnswer (String idQuestion, String idAnswer) throws ServiceException, ServiceDuplicateException , ServiseIllegalArgumentException ;
	void deleteAnswer (String idQuestion, String idAnswer) throws ServiceException, ServiseIllegalArgumentException  ;
	void changeAnswer (String idQuestion, String oldIdAnswer, String newIdAnswer) throws ServiceException, ServiseIllegalArgumentException  ;

	List<Question> getQuestionsByPopular (String count) throws ServiceException , ServiseIllegalArgumentException ;

	List<Question> getQuestionsFromPoll (String idPoll) throws ServiceException , ServiseIllegalArgumentException ;



}
