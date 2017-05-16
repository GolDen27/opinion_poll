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
    <c:remove var="poll" scope="session"/>

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
                <form action="/Controller" method="post">
                <input type="hidden" name="command" value="edit_poll">
                <input type="hidden" name="id" value="${pageScope.pagepoll.id}"/>
                <label>Название<input type="text" name="title" value="${pagepoll.titlePoll}"></label>
                <br>
                <label>Описание<input type="text" name="description" value="${pagepoll.description}"></label>
                <br>
                <label>Тема<input type="text" name="topic" value="${pagepoll.topic.title}"></label>
                <input type="submit">
                </form>
                <br>
                <a id="questionlink" href="#">Показать вопросы</a>
                <br>
                <div id="questioncontainer" style="display: none;">
                    <c:forEach items="${pagepoll.questions}" var="questionitem">
                        <div>
                             <form action="/Controller" method="post">
                                 <input type="hidden" name="command" value="edit_question">
                                 <input type="hidden" name="id" value="${questionitem.id}">
                                 <label>Название вопроса<input type="text" name="title" value="${questionitem.title}"></label>
                                 <label>Тема вопроса<input type="text" name="topic" value="${questionitem.topic.title}"></label>
                                 <input type="submit">
                             </form>
                            <a href="/Controller?command=delete_question&id=${questionitem.id}">удалить вопрос</a>
                            <br>
                            <a id="answerclick${questionitem.id}" href="#">показать ответы</a>
                            <br>
                            <div id="answercontainer${questionitem.id}" style="display: none;">
                                <c:forEach items="${questionitem.answers}" var="answeritem">
                                    <form action="/Controller" method="post">
                                        <input type="hidden" name="command" value="edit_answer">
                                        <input type="hidden" name="id" value="${answeritem.id}">
                                        вариант ответа<input type="text" name="title" value="${answeritem.reply}">
                                        <input type="submit">
                                    </form>
                                    <a href="/Controller?command=delete_answer&id=${answeritem.id}">удалить ответ</a>
                                </c:forEach>
                            </div>

                            <script>
                                answerclick${questionitem.id}.onclick = function () {
                                    if(answercontainer${questionitem.id}.style.display=="none") {
                                        answercontainer${questionitem.id}.style.display = "block";
                                    } else {
                                        answercontainer${questionitem.id}.style.display = "none";
                                    }
                                }
                            </script>

                        </div>

                    </c:forEach>
                </div>
            <br>
            <a href="/Controller?command=delete_poll&id=${pagepoll.id}">удалить опрос</a>
        </div>

    </div>
</div>

<!--контент-->






<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="/js/background.js"></script>
<script src="/js/edit.js"></script>
</body>
</html>
