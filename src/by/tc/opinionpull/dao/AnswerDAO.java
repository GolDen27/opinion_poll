package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface AnswerDAO {

	void addAnswer (String reply) throws DAOException, DAODuplicateException;
	Answer getAnswer (Integer idAnswer) throws DAOException;
	Answer getAnswerByReply (String reply) throws DAOException;
	void changeAnswer (Integer oldIdAnswer, Integer newIdAnswer, String newReply) throws DAOException;
	void deleteAnswer (Integer idAnswer) throws DAOException;

	Map<Answer, Integer> getPopularAnswer (Integer idQuestion) throws DAOException ;

	List<Answer> getAnswersFromQuestion (Integer idQuestion) throws DAOException ;

}
