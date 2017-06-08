package by.tc.opinionpull.service.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.dao.PollDAO;
import by.tc.opinionpull.dao.UserDAO;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.exception.DAOFailLoginException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import by.tc.opinionpull.service.UserService;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiceFailLoginException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;
import by.tc.opinionpull.service.validate.ValidateDate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {


    private final static Logger LOGGER = LogManager.getLogger();


    @Override
    public void addUser(String loginUser, String password, String surname, String name, String typeOfUser, String photoPath, String age) throws ServiceException, ServiceDuplicateException , ServiseIllegalArgumentException {

        if (!ValidateDate.checkLogin(loginUser) || !ValidateDate.checkPassword(password) || !ValidateDate.checkWordWithBigLetter(surname) || !ValidateDate.checkWordWithBigLetter(name) ||
                !ValidateDate.checkBooleanNumber(typeOfUser) /*TODO || Validate Path*/ || !ValidateDate.checkPositiveNumber(age)) {
            throw new ServiseIllegalArgumentException("Illegal data for add user");
        }

        Boolean checkedTypeOfUser = Boolean.parseBoolean(typeOfUser);
        Integer checkedAge = Integer.parseInt(age);


        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            userDAO.addUser(loginUser, password, surname, name, checkedTypeOfUser, photoPath, checkedAge);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } catch (DAODuplicateException e) {
            throw new ServiceDuplicateException(e);
        }
    }

    @Override
    public User getUser(String loginUser) throws ServiceException, ServiseIllegalArgumentException {

        if (!ValidateDate.checkLogin(loginUser)) {
            throw new ServiseIllegalArgumentException("Illegal login of user");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        User user = null;

        try {
            user = userDAO.getUser(loginUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return user;
    }

    @Override
    public void changeUser(String oldLoginUser, String newLoginUser,  String newSurname, String newName, String newTypeOfUser, String newPhotoPath, String newAge, String newGender, String newCountry, String newPhone, String newSiteLink) throws ServiceException, ServiseIllegalArgumentException  {

        if (!ValidateDate.checkLogin(oldLoginUser) || !ValidateDate.checkLogin(newLoginUser) || !ValidateDate.checkWordWithBigLetter(newSurname) ||
                !ValidateDate.checkWordWithBigLetter(newName) || !ValidateDate.checkBooleanNumber(newTypeOfUser) /*TODO || Validate newPhotoPath*/ || !ValidateDate.checkPositiveNumber(newAge)
                /*TODO!ValidateDate.checkBooleanNumber(newGender)|| !ValidateDate.checkWord(newCountry) || Validate newPhone || Validate newSiteLink*/) {
            throw new ServiseIllegalArgumentException("Illegal data for change user");
        }

        Boolean checkedNewTypeOfUser = newTypeOfUser.equals("1")? true:false;
        Integer checkedNewAge = Integer.parseInt(newAge);
        Byte checkedNewGender = Byte.parseByte(newGender);

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();

        try {
            userDAO.changeUser(oldLoginUser, newLoginUser, newSurname, newName, checkedNewTypeOfUser, newPhotoPath, checkedNewAge, checkedNewGender, newCountry, newPhone, newSiteLink);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public void deleteUser(String loginUser) throws ServiceException, ServiseIllegalArgumentException {

        if (!ValidateDate.checkLogin(loginUser)) {
            throw new ServiseIllegalArgumentException("Illegal login user");
        }


        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();

        try {
            userDAO.deleteUser(loginUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public boolean checkBecomeAdmin(String login) throws ServiceException, ServiseIllegalArgumentException {
        if (!ValidateDate.checkLogin(login)) {
            throw new ServiseIllegalArgumentException("Illegal login user");
        }
        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        try {
            User user = userDAO.getUser(login);
            //TODO
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }



    @Override
    public Map<User, Integer> getUsersByActivity(String count) throws ServiseIllegalArgumentException, ServiceException {

        if (!ValidateDate.checkPositiveNumber(count)) {
            throw new ServiseIllegalArgumentException("Illegal count of users");
        }

        Integer checkedCount = Integer.parseInt(count);

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();

        Map<User, Integer> userIntegerMap;

        try {
            userIntegerMap = userDAO.getUsersByActivity(checkedCount);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return userIntegerMap;
    }


    @Override
    public void checkUser(String login, String password) throws ServiceException, ServiceFailLoginException, ServiseIllegalArgumentException  {

        if(!ValidateDate.checkLogin(login) || !ValidateDate.checkPassword(password)) {
            throw new ServiceFailLoginException("illegal login or password");
        }

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        boolean result;
        try {
            userDAO.checkUser(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } catch (DAOFailLoginException e) {
            throw new ServiceFailLoginException(e);
        }
    }


    @Override
    public Map<User,List<Poll>> userPoll(String count) throws ServiceException, ServiseIllegalArgumentException {

        Integer checkCount = Integer.parseInt(count);

        DAOFactory daoFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoFactory.getUserDAO();
        PollDAO pollDAO = daoFactory.getPollDAO();

        Map<User,List<Poll>> pollsByUser = new LinkedHashMap<User,List<Poll>>();

        Map<User, Integer> users = null;
        try {

            users = userDAO.getUsersByActivity(checkCount);

            for(Map.Entry<User, Integer> item : users.entrySet()) {
                pollsByUser.put(item.getKey(),pollDAO.getPollsByUser(item.getKey().getLogin()));
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }


        return pollsByUser;

    }

}
