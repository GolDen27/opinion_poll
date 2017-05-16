package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.*;
import by.tc.opinionpull.dao.*;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDAOImpl implements TestDAO {
	@Override
	public void addTest(Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException, DAODuplicateException {

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.ADD_TEST;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idPoll);
			statement.setInt(2,idQuestion);
			statement.setInt(3,idAnswer);
			statement.setString(4,loginUser);
			statement.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e){
			throw new DAODuplicateException("duplicate test", e);
		} catch (SQLException e) {
			throw new DAOException("error add test", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}

	@Override
	public Test getTest (Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException {


		Test test = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		DAOFactory daoFactory = DAOFactory.getInstance();
		PollDAO pollDAO = daoFactory.getPollDAO();
		QuestionDAO questionDAO = daoFactory.getQuestionDAO();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();
		UserDAO userDAO = daoFactory.getUserDAO();

		String sql = SQLCommand.GET_TEST;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idPoll);
			statement.setInt(2,idQuestion);
			statement.setInt(3,idAnswer);
			statement.setString(4,loginUser);
			try (ResultSet rs = statement.executeQuery()) {
				rs.next();
				test = new Test();
				Poll poll = pollDAO.getPoll(rs.getInt("pq_id_polls"));
				Question question = questionDAO.getQuestion(rs.getInt("pq_qa_id_questions"));
				Answer answer = answerDAO.getAnswer(rs.getInt("qa_id_answers"));
				User user = userDAO.getUser(rs.getString("login_users"));
				test.setPoll(poll);
				test.setQuestion(question);
				test.setAnswer(answer);
				test.setUser(user);
			}
		} catch (SQLException e) {
			throw new DAOException("error get test", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return test;

	}

	@Override
	public void changeTest (Integer oldIdPoll, Integer oldIdQuestion, Integer oldIdAnswer, String oldLoginUser, Integer newIdPoll, Integer newIdQuestion, Integer newIdAnswer, String newLoginUser) throws DAOException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.CHANGE_TEST;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,newIdPoll);
			statement.setInt(2,newIdQuestion);
			statement.setInt(3,newIdAnswer);
			statement.setString(4,newLoginUser);
			statement.setInt(5,oldIdPoll);
			statement.setInt(6,oldIdQuestion);
			statement.setInt(7,oldIdAnswer);
			statement.setString(8,oldLoginUser);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error update test", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public void deleteTest(Integer idPoll, Integer idQuestion, Integer idAnswer, String loginUser) throws DAOException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.DELETE_TEST;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,idPoll);
			statement.setInt(2,idQuestion);
			statement.setInt(3,idAnswer);
			statement.setString(4,loginUser);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error delete test", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}



}
