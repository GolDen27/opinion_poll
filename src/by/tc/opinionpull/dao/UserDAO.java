package by.tc.opinionpull.dao;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.exception.DAOFailLoginException;

import java.util.Map;

public interface UserDAO {

    void addUser (String login, String password, String surname, String name, Boolean typeOfUser, String photoPath, Integer age) throws DAOException, DAODuplicateException;
    User getUser(String login) throws DAOException;
    void changeUser (String oldLogin, String newLogin,  String newSurname, String newName, Boolean newTypeOfUser, String newPhotoPath, Integer newAge, Byte newGender, String newCountry, String newPhone, String newSiteLink) throws DAOException;
    void deleteUser (String login) throws DAOException;

    Map<User, Integer> getUsersByActivity (Integer count) throws DAOException ;

    void checkUser (String login, String password) throws DAOException, DAOFailLoginException;

}
