package by.tc.opinionpull.dao.impl;

import by.tc.opinionpull.bean.Poll;
import by.tc.opinionpull.bean.Question;
import by.tc.opinionpull.bean.Topic;
import by.tc.opinionpull.dao.PollDAO;
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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PollDAOImpl implements PollDAO {

    private final int RECORD_ON_PAGES = 16;


    @Override
    public void addPoll(String titlePoll, String description, Integer idTopic) throws DAOException, DAODuplicateException {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.ADD_POLL;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,titlePoll);
            statement.setString(2,description);
            statement.setInt(3,idTopic);
            statement.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new DAODuplicateException("duplicate poll", e);
        } catch (SQLException e) {
            throw new DAOException("error add poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

    }

    @Override
    public Poll getPoll(Integer idPoll) throws DAOException {

        Poll poll = null;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        DAOFactory daoFactory = DAOFactory.getInstance();
        TopicDAO topicDAO = daoFactory.getTopicDAO();
        QuestionDAO questionDAO = daoFactory.getQuestionDAO();

        String sql = SQLCommand.GET_POLL;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,idPoll);
            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                poll = new Poll();
                poll.setId(rs.getInt("id_polls"));
                poll.setTitlePoll(rs.getString("title_polls"));
                poll.setDescription(rs.getString("description"));
                Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
                poll.setTopic(topic);
                List<Question> questions = questionDAO.getQuestionsFromPoll(poll.getId());
                poll.setQuestions(questions);
            }
        } catch (SQLException e) {
            throw new DAOException("error get answer", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return poll;
    }

    @Override
    public void changePoll(Integer oldIdPoll, Integer newIdPoll, String newTitlePoll, String newDescription, Integer newIdTopic) throws DAOException {


        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.CHANGE_POLL;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,newIdPoll);
            statement.setString(2,newTitlePoll);
            statement.setString(3,newDescription);
            statement.setInt(4,newIdTopic);
            statement.setInt(5,oldIdPoll);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error update poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }


    }



    @Override
    public void deletePoll(Integer idPoll) throws DAOException {



        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.DELETE_POLL;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,idPoll);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error delete poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

    }



    @Override
    public void addQuestion (Integer idPoll, Integer idQuestion) throws DAOException, DAODuplicateException  {

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.ADD_QUESTION_TO_POLL;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,idPoll);
            statement.setInt(2,idQuestion);
            statement.executeUpdate();
        } catch (MySQLIntegrityConstraintViolationException e){
            throw new DAODuplicateException("duplicate question at poll", e);
        } catch (SQLException e) {
            throw new DAOException("error add question to poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }


    }

    @Override
    public void deleteQuestion (Integer idPoll, Integer idQuestion) throws DAOException  {



        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.DELETE_QUESTION_FROM_POLL;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,idPoll);
            statement.setInt(1,idQuestion);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error delete question from poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }


    }

    @Override
    public void changeQuestion (Integer oldIdPoll, Integer oldIdQuestion, Integer newIdQuestion) throws DAOException  {


        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.CHANGE_QUESTION_AT_POLL;

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,newIdQuestion);
            statement.setInt(2,oldIdPoll);
            statement.setInt(3,oldIdQuestion);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("error update question at poll", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }



    }

    @Override
    public Map<Poll, Integer> getPollsByPopular(Integer count) throws DAOException  {

        Map<Poll, Integer> map;
        Poll poll = null;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        DAOFactory daoFactory = DAOFactory.getInstance();
        TopicDAO topicDAO = daoFactory.getTopicDAO();
        QuestionDAO questionDAO = daoFactory.getQuestionDAO();

        String sql = SQLCommand.GET_POLLS_BY_POPULAR;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,count);
            try (ResultSet rs = statement.executeQuery()) {
                map = new LinkedHashMap<Poll, Integer>();
                while (rs.next()) {
                    poll = new Poll();
                    poll.setId(rs.getInt("id_polls"));
                    poll.setTitlePoll(rs.getString("title_polls"));
                    poll.setDescription(rs.getString("description"));
                    Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
                    poll.setTopic(topic);
                    List<Question> questions = questionDAO.getQuestionsFromPoll(poll.getId());
                    poll.setQuestions(questions);
                    map.put(poll, rs.getInt("position"));
                }
            }
        } catch (SQLException e) {
            throw new DAOException("error get polls by popular", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return map;

    }

    @Override
    public List<Poll> getPollsByUser(String loginUser) throws DAOException  {


        List<Poll> polls;
        Poll poll = null;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        DAOFactory daoFactory = DAOFactory.getInstance();
        TopicDAO topicDAO = daoFactory.getTopicDAO();
        QuestionDAO questionDAO = daoFactory.getQuestionDAO();

        String sql = SQLCommand.GET_POLLS_BY_USER;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1,loginUser);
            try (ResultSet rs = statement.executeQuery()) {
                polls = new ArrayList<Poll>();
                while (rs.next()) {
                    poll = new Poll();
                    poll.setId(rs.getInt("id_polls"));
                    poll.setTitlePoll(rs.getString("title_polls"));
                    poll.setDescription(rs.getString("description"));
                    Topic topic = topicDAO.getTopic(rs.getInt("id_topics"));
                    poll.setTopic(topic);
                    List<Question> questions = questionDAO.getQuestionsFromPoll(poll.getId());
                    poll.setQuestions(questions);
                    polls.add(poll);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("error get polls by user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return polls;

    }


    @Override
    public int getPageCount() throws DAOException {
        int count = 0;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        String sql = SQLCommand.GET_COUNT_OF_PAGE_OF_POLL;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,RECORD_ON_PAGES);
            try (ResultSet rs = statement.executeQuery()) {
                rs.next();
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new DAOException("error get count", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }

        return count;
    }

    public List<Poll> getPollsToPage(int pageNumber) throws DAOException {
        List<Poll> polls = new ArrayList<Poll>();
        Poll poll;

        ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
        Connection connection = connectionFactory.getConnectionPool().retrieve();

        DAOFactory daoFactory = DAOFactory.getInstance();
        QuestionDAO questionDAO = daoFactory.getQuestionDAO();

        String sql = SQLCommand.GET_POLLS_TO_PAGE;

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,(pageNumber-1)*RECORD_ON_PAGES);
            statement.setInt(2,RECORD_ON_PAGES);
            try (ResultSet rs = statement.executeQuery()) {
                while(rs.next()) {
                    poll = new Poll();
                    poll.setId(rs.getInt("id_polls"));
                    poll.setTitlePoll(rs.getString("title_polls"));
                    poll.setDescription(rs.getString("description"));
                    List<Question> questions = questionDAO.getQuestionsFromPoll(poll.getId());
                    poll.setQuestions(questions);
                    polls.add(poll);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("error check user", e);
        } finally {
            connectionFactory.getConnectionPool().putback(connection);
        }


        return polls;
    }
}
