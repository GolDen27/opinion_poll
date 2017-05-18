package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.dao.AnswerDAO;
import by.tc.opinionpull.dao.SQLCommand;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnswerDAOImpl implements AnswerDAO {



	@Override
	public void addAnswer(String reply) throws DAOException, DAODuplicateException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.ADD_ANSWER;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1,reply);
			statement.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e){
			throw new DAODuplicateException("duplicate user", e);
		} catch (SQLException e) {
			throw new DAOException("error add answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public Answer getAnswer(Integer id) throws DAOException {

		Answer answer = null;


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.GET_ANSWER;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,id);
			try (ResultSet rs = statement.executeQuery()) {
				rs.next();
				answer = new Answer();
				answer.setId(rs.getInt("id_answers"));
				answer.setReply(rs.getString("reply"));
			}
		} catch (SQLException e) {
			throw new DAOException("error get answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return answer;

	}

	@Override
	public Answer getAnswerByReply(String reply) throws DAOException {
		Answer answer = null;



		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.GET_ANSWER_BY_REPLY;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1,reply);
			try (ResultSet rs = statement.executeQuery()) {
				if(rs.next()) {
					answer = new Answer();
					answer.setId(rs.getInt("id_answers"));
					answer.setReply(rs.getString("reply"));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


		return answer;
	}

	@Override
	public void changeAnswer(Integer oldId, Integer newId, String newReply) throws DAOException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.CHANGE_ANSWER;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,newId);
			statement.setString(2,newReply);
			statement.setInt(3,oldId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error update answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public void deleteAnswer(Integer id) throws DAOException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.DELETE_ANSWER;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error delete answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public Map<Answer, Integer> getPopularAnswer(Integer idQuestion) throws DAOException {

		Map<Answer, Integer> map;
		Answer answer;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.GET_ANSWER_BY_POPULAR_FROM_QUESTION;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idQuestion);
			try (ResultSet rs = statement.executeQuery()) {
				map = new LinkedHashMap<Answer,Integer>();
				while(rs.next()) {
					answer = new Answer();
					answer.setId(rs.getInt("id_answers"));
					answer.setReply(rs.getString("reply"));
					map.put(answer, rs.getInt("position"));
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get popular answers", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return map;
	}

	@Override
	public List<Answer> getAnswersFromQuestion (Integer idQuestion)  throws DAOException {


		List<Answer> answers;
		Answer answer;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.GET_ANSWERS_FROM_QUESTION;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idQuestion);
			try (ResultSet rs = statement.executeQuery()) {
				answers = new ArrayList<Answer>();
				while(rs.next()) {
					answer = new Answer();
					answer.setId(rs.getInt("id_answers"));
					answer.setReply(rs.getString("reply"));
					answers.add(answer);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get answers", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return answers;
	}
}
