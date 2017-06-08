package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.User;
import by.tc.opinionpull.dao.SQLCommand;
import by.tc.opinionpull.dao.UserDAO;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.exception.DAOFailLoginException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserDAOImpl implements UserDAO {


    @Override
    public void addUser(String login, String password, String surname, String name, Boolean typeOfUser, String photoPath, Integer age) throws DAOException, DAODuplicateException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.ADD_USER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,login);
            statement.setString(2,password);
            statement.setString(3,surname);
            statement.setString(4,name);
            statement.setBoolean(5,typeOfUser);
            statement.setString(6,photoPath);
            statement.setInt(7,age);
            int a = statement.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new DAODuplicateException("duplicate user", e);
        }
        catch (SQLException e) {
            throw new DAOException("error add user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }



    }

    @Override
    public User getUser(String login) throws DAOException {

        User user = null;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.GET_USER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,login);
            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                user = new User();
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setTypeOfUser(rs.getBoolean("type_of_user"));
                user.setPhotoPath(rs.getString("photo_path"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getByte("gender"));
                user.setCountry(rs.getString("country"));
                user.setPhone(rs.getString("phone"));
                user.setSiteLink(rs.getString("site_link"));
            }
        } catch (SQLException e) {
            throw new DAOException("error get user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return user;

    }

    @Override
    public void changeUser(String oldLogin, String newLogin, String newSurname, String newName, Boolean newTypeOfUser, String newPhotoPath, Integer newAge, Byte newGender, String newCountry, String newPhone, String newSiteLink) throws DAOException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.CHANGE_USER;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,newLogin);
            statement.setString(2,newSurname);
            statement.setString(3,newName);
            statement.setBoolean(4,newTypeOfUser);
            statement.setString(5,newPhotoPath);
            statement.setInt(6,newAge);
            statement.setString(7,newGender.toString());
            statement.setString(8,newCountry);
            statement.setString(9,newPhone);
            statement.setString(10,newSiteLink);
            statement.setString(11,oldLogin);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error update user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

    }

    @Override
    public void deleteUser(String login) throws DAOException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.DELETE_USER;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,login);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error delete user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

    }

    @Override
    public Map<User, Integer> getUsersByActivity(Integer count) throws DAOException {

        Map<User, Integer> map;
        User user;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.GET_USER_BY_ACTIVITY;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,count);
            try (ResultSet rs = statement.executeQuery()) {
                map = new LinkedHashMap<User,Integer>();
                while (rs.next()) {
                    user = new User();
                    user.setLogin(rs.getString("login"));
                    user.setPassword(rs.getString("password"));
                    user.setName(rs.getString("name"));
                    user.setSurname(rs.getString("surname"));
                    user.setTypeOfUser(rs.getBoolean("type_of_user"));
                    user.setPhotoPath(rs.getString("photo_path"));
                    user.setAge(rs.getInt("age"));
                    user.setGender(rs.getByte("gender"));
                    user.setCountry(rs.getString("country"));
                    user.setPhone(rs.getString("phone"));
                    user.setSiteLink(rs.getString("site_link"));
                    map.put(user, rs.getInt("position"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("error get users by activity", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return map;
    }



    @Override
    public void checkUser(String login, String password) throws DAOException, DAOFailLoginException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.CHECK_USER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,password);
            statement.setString(2,login);
            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                if (!rs.getBoolean(1)) {
                    throw new DAOFailLoginException("fail login");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("error check user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

    }


}
