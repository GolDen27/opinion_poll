package by.tc.opinionpull.service;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.service.exception.ServiceDuplicateException;
import by.tc.opinionpull.service.exception.ServiceException;
import by.tc.opinionpull.service.exception.ServiceFailLoginException;
import by.tc.opinionpull.service.exception.ServiseIllegalArgumentException;

import java.util.List;
import java.util.Map;

public interface UserService {

    void addUser (String login, String password, String surname, String name, String typeOfUser, String photoPath, String age) throws ServiceException, ServiceDuplicateException, ServiseIllegalArgumentException ;
    User getUser(String login) throws ServiceException, ServiseIllegalArgumentException;
    void changeUser (String oldLogin, String newLogin, String newPassword, String newSurname, String newName, String newTypeOfUser, String newPhotoPath, String newAge) throws ServiceException, ServiseIllegalArgumentException ;
    void deleteUser (String login) throws ServiceException, ServiseIllegalArgumentException;

    Map<User, Integer> getUsersByActivity (String count) throws ServiceException , ServiseIllegalArgumentException ;

    void checkUser (String login, String password) throws ServiceException, ServiceFailLoginException, ServiseIllegalArgumentException ;

    Map<User,List<Poll>> userPoll (String count) throws ServiceException, ServiseIllegalArgumentException ;

}
