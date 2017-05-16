package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.*;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;

public interface TestDAO {

	void addTest (Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException, DAODuplicateException;
	Test getTest (Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException;
	void changeTest (Integer oldIdPoll, Integer oldIdQuestion, Integer oldIdAnswer, String oldLoginUser, Integer newIdPoll, Integer newIdQuestion, Integer newIdAnswer, String newLoginUser) throws DAOException;
	void deleteTest (Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException;


}
