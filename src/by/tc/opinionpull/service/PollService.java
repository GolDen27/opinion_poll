package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

import java.util.List;
import java.util.Map;

public interface PollService {

    void addPoll (String titlePoll, String description, String idTopic) throws ServiceException, ServiseIllegalArgumentException ;
    Poll getPoll (String id) throws ServiceException, ServiseIllegalArgumentException ;
    Poll getPollByTitle (String title) throws ServiceException, ServiseIllegalArgumentException ;
    void changePoll (String oldId, String newId, String newTitlePoll, String newDescription, String newIdTopic) throws ServiceException, ServiseIllegalArgumentException ;
    void deletePoll (String id) throws ServiceException, ServiseIllegalArgumentException ;

    void addQuestion (String idPoll, String idQuestion) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException ;
    void deleteQuestion (String idPoll, String idQuestion) throws ServiceException , ServiseIllegalArgumentException ;
    void changeQuestion (String idPoll, String oldIdQuestion, String newIdQuestion) throws ServiceException , ServiseIllegalArgumentException ;

    Map<Poll, Integer> getPollsByPopular (String count) throws ServiceException , ServiseIllegalArgumentException ;
    List<Poll> getPollsByUser (String loginUser) throws ServiceException , ServiseIllegalArgumentException ;

    int getPageCount () throws ServiceException, ServiseIllegalArgumentException ;
    List<Poll> getPolls (String pageNumber) throws ServiceException, ServiseIllegalArgumentException;
}
