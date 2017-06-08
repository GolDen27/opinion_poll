<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

    <c:set var="user" value="${sessionScope.user}"/>
    <c:set var="polls" value="${requestScope.polls}"/>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/css/stylepollpass.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Comfortaa|Lobster" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>OP</title>

</head>
<body>

<!--фон-->
<div id="bg"></div>
<!--фон-->

<br/>

<div class="wrapper-content">
    <div class="content-page">
        <div class="poll-edit">
            <div class="top-data">
                Название:${requestScope.poll.titlePoll}
                <br>
                Описание:${requestScope.poll.description}
                <br>
                Тема:${requestScope.poll.topic.title}
            </div>

            <form action="/Controller" method="get">
                <input type="hidden" name="command" value="complete_poll"/>
                <input type="hidden" name="poll" value="${requestScope.poll.id}">
                <div id="questioncontainer">
                    <c:forEach items="${requestScope.poll.questions}" var="question">
                        <div class="question">
                            <div>
                                Вопрос:${question.title}
                                <br>
                                Тема:${question.topic.title}
                            </div>
                            <div class="answerdiv">
                                Ответы:
                                <br>
                                <c:forEach items="${question.answers}" var="answer">
                                    <label><input type="radio" name="${question.id}" value="${answer.id}"
                                                  checked>${answer.reply}</label>
                                    <br>
                                </c:forEach>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <input type="submit">
            </form>
        </div>
    </div>
</div>


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="/js/background.js"></script>
</body>
</html>
