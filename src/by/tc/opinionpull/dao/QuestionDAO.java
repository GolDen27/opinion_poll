package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;

import java.util.List;

public interface QuestionDAO {

	void addQuestion (Integer idTopic, String title) throws DAOException, DAODuplicateException;
	Question getQuestion (Integer id) throws DAOException;
	Question getQuestionByTitle (String title) throws DAOException;
	void changeQuestion (Integer oldId, Integer newId, Integer newIdTopic, String newTitle) throws DAOException;
	void deleteQuestion (Integer id) throws DAOException;

	void addAnswer (Integer idQuestion, Integer idAnswer) throws DAOException, DAODuplicateException ;
	void deleteAnswer (Integer idQuestion, Integer idAnswer) throws DAOException ;
	void changeAnswer (Integer idQuestion, Integer oldIdAnswer, Integer newIdAnswer) throws DAOException ;

	List<Question> getQuestionsByPopular (Integer count) throws DAOException ;

	List<Question> getQuestionsFromPoll (Integer idPoll) throws DAOException;


}
