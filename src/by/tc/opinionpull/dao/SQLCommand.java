package by.tc.opinionpull.dao;

public final class SQLCommand {
    private  SQLCommand() {}

    //------------------ANSWER----------------------
    public final static String ADD_ANSWER = "insert into answers (`reply`) value (?)";
    public final static String GET_ANSWER = "SELECT `id_answers`,`reply` FROM opinion_poll.answers where `id_answers`=?";
    public final static String CHANGE_ANSWER = "UPDATE `opinion_poll`.`answers` SET `id_answers`=?, `reply`=? WHERE `id_answers`=?";
    public final static String DELETE_ANSWER = "{call opinion_poll.delete_user(?)}";

    public final static String GET_ANSWER_BY_POPULAR_FROM_QUESTION = "SELECT `answers`.`id_answers`, `answers`.`reply`, count(`qa_id_answers`) as `position` FROM `opinion_poll`.`tests` join `answers` on `answers`.`id_answers` = `tests`.`qa_id_answers` where `pq_qa_id_questions`=? group by `qa_id_answers` order by `position` desc";
    public final static String GET_ANSWERS_FROM_QUESTION = "SELECT `answers`.`id_answers`,`answers`.`reply` FROM `opinion_poll`.`questions_m2m_answers` join `answers` on `answers`.`id_answers`=`questions_m2m_answers`.`id_answers` where `questions_m2m_answers`.`id_questions` = ?";

    //------------------POLL----------------------
    public final static String ADD_POLL = "INSERT INTO `opinion_poll`.`polls` (`title_polls`, `description`, `id_topics`) VALUES (?, ?, ?)";
    public final static String GET_POLL = "SELECT `id_polls`, `title_polls`, `description`, `id_topics` FROM opinion_poll.polls where `id_polls` = ?";
    public final static String CHANGE_POLL = "UPDATE `opinion_poll`.`polls` SET `id_polls`=?, `title_polls`=?, `description`=?, `id_topics`=? WHERE `id_polls`=?";
    public final static String DELETE_POLL = "{call opinion_poll.delete_poll(?)}";

    public final static String ADD_QUESTION_TO_POLL = "INSERT INTO `opinion_poll`.`polls_m2m_questions` (`id_polls`, `id_questions`) VALUES (?, ?)";
    public final static String DELETE_QUESTION_FROM_POLL = "{call opinion_poll.delete_poll_question(?, ?)}";
    public final static String CHANGE_QUESTION_AT_POLL = "UPDATE `opinion_poll`.`polls_m2m_questions` SET `id_questions`=? WHERE `id_polls`=? and`id_questions`=?";

    public final static String GET_POLLS_BY_POPULAR = "SELECT `polls`.`id_polls`, `polls`.`title_polls`, `polls`.`description`, `polls`.`id_topics`, count(`pq_id_polls`) as `position` FROM (SELECT * FROM opinion_poll.tests group by `pq_id_polls`, `login_users`) as `a` join `polls` on `polls`.`id_polls`=`a`.`pq_id_polls` group by  `pq_id_polls` order by `position` desc limit ?";
    public final static String GET_POLLS_BY_USER = "SELECT `polls`.`id_polls`, `polls`.`title_polls`, `polls`.`description`, `polls`.`id_topics`, `login_users` FROM `opinion_poll`.`tests` join `polls` on `polls`.`id_polls`=`tests`.`pq_id_polls`  where `login_users`=? group by `pq_id_polls`, `login_users`;";

    public final static String GET_COUNT_OF_PAGE_OF_POLL = "SELECT ceiling(count(*)/?) from polls";
    public final static String GET_POLLS_TO_PAGE = "SELECT `id_polls`, `title_polls`, `description` from `polls` order by `id_polls` desc limit ?,?";

    //------------------QUESTION----------------------
    public final static String ADD_QUESTION = "INSERT INTO `opinion_poll`.`questions` (`id_topics`, `title_questions`) VALUES (?, ?)";
    public final static String GET_QUESTION = "SELECT `id_questions`, `id_topics`, `title_questions` FROM opinion_poll.questions where `id_questions`=?";
    public final static String CHANGE_QUESTION = "UPDATE `opinion_poll`.`questions` SET `id_questions`=?, `id_topics`=?, `title_questions`=? WHERE `id_questions`=?";
    public final static String DELETE_QUESTION = "{call opinion_poll.delete_question(?)}";

    public final static String ADD_ANSWER_TO_QUESTION = "INSERT INTO `opinion_poll`.`questions_m2m_answers` (`id_questions`, `id_answers`) VALUES (?, ?)";
    public final static String DELETE_ANSWER_FROM_QUESTION = "{call opinion_poll.delete_question_answer(?, ?)}";
    public final static String CHANGE_ANSWER_AT_QUESTION = "UPDATE `opinion_poll`.`questions_m2m_answers` SET `id_answers`=? WHERE `id_questions`=? and`id_answers`=?";

    public final static String GET_QUESTION_BY_POPULAR = "SELECT `questions`.`id_questions`, `questions`.`id_topics`, `questions`.`title_questions`, count(`pq_qa_id_questions`) as `position` FROM (SELECT * FROM opinion_poll.tests group by `pq_id_polls`, `pq_qa_id_questions`, `login_users`) as `a` join `questions` on `questions`.`id_questions`=`a`.`pq_qa_id_questions` group by `pq_qa_id_questions` order by `position` desc limit ?";

    public final static String GET_QUESTIONS_FROM_POLL = "SELECT `questions`.`id_questions`, `questions`.`id_topics`, `questions`.`title_questions` FROM `opinion_poll`.`polls_m2m_questions`join `questions`on `questions`.`id_questions`=`polls_m2m_questions`.`id_questions` where `polls_m2m_questions`.`id_polls`=?";

    //------------------TEST----------------------
    public final static String ADD_TEST = "INSERT INTO `opinion_poll`.`tests` (`pq_id_polls`, `pq_qa_id_questions`, `qa_id_answers`, `login_users`) VALUES (?, ?, ?, ?)";
    public final static String GET_TEST = "SELECT `pq_id_polls`, `pq_qa_id_questions`, `qa_id_answers`, `login_users` FROM opinion_poll.tests where `pq_id_polls` = ? and  `pq_qa_id_questions` = ? and `qa_id_answers`=? and`login_users`=? ";
    public final static String CHANGE_TEST = "UPDATE `opinion_poll`.`tests` SET `pq_id_polls`=?, `pq_qa_id_questions`=?, `qa_id_answers`=?, `login_users`=? WHERE `pq_id_polls`=? and `pq_qa_id_questions`=? and `qa_id_answers`=?' and`login_users`=?";
    public final static String DELETE_TEST = "{call opinion_poll.delete_test(?, ?)}";

    //------------------TOPIC----------------------
    public final static String ADD_TOPIC = "INSERT INTO `opinion_poll`.`topics` (`title_topics`) VALUES (?)";
    public final static String GET_TOPIC = "SELECT `id_topics`, `title_topics` FROM opinion_poll.topics where `id_topics`=?";
    public final static String CHANGE_TOPIC = "UPDATE `opinion_poll`.`topics` SET `id_topics`=?, `title_topics`=? WHERE `id_topics`=?";
    public final static String DELETE_TOPIC = "call opinion_poll.delete_topic(?)";
    public final static String SEARCH_TOPIC = "SELECT `id_topics`, `title_topics` FROM opinion_poll.topics where `title_topics`=?";

    //------------------USER----------------------
    public final static String ADD_USER = "INSERT into users (`login`,`password`,`surname`,`name`,`type_of_user`, `photo_path`, `age`) value (?,setPassword(?),?,?,?,?,?)";
    public final static String GET_USER = "SELECT `login`, `password`, `surname`, `name`, `type_of_user`, `photo_path`, `age` from opinion_poll.users where `login`=?";
    public final static String CHANGE_USER = "UPDATE `opinion_poll`.`users` SET `login`=?, `password`=setPassword(?), `surname`=?, `name`=?, `type_of_user`=?, `photo_path`=?, `age`=? WHERE `login`=?";
    public final static String DELETE_USER = "call opinion_poll.delete_user(?);";

    public final static String GET_USER_BY_ACTIVITY = "SELECT `users`.`login`, `users`.`password`, `users`.`surname`, `users`.`name`, `users`.`type_of_user`, `users`.`photo_path`, `users`.`age`, count(`login_users`) as `position` FROM (select * from `opinion_poll`.`tests` group by `pq_id_polls`, `login_users`) as `a` join `users` on `users`.`login`=`a`.`login_users` group by (`login_users`) order by (`position`) desc limit ?";

    public final static String CHECK_USER = "SELECT ifnull(setPassword(?) like (select password from users where login=?),0)";
}