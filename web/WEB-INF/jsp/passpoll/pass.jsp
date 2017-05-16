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
        <div class="content">
            Title poll:${requestScope.poll.titlePoll}
            <br>
            Description:${requestScope.poll.description}
            <br>
            Topic:${requestScope.poll.topic.title}
            <br>
            <form action="/Controller" method="get">
                <input type="hidden" name="command" value="complete_poll"/>
                <input type="hidden" name="poll" value="${requestScope.poll.id}">
                <c:forEach items="${requestScope.poll.questions}" var="question">
                    Question:${question.title}
                    <br>
                    Topic:${question.topic.title}
                    <br>
                    Answers:
                    <c:forEach items="${question.answers}" var="answer">
                        <label><input type="radio" name="${question.id}" value="${answer.id}" checked>${answer.reply}</label>
                    </c:forEach>
                    <br>
                </c:forEach>
                <input type="submit">
            </form>
        </div>
    </div>
</div>


<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="/js/background.js"></script>
</body>
</html>
