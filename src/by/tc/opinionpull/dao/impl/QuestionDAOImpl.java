package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.Answer;
import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.dao.AnswerDAO;
import by.tc.opinionpull.dao.QuestionDAO;
import by.tc.opinionpull.dao.SQLCommand;
import by.tc.opinionpull.dao.TopicDAO;
import by.tc.opinionpull.dao.connection.ConnectionFactory;
import by.tc.opinionpull.dao.exception.DAODuplicateException;
import by.tc.opinionpull.dao.exception.DAOException;
import by.tc.opinionpull.dao.factory.DAOFactory;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO {

	@Override
	public void addQuestion(Integer idTopic, String title) throws DAOException, DAODuplicateException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.ADD_QUESTION;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idTopic);
			statement.setString(2,title);
			statement.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e){
			throw new DAODuplicateException("duplicate question", e);
		} catch (SQLException e) {
			throw new DAOException("error add question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public Question getQuestion(Integer idQuestion) throws DAOException {


		Question question = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		String sql = SQLCommand.GET_QUESTION;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idQuestion);
			try (ResultSet rs = statement.executeQuery()) {
				rs.next();
				question = new Question();
				question.setId(rs.getInt("id_questions"));
				question.setTitle(rs.getString("title_questions"));
				Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
				question.setTopic(topic);
				List<Answer> answers = answerDAO.getAnswersFromQuestion(question.getId());
				question.setAnswers(answers);

			}
		} catch (SQLException e) {
			throw new DAOException("error get answer", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return question;

	}

	@Override
	public void changeQuestion(Integer oldIdQuestion, Integer newIdQuestion, Integer newIdTopic, String newTitle) throws DAOException {



		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.CHANGE_QUESTION;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,newIdQuestion);
			statement.setInt(2,newIdTopic);
			statement.setString(3,newTitle);
			statement.setInt(4,oldIdQuestion);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error update question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

	}


	@Override
	public void deleteQuestion(Integer id) throws DAOException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.DELETE_QUESTION;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error delete question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public void addAnswer(Integer idQuestion, Integer idAnswer) throws DAOException, DAODuplicateException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.ADD_ANSWER_TO_QUESTION;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idQuestion);
			statement.setInt(1,idAnswer);
			statement.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e){
			throw new DAODuplicateException("duplicate answer at question", e);
		} catch (SQLException e) {
			throw new DAOException("error add answer to question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public void deleteAnswer(Integer idQuestion, Integer idAnswer)  throws DAOException{



		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.DELETE_ANSWER_FROM_QUESTION;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,idQuestion);
			statement.setInt(2,idAnswer);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error delete answer at question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public void changeAnswer(Integer oldIdQuestion, Integer oldIdAnswer, Integer newIdAnswer) throws DAOException {


		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		String sql = SQLCommand.CHANGE_ANSWER_AT_QUESTION;

		try (PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setInt(1,newIdAnswer);
			statement.setInt(2,oldIdQuestion);
			statement.setInt(3,oldIdAnswer);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("error update answer at question", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}


	}

	@Override
	public List<Question> getQuestionsByPopular(Integer count) throws DAOException {

		List<Question> questions;
		Question question = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		String sql = SQLCommand.GET_QUESTION_BY_POPULAR;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,count);
			try (ResultSet rs = statement.executeQuery()) {
				questions = new ArrayList<Question>();
				while(rs.next()) {
					question = new Question();
					question.setId(rs.getInt("id_questions"));
					Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
					question.setTopic(topic);
					question.setTitle(rs.getString("title_questions"));
					List<Answer> answers = answerDAO.getAnswersFromQuestion(question.getId());
					question.setAnswers(answers);
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get questions by popular", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return questions;

	}

	@Override
	public List<Question> getQuestionsFromPoll (Integer idPoll) throws DAOException {

		List<Question> questions;
		Question question = null;

		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection connection = connectionFactory.getConnectionPool().retrieve();

		DAOFactory daoFactory = DAOFactory.getInstance();
		TopicDAO topicDAO = daoFactory.getTopicDAO();
		AnswerDAO answerDAO = daoFactory.getAnswerDAO();

		String sql = SQLCommand.GET_QUESTIONS_FROM_POLL;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1,idPoll);
			try (ResultSet rs = statement.executeQuery()) {
				questions = new ArrayList<Question>();
				while (rs.next()) {
					question = new Question();
					question.setId(rs.getInt("id_questions"));
					Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
					question.setTopic(topic);
					question.setTitle(rs.getString("title_questions"));
					List<Answer> answers = answerDAO.getAnswersFromQuestion(question.getId());
					question.setAnswers(answers);
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			throw new DAOException("error get questions from poll", e);
		} finally {
			connectionFactory.getConnectionPool().putback(connection);
		}

		return questions;

	}


}
