<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:if test="${sessionScope.lang==null}">
    <c:set var="lang" scope="session" value="en"/>
</c:if>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="localization.local" var="loc"/>

<fmt:message bundle="${loc}" key="welcome.title" var="title"/>
<fmt:message bundle="${loc}" key="welcome.tab.signup" var="tabsignup"/>
<fmt:message bundle="${loc}" key="welcome.tab.login" var="tablogin"/>
<fmt:message bundle="${loc}" key="welcome.login.welcomeback" var="welcomeback"/>
<fmt:message bundle="${loc}" key="welcome.login.field.email" var="fieldemail"/>
<fmt:message bundle="${loc}" key="welcome.login.field.pass" var="fieldpass"/>
<fmt:message bundle="${loc}" key="welcome.login.button.login" var="btnlogin"/>
<fmt:message bundle="${loc}" key="welcome.signup.firstname" var="firstname"/>
<fmt:message bundle="${loc}" key="welcome.signup.lastname" var="lastname"/>
<fmt:message bundle="${loc}" key="welcome.signup.email" var="email"/>
<fmt:message bundle="${loc}" key="welcome.signup.secondemail" var="secondemail"/>
<fmt:message bundle="${loc}" key="welcome.signup.logo" var="logo"/>
<fmt:message bundle="${loc}" key="welcome.signup.pass" var="pass"/>
<fmt:message bundle="${loc}" key="welcome.signup.getstart" var="register"/>
<fmt:message bundle="${loc}" key="welcome.signup.repeatemail" var="repeatemail"/>
<fmt:message bundle="${loc}" key="welcome.login.invalidlogorpass" var="invalidlogorpass"/>
<fmt:message bundle="${loc}" key="welcome.signup.passrepeat" var="passrepeat"/>
<fmt:message bundle="${loc}" key="welcome.signup.age" var="age"/>



<c:if test="${sessionScope.user!=null}">
    <c:redirect url="/Controller?command=load_content"/>
</c:if>


<html>
<head>

    <meta charset="UTF-8">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" \>

    <title>${title}</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link rel="stylesheet" href="css/styleindex.css">


</head>


<body>
<br>
<div id="switch">
    <div class="diamond"></div>
    <a class="undecoratedhref" href="/Controller?command=change_language">
        <div class="choice <c:if test="${sessionScope.lang=='ru'}"> <c:out value="on"></c:out> </c:if>  ">РУС</div>
        <div class="choice  <c:if test="${sessionScope.lang=='en'}"> <c:out value="on"></c:out> </c:if>   ">EN</div>
    </a>
</div>
<br>


<div id="particles-js">
</div>







<div class="form">

    <ul class="tab-group">
        <li class="tab active"><a id="loginlink" href="#login">${tablogin}</a></li>
        <li class="tab"><a id="signuplink" href="#signup">${tabsignup}</a></li>
    </ul>



    <div class="tab-content">


        <div id="login">
            <h1>${welcomeback}</h1>

            <form action="Controller" method="post">

                <input type="hidden" name="command" value="login">

                <div class="field-wrap">
                    <label>
                        ${fieldemail}<span class="req">*</span>
                    </label>
                    <input type="email" name="email" required autocomplete="off" autofocus/>
                </div>

                <div class="field-wrap">
                    <label>
                        ${fieldpass}<span class="req">*</span>
                    </label>
                    <input type="password" name="password" required autocomplete="off"/>
                </div>


                <button type="submit" class="button button-block">${btnlogin}</button>

                <c:if test="${sessionScope.faillogin}">
                    <c:remove var="faillogin" scope="session"/>
                    <br/>
                    <font color="red">${invalidlogorpass}</font>
                </c:if>

            </form>

        </div>

        <div id="signup">
            <h1>${logo}</h1>

            <form action="Controller" method="post" onsubmit="return validateForm()" name ="testForm">
                <input type="hidden" name="command" value="signin">

                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            ${firstname}<span class="req">*</span>
                        </label>
                        <input type="text" name="firstname" required autocomplete="off" pattern="^[A-ZА-Я][a-zа-я]{1,}$"
                               title="Имя с большой буквы"/>
                    </div>

                    <div class="field-wrap">
                        <label>
                            ${lastname}<span class="req">*</span>
                        </label>
                        <input type="text" name="lastname" required autocomplete="off" pattern="^[A-ZА-Я][a-zа-я]{1,}$"
                               title="Фамилия с большой буквы"/>
                    </div>

                    <div class="field-wrap">
                        <label>
                            ${age}<span class="req">*</span>
                        </label>
                        <input type="number" name="year" required autocomplete="off" min="7" max="120" title="7 – 120 лет"/>
                    </div>
                </div>

                <div class="field-wrap">
                    <label>
                        ${email}<span class="req">*</span>
                    </label>
                    <input id="firstemail" type="email" name="email" required autocomplete="off"
                           pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="name@example.com"
                           style="display: inline-block;"/>
                    <c:if test="${sessionScope.isduplicateregister}">
                        <c:remove var="isduplicateregister" scope="session"/>
                        <br/>
                        <font color="red">${repeatemail}</font>
                        <script>
                            document.addEventListener("DOMContentLoaded", function(event) {
                                document.getElementById("signuplink").click();
                            });
                        </script>
                    </c:if>
                </div>
                <div class="field-wrap">
                    <label>
                        ${pass}<span class="req">*</span>
                    </label>
                    <input type="password" name="password1" required autocomplete="off"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$"
                           title="не менее 6 символов, не менее одной буквы в каждом регистре и не менее одной цифры"/>
                </div>

                <div class="field-wrap">
                    <label>
                        ${passrepeat}<span class="req">*</span>
                    </label>
                    <input type="password" name="password2" required autocomplete="off"
                           pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$"
                           title="не менее 6 символов, не менее одной буквы в каждом регистре и не менее одной цифры"/>
                    <font id="err-pass" color="red"></font>
                </div>

                <button type="submit" class="button button-block">${register}</button>

            </form>

        </div>


    </div>

</div>


<form action="FileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="data">
    <input type="submit">
</form>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='http://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js'></script>
<script src="js/index.js"></script>
<script src="js/switchlang.js"></script>

</body>
</html>
