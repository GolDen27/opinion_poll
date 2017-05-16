package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.dao.SQLCommand;
import by.tc.opinionpull.dao.TopicDAO;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TopicDAOImpl implements TopicDAO {
	@Override
	public void addTopic(String title) throws DAOException, DAODuplicateException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.ADD_TOPIC;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1,title);
			statement.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e){
			throw new DAODuplicateException("duplicate topic", e);
		} catch (SQLException e) {
			throw new DAOException("error add topic", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public Topic getTopic(Integer id) throws DAOException {

		Topic topic = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.GET_TOPIC;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,id);
			try (ResultSet rs = statement.executeQuery()) {
				rs.next();

				topic = new Topic();
				topic.setId(rs.getInt("id_topics"));
				topic.setTitle(rs.getString("title_topics"));
			}
		} catch (SQLException e) {
			throw new DAOException("error get topic", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return topic;
	}

	@Override
	public void changeTopic(Integer oldId, Integer newId, String newTitle) throws DAOException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.CHANGE_TOPIC;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,newId);
			statement.setString(2,newTitle);
			statement.setInt(3,oldId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error update topic", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}


	@Override
	public void deleteTopic(Integer id) throws DAOException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.DELETE_TOPIC;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error delete topic", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public Topic searchTopic(String topic) throws DAOException {

		Topic searchTopic = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.SEARCH_TOPIC;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1,topic);
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					searchTopic = new Topic();
					searchTopic.setId(rs.getInt("id_topics"));
					searchTopic.setTitle(rs.getString("title_topics"));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get topic", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return searchTopic;
	}
}
