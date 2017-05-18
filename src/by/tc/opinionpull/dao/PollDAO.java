package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;

import java.util.List;
import java.util.Map;

public interface PollDAO {


    void addPoll (String titlePoll, String description, Integer idTopic) throws DAOException, DAODuplicateException;
    Poll getPoll (Integer id) throws DAOException;
    Poll getPollByTitle (String title) throws DAOException;
    void changePoll (Integer oldId, Integer newId, String newTitlePoll, String newDescription, Integer newIdTopic) throws DAOException;
    void deletePoll (Integer id) throws DAOException;

    void addQuestion (Integer idPoll, Integer idQuestion) throws DAOException, DAODuplicateException ;
    void deleteQuestion (Integer idPoll, Integer idQuestion) throws DAOException ;
    void changeQuestion (Integer idPoll, Integer oldIdQuestion, Integer newIdQuestion) throws DAOException ;

    Map<Poll, Integer> getPollsByPopular (Integer count) throws DAOException ;
    List<Poll> getPollsByUser (String loginUser) throws DAOException ;

    int getPageCount () throws DAOException;
    List<Poll> getPollsToPage(int pageNumber) throws DAOException;
}
