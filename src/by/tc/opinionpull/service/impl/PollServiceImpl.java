package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.dao.PollDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.PollService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class PollServiceImpl implements PollService {

    private final static Logger LOGGER = LogManager.getLogger();


    @Override
    public void addPoll(String titlePoll, String description, String idTopic) throws ServiceException, ServiseIllegalArgumentException  {

        if (!ValidateDate.checkText(titlePoll) || !ValidateDate.checkText(description) || !ValidateDate.checkPositiveNumber(idTopic)) {
            throw new ServiseIllegalArgumentException("Illegal data for poll");
        }

        Integer checkedIdTopic = Integer.parseInt(idTopic);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        try {
            pollDAO.addPoll(titlePoll, description, checkedIdTopic);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } catch (DAODuplicateException e) {
            throw new ServiceException(e);
        }


    }

    @Override
    public Poll getPoll(String idPoll) throws ServiceException, ServiseIllegalArgumentException  {

        if (!ValidateDate.checkPositiveNumber(idPoll)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll");
        }

        Integer checkedId = Integer.parseInt(idPoll);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        Poll poll = null;

        try {
            poll = pollDAO.getPoll(checkedId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return poll;
    }

    @Override
    public Poll getPollByTitle(String title) throws ServiceException, ServiseIllegalArgumentException {

        if (!ValidateDate.checkText(title)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll");
        }


        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        Poll poll = null;

        try {
            poll = pollDAO.getPollByTitle(title);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return poll;
    }

    @Override
    public void changePoll(String oldIdPoll, String newIdPoll, String newTitlePoll, String newDescription, String newIdTopic) throws ServiceException , ServiseIllegalArgumentException {

        if (!ValidateDate.checkPositiveNumber(oldIdPoll) || !ValidateDate.checkPositiveNumber(newIdPoll) || !ValidateDate.checkText(newTitlePoll) || !ValidateDate.checkText(newDescription) || !ValidateDate.checkPositiveNumber(newIdTopic)) {
            throw new ServiseIllegalArgumentException("Illegal data for change poll");
        }

        Integer checkedOldIdPoll = Integer.parseInt(oldIdPoll);
        Integer checkedNewIdPoll = Integer.parseInt(newIdPoll);
        Integer checkedIdTopic = Integer.parseInt(newIdTopic);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        try {
            pollDAO.changePoll(checkedOldIdPoll, checkedNewIdPoll, newTitlePoll, newDescription, checkedIdTopic);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void deletePoll(String idPoll) throws ServiceException, ServiseIllegalArgumentException  {

        if (!ValidateDate.checkPositiveNumber(idPoll)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll");
        }

        Integer checkedId = Integer.parseInt(idPoll);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        try {
            pollDAO.deletePoll(checkedId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }


    @Override
    public void addQuestion (String idPoll, String idQuestion)  throws ServiceException, ServiceDuplicateException , ServiseIllegalArgumentException  {

        if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(idQuestion)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll or question");
        }

        Integer checkedIdPoll = Integer.parseInt(idPoll);
        Integer checkedIdQuestion = Integer.parseInt(idQuestion);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        try {
            pollDAO.addQuestion(checkedIdPoll,checkedIdQuestion);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } catch (DAODuplicateException e) {
            throw new ServiceDuplicateException(e);
        }
    }

    @Override
    public void deleteQuestion (String idPoll, String idQuestion) throws ServiceException , ServiseIllegalArgumentException  {


        if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(idQuestion)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll or question");
        }

        Integer checkedIdPoll = Integer.parseInt(idPoll);
        Integer checkedIdQuestion = Integer.parseInt(idQuestion);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();
    }


    @Override
    public void changeQuestion (String idPoll, String oldIdQuestion, String newIdQuestion) throws ServiceException , ServiseIllegalArgumentException  {

        if (!ValidateDate.checkPositiveNumber(idPoll) || !ValidateDate.checkPositiveNumber(oldIdQuestion) || !ValidateDate.checkPositiveNumber(newIdQuestion)) {
            throw new ServiseIllegalArgumentException("Illegal id of poll or question");
        }

        Integer checkedIdPoll = Integer.parseInt(idPoll);
        Integer checkedOldIdQuestion = Integer.parseInt(oldIdQuestion);
        Integer checkedNewIdQuestion = Integer.parseInt(newIdQuestion);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        try {
            pollDAO.changeQuestion(checkedIdPoll,checkedOldIdQuestion, checkedNewIdQuestion);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public Map<Poll, Integer> getPollsByPopular(String count) throws ServiceException, ServiseIllegalArgumentException   {

        if (!ValidateDate.checkPositiveNumber(count)) {
            throw new ServiseIllegalArgumentException("Illegal count of polls");
        }

        Integer checkedCount = Integer.parseInt(count);

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        Map<Poll, Integer> pollIntegerMap;

        try {
            pollIntegerMap = pollDAO.getPollsByPopular(checkedCount);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return pollIntegerMap;
    }

    @Override
    public List<Poll> getPollsByUser(String loginUser) throws ServiceException  , ServiseIllegalArgumentException {

        if (!ValidateDate.checkLogin(loginUser)) {
            throw new ServiseIllegalArgumentException("Illegal login of user");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();

        List<Poll> polls;

        try {
            polls = pollDAO.getPollsByUser(loginUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return polls;
    }

    @Override
    public int getPageCount() throws ServiceException, ServiseIllegalArgumentException  {

        DAOFactory daoFactory = DAOFactory.getInstance();
        PollDAO pollDAO = daoFactory.getPollDAO();
        int count = 0;

        try {
            count = pollDAO.getPageCount();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return count;
    }

    @Override
    public List<Poll> getPolls(String pageNumber) throws ServiceException, ServiseIllegalArgumentException {


        if (!ValidateDate.checkNumber(pageNumber)) {
            throw new ServiseIllegalArgumentException("Illegal number of page");
        }

        Integer maxPageValue = getPageCount();
        Integer pageNumberInt = Integer.parseInt(pageNumber);

        if (pageNumberInt > maxPageValue || pageNumberInt <= 0) {
            pageNumberInt = pageNumberInt <= 0 ? 1 : maxPageValue;
            LOGGER.warn("illegal page number");
        }

        List<Poll> polls;
            try {

                DAOFactory daoFactory = DAOFactory.getInstance();
                PollDAO pollDAO = daoFactory.getPollDAO();

                polls = pollDAO.getPollsToPage(pageNumberInt);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }

        return polls;
    }
}
