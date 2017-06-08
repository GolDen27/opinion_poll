<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

    <c:set var="user" value="${sessionScope.user}"/>


    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/css/stylebecomeadmin.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">

    <title>Title</title>
</head>
<body>

<!--фон-->
<div id="bg"></div>
<!--фон-->


<!--контент-->

<div class="wrapper-content">
    <div class="content-page">

        <div id="becomeadmincontainer">
            <img src="img/admin_post.gif" width="40%">
            <p>Администатор имеет право создавать опросы, изменять опросы, удалять опросы, просматривать самые популярные опросы и активных ползователей.</p>
            <br>
            <p>Для того чтобы стать администратором необходимо:</p>
            <ul>
                <li>Пройти 5 опросов</li>
                <li>Заполнить профиль</li>
                <li>Добавить фотографию</li>
            </ul>
            <a id="checkparam" href="#" class="button12" tabindex="0">Проверить</a>
            <span id="result"></span>
        </div>
    </div>
</div>

<!--контент-->



<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<script src="/js/background.js"></script>
<script src="/js/becomeadminscript.js"></script>

</body>
</html>
