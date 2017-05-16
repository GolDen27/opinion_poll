<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>



<fmt:setLocale value="ru"/>
<fmt:setBundle basename="localization.local" var="loc"/>

<fmt:message bundle="${loc}" key="welcome.title" var="title"/>
<fmt:message bundle="${loc}" key="registration.messagefirst" var="regsuccess"/>
<fmt:message bundle="${loc}" key="registration.messagesecond" var="gotomes"/>
<fmt:message bundle="${loc}" key="registration.gotomain" var="mainlink"/>





<html>
<head>

    <meta charset="UTF-8">


    <title>${title}</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link rel="stylesheet" href="css/stylesuccessregister.css">



</head>


<body>

<div id="particles-js">
</div>




<div class="form">
    <h1>
        ${regsuccess}
        <br/>
        ${gotomes} <a href="index.jsp">${mainlink}</a>
    </h1>
</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js'></script>
<script src="js/index.js"></script>

</body>
</html>
