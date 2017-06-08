<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/css/styleeditpoll.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Comfortaa|Lobster" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>OP</title>

    <c:set var="pagepoll" value="${sessionScope.poll}"/>

</head>
<body>

<!--фон-->
<div id="bg"></div>
<!--фон-->
<br/>


<!--контент-->

<div class="wrapper-content">
    <div class="content-page">

        <div id="poll-edit">
            <div class="top-data">
                <form action="/Controller" method="post">
                    <input type="hidden" name="command" value="edit_poll">
                    <input type="hidden" name="id" value="${pageScope.pagepoll.id}"/>
                    <div>
                        <label>Название<input type="text" name="title" value="${pagepoll.titlePoll}"></label>
                    </div>
                    <div>
                        <label>Описание<input type="text" name="description" value="${pagepoll.description}"></label>
                    </div>
                    <div>
                        <div class="inline">
                            <label>Тема<input type="text" name="topic" value="${pagepoll.topic.title}"></label>
                        </div>
                        <div class="inline">
                            <input type="submit buttonpoll" value="Сохранить">
                        </div>
                    </div>
                </form>
            </div>

            <div id="questioncontainer">
                <c:forEach items="${pagepoll.questions}" var="questionitem">
                    <div class="question">
                        <div class="inline">
                            <form action="/Controller" method="post">
                                <input type="hidden" name="command" value="edit_question">
                                <input type="hidden" name="id" value="${questionitem.id}">
                                <div>
                                    <div><label>Текст вопроса<input type="text" name="title"
                                                                    value="${questionitem.title}"></label></div>
                                    <div>
                                        <div class="inline"><label>Тема вопроса<input type="text" name="topic"
                                                                                      value="${questionitem.topic.title}"></label>
                                        </div>
                                        <input class="inline buttonpoll" type="submit" value="Сохранить">
                                    </div>
                                </div>
                            </form>
                        </div>

                        <div class="inline">
                            <button class="inline buttonpoll">
                                <a href="/Controller?command=delete_question&id=${questionitem.id}">удалить вопрос</a>
                            </button>
                        </div>
                        <button class="buttonpoll">
                            <a id="answerclick${questionitem.id}" href="#">
                                показать ответы
                            </a>
                        </button>
                        <div id="answercontainer${questionitem.id}" style="display: none;">
                            <div class="answerdiv">
                                <c:forEach items="${questionitem.answers}" var="answeritem">
                                    <form action="/Controller" method="post">
                                        <input type="hidden" name="command" value="edit_answer">
                                        <input type="hidden" name="id" value="${answeritem.id}">
                                        <label>Вариант ответа<input type="text" name="title"
                                                                    value="${answeritem.reply}"></label>
                                        <input class="buttonpoll" type="submit" value="Изменить">
                                    </form>
                                    <a href="/Controller?command=delete_answer&id=${answeritem.id}">удалить ответ</a>
                                </c:forEach>
                            </div>

                            <a id="answeraddclick${questionitem.id}" href="#">Добавить ответ</a>
                            <br>
                            <div id="answeraddcont${questionitem.id}">
                                <form action="/Controller" method="post">
                                    <input type="hidden" name="command" value="add_answer">
                                    <input type="hidden" name="questionid" value="${questionitem.id}">
                                    <label>Текст ответа<input type="text" name="reply"></label>
                                    <input class="buttonpoll" type="submit" value="Добавить">
                                </form>
                            </div>

                        </div>

                        <script>
                            answerclick${questionitem.id}.onclick = function () {
                                if (answercontainer${questionitem.id}.style.display == "none") {
                                    answercontainer${questionitem.id}.style.display = "block";
                                } else {
                                    answercontainer${questionitem.id}.style.display = "none";
                                }
                            };
                        </script>

                        <script>
                            answeraddclick${questionitem.id}.onclick = function () {
                                if (answeraddcont${questionitem.id}.style.display == "none") {
                                    answeraddcont${questionitem.id}.style.display = "block";
                                } else {
                                    answeraddcont${questionitem.id}.style.display = "none";
                                }
                            };
                        </script>

                    </div>

                </c:forEach>

                <br>
                <a id="questionaddlink" href="#">Добавить вопрос</a>
                <br>
                <div id="questionaddcontainer" style="display: none">
                    <form action="/Controller" method="post">
                        <input type="hidden" name="command" value="add_question">
                        <input type="hidden" name="pollid" value="${pagepoll.id}">
                        <label>Название<input type="text" name="title"></label>
                        <label>Тема<input type="text" name="topic"></label>
                        <input type="submit" value="Сохранить">
                    </form>
                </div>
            </div>

            <br>

            <a href="/Controller?command=delete_poll&id=${pagepoll.id}">
                <button class="buttonpoll">
                    Удалить опрос
                </button>
            </a>
        </div>

        <button class="buttonpoll">
            <a id="returnbtn" href="/Main">Вернуться</a>
        </button>

    </div>
</div>

<!--контент-->


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="/js/background.js"></script>
<script src="/js/edit.js"></script>
</body>
</html>
