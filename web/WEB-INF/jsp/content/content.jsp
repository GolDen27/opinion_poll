<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>

    <c:set var="user" value="${sessionScope.user}"/>
    <c:set var="polls" value="${requestScope.polls}"/>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/css/stylecontent.css">
    <link rel="stylesheet" href="/css/stylemaincont.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.css">
    <link href="https://fonts.googleapis.com/css?family=Comfortaa|Lobster" rel="stylesheet">

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>OP</title>
    <style>

        html {
            --photo-path: url("${user.photoPath}");
        }

    </style>
</head>
<body>

<!--фон-->
<div id="bg"></div>
<!--фон-->

<br/>


<br/>


<!--профиль-->

<div class="Profile">

    <div class="Img">
        <div class="overlay"></div>
    </div>
    <div class="PopUp">Open Profile</div>
    <div class="clickPopUp">
        <h4><p class="username" ><c:out value="${user.surname}"/> <c:out value="${user.name}"/></p></h4>
        <h5 class="buttons"><a class="username" href="javascript:$('#menuprofile').click();">Profile</a></h5>
        <h5 class="buttons"><a class="username" href="javascript:$('#menuactivity').click();">Activity</a></h5>
        <c:if test="${!sessionScope.user.typeOfUser}">
            <h5 class="buttons"><a class="username" href="/BecomeAdmin">Become an administrator</a></h5>
        </c:if>
        <div class="Social">
            <a  href="javascript:$('#menusettings').click();">
                <svg viewBox="0 0 478.703 478.703" width="512px" height="512px" id="logo">
                    <path d="M454.2,189.101l-33.6-5.7c-3.5-11.3-8-22.2-13.5-32.6l19.8-27.7c8.4-11.8,7.1-27.9-3.2-38.1l-29.8-29.8    c-5.6-5.6-13-8.7-20.9-8.7c-6.2,0-12.1,1.9-17.1,5.5l-27.8,19.8c-10.8-5.7-22.1-10.4-33.8-13.9l-5.6-33.2    c-2.4-14.3-14.7-24.7-29.2-24.7h-42.1c-14.5,0-26.8,10.4-29.2,24.7l-5.8,34c-11.2,3.5-22.1,8.1-32.5,13.7l-27.5-19.8    c-5-3.6-11-5.5-17.2-5.5c-7.9,0-15.4,3.1-20.9,8.7l-29.9,29.8c-10.2,10.2-11.6,26.3-3.2,38.1l20,28.1    c-5.5,10.5-9.9,21.4-13.3,32.7l-33.2,5.6c-14.3,2.4-24.7,14.7-24.7,29.2v42.1c0,14.5,10.4,26.8,24.7,29.2l34,5.8    c3.5,11.2,8.1,22.1,13.7,32.5l-19.7,27.4c-8.4,11.8-7.1,27.9,3.2,38.1l29.8,29.8c5.6,5.6,13,8.7,20.9,8.7c6.2,0,12.1-1.9,17.1-5.5    l28.1-20c10.1,5.3,20.7,9.6,31.6,13l5.6,33.6c2.4,14.3,14.7,24.7,29.2,24.7h42.2c14.5,0,26.8-10.4,29.2-24.7l5.7-33.6    c11.3-3.5,22.2-8,32.6-13.5l27.7,19.8c5,3.6,11,5.5,17.2,5.5l0,0c7.9,0,15.3-3.1,20.9-8.7l29.8-29.8c10.2-10.2,11.6-26.3,3.2-38.1    l-19.8-27.8c5.5-10.5,10.1-21.4,13.5-32.6l33.6-5.6c14.3-2.4,24.7-14.7,24.7-29.2v-42.1    C478.9,203.801,468.5,191.501,454.2,189.101z M451.9,260.401c0,1.3-0.9,2.4-2.2,2.6l-42,7c-5.3,0.9-9.5,4.8-10.8,9.9    c-3.8,14.7-9.6,28.8-17.4,41.9c-2.7,4.6-2.5,10.3,0.6,14.7l24.7,34.8c0.7,1,0.6,2.5-0.3,3.4l-29.8,29.8c-0.7,0.7-1.4,0.8-1.9,0.8    c-0.6,0-1.1-0.2-1.5-0.5l-34.7-24.7c-4.3-3.1-10.1-3.3-14.7-0.6c-13.1,7.8-27.2,13.6-41.9,17.4c-5.2,1.3-9.1,5.6-9.9,10.8l-7.1,42    c-0.2,1.3-1.3,2.2-2.6,2.2h-42.1c-1.3,0-2.4-0.9-2.6-2.2l-7-42c-0.9-5.3-4.8-9.5-9.9-10.8c-14.3-3.7-28.1-9.4-41-16.8    c-2.1-1.2-4.5-1.8-6.8-1.8c-2.7,0-5.5,0.8-7.8,2.5l-35,24.9c-0.5,0.3-1,0.5-1.5,0.5c-0.4,0-1.2-0.1-1.9-0.8l-29.8-29.8    c-0.9-0.9-1-2.3-0.3-3.4l24.6-34.5c3.1-4.4,3.3-10.2,0.6-14.8c-7.8-13-13.8-27.1-17.6-41.8c-1.4-5.1-5.6-9-10.8-9.9l-42.3-7.2    c-1.3-0.2-2.2-1.3-2.2-2.6v-42.1c0-1.3,0.9-2.4,2.2-2.6l41.7-7c5.3-0.9,9.6-4.8,10.9-10c3.7-14.7,9.4-28.9,17.1-42    c2.7-4.6,2.4-10.3-0.7-14.6l-24.9-35c-0.7-1-0.6-2.5,0.3-3.4l29.8-29.8c0.7-0.7,1.4-0.8,1.9-0.8c0.6,0,1.1,0.2,1.5,0.5l34.5,24.6    c4.4,3.1,10.2,3.3,14.8,0.6c13-7.8,27.1-13.8,41.8-17.6c5.1-1.4,9-5.6,9.9-10.8l7.2-42.3c0.2-1.3,1.3-2.2,2.6-2.2h42.1    c1.3,0,2.4,0.9,2.6,2.2l7,41.7c0.9,5.3,4.8,9.6,10,10.9c15.1,3.8,29.5,9.7,42.9,17.6c4.6,2.7,10.3,2.5,14.7-0.6l34.5-24.8    c0.5-0.3,1-0.5,1.5-0.5c0.4,0,1.2,0.1,1.9,0.8l29.8,29.8c0.9,0.9,1,2.3,0.3,3.4l-24.7,34.7c-3.1,4.3-3.3,10.1-0.6,14.7    c7.8,13.1,13.6,27.2,17.4,41.9c1.3,5.2,5.6,9.1,10.8,9.9l42,7.1c1.3,0.2,2.2,1.3,2.2,2.6v42.1H451.9z"
                          fill="#FFFFFF"/>
                    <path d="M239.4,136.001c-57,0-103.3,46.3-103.3,103.3s46.3,103.3,103.3,103.3s103.3-46.3,103.3-103.3S296.4,136.001,239.4,136.001    z M239.4,315.601c-42.1,0-76.3-34.2-76.3-76.3s34.2-76.3,76.3-76.3s76.3,34.2,76.3,76.3S281.5,315.601,239.4,315.601z"
                          fill="#FFFFFF"/>
                </svg>
            </a>
        </div>
    </div>
</div>
<!--профиль-->


<!--меню-->


<div class="wrapper-menu">

    <div id="container-menu">

        <img id="imglogotype" src="img/pic.png" alt="logoт"/>


        <ul id="menu">
            <li><a id="menuhomepage" href="#">Home page</a></li>
            <li id="small-prof"><a id="menuuser" href="#"><c:out value="${user.surname}"/> <c:out value="${user.name}"/></a>
                <ul>
                    <li><a id="menuprofile" href="#">Profile</a></li>
                    <li><a id="menuactivity" href="#">Activity</a></li>
                    <c:if test="${!sessionScope.user.typeOfUser}">
                        <li><a id="menubecomeanadmin" href="/BecomeAdmin">Become an administrator</a></li>
                    </c:if>
                    <li><a id="menusettings" href="#">Settings</a></li>
                </ul>
            </li>
            <li><a id="menuopinionpoll" href="#">Opinion poll</a>
                <c:if test="${sessionScope.user.typeOfUser}">
                    <ul>
                        <li>
                            <a id="menuaddpoll" href="#">Add poll</a>
                        </li>
                    </ul>
                </c:if>
            </li>
            <li><a id="menupeople" href="#">People</a></li>

            <c:if test="${sessionScope.user.typeOfUser}">
                <li><a id="menustatistic" href="#">Statistic</a>
                    <ul>
                        <li><a id="menustatopinionpoll" href="#">Opinion poll</a></li>
                        <li><a id="menustatpeople" href="#">People</a></li>
                    </ul>
                </li>
            </c:if>
            <li><a id="menusupport" href="#">Support</a></li>
            <li><a href="/Controller?command=logout">Exit</a></li>
        </ul>
    </div>

</div>
<!--меню-->


<!--контент-->

<div class="wrapper-content">
    <div class="content-page">

        <div id="homepagecontainer" style="display: block;">
            <div class="noop" data-santa-version="1.2200.5" data-reactid=".0">
                <div class="SITE_ROOT" id="SITE_ROOT" style="width:980px;padding-bottom:40px;" data-reactid=".0.$SITE_ROOT">
                    <div id="masterPage" style="width: 980px; position: static; top: 0px; height: 1208px;" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot">

                        <div style="width: 980px; position: absolute; top: 5px; height: 1198px; left: 0px;" class="s2" data-state="" id="PAGES_CONTAINER" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER">
                            <div id="PAGES_CONTAINERscreenWidthBackground" class="s2screenWidthBackground" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.0" style="width: 1905px; left: -463px;"></div>
                            <div id="PAGES_CONTAINERcenteredContent" class="s2centeredContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1">
                                <div id="PAGES_CONTAINERbg" class="s2bg" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.0"></div>
                                <div id="PAGES_CONTAINERinlineContent" class="s2inlineContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1">
                                    <div style="left: 0px; width: 980px; position: absolute; top: 0px; height: 1198px;" class="s3" id="SITE_PAGES" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES">
                                        <div style="left: 0px; width: 980px; position: absolute; top: 0px; height: 1198px;" class="s4" id="c5n4" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4">
                                            <div id="c5n4bg" class="s4bg" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.0"></div>
                                            <div id="c5n4inlineContent" class="s4inlineContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1">
                                                <div style="left: 0px; position: absolute; top: 0px; width: 580px; height: 275px;" data-exact-height="275" data-content-padding-horizontal="0" data-content-padding-vertical="0" title="" class="s5" id="id5kf35e" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e">
                                                    <div style="width: 580px; height: 275px;" id="id5kf35elink" class="s5link" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e.0">
                                                        <div id="id5kf35eimg" data-style="" class="s5img" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e.0.0" style="position: relative; width: 580px; height: 275px;">
                                                            <div class="s5imgpreloader" id="id5kf35eimgpreloader" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e.0.0.0"></div>
                                                            <img id="id5kf35eimgimage" alt="" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e.0.0.$image" src="./img/ca1e0d_00cbd3a8f70d4f23b3421ec064841ae5-mv2.png" style="width: 580px; height: 275px; object-fit: cover;">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div style="left: 580px; width: 400px; position: absolute; top: 124px; height: 151px;" class="s6" id="id5kf35e_0" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_0">
                                                    <div id="id5kf35e_0bg" class="s6bg" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_0.0"></div>
                                                    <div id="id5kf35e_0inlineContent" class="s6inlineContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_0.1">
                                                        <div style="left: 76px; width: 248px; position: absolute; top: 25px;" class="s7" id="id5kf35e_1" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_0.1.$id5kf35e_1">
                                                            <p class="font_8"><span class="color_15">Создать опрос - проще простого.</span></p>
                                                            <p class="font_8"><span class="color_15"><span class="wixGuard">​</span></span></p>
                                                            <p class="font_8"><span class="color_15">Анализируйте результаты в режиме реального времени</span></p>
                                                            <p class="font_8"><span class="color_15"><span class="wixGuard">​</span>​</span></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="ie8iz1ad" data-align="center" data-disabled="false" data-margin="0" data-should-use-flex="true" style="left: 321px; position: absolute; top: 275px; height: 120px; min-height: 30px; width: 120px;" class="s10" data-state="desktop shouldUseFlex center" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8iz1ad" data-prev-text="Опросы" data-prev-min-width="86" data-prev-width="120"><a href="javascript:$('#menuopinionpoll').click();" target="_self" id="ie8iz1adlink" class="g-transparent-a s10link" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8iz1ad.0"><span id="ie8iz1adlabel" class="s10label" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8iz1ad.0.0">Опросы</span></a></div>
                                                <div style="left: 441px; width: 369px; position: absolute; top: 275px; height: 210px;" class="s8" id="id5kf35f" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f">
                                                    <div id="id5kf35fbg" class="s8bg" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f.0"></div>
                                                    <div id="id5kf35finlineContent" class="s8inlineContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f.1">
                                                        <div style="left: 27px; width: 314px; position: absolute; top: 72px;" class="s7" id="id5kf35f_2" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f.1.$id5kf35f_2">
                                                            <h6 class="font_6"><a id="menudocaboutdesign" href="#" target="_self"><span class="color_11">Доступно для всех девайсов</span></a></h6>
                                                            <p class="font_8">&nbsp;</p>
                                                            <p class="font_8"><span class="color_11">Соберите больше ответов.</span></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div style="left: 0px; position: absolute; top: 485px; width: 750px; height: 450px;" data-exact-height="450" data-content-padding-horizontal="0" data-content-padding-vertical="0" title="" class="s5" id="id5kf35e_4" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_4">
                                                    <div style="width: 750px; height: 450px;" id="id5kf35e_4link" class="s5link" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_4.0">
                                                        <div id="id5kf35e_4img" data-style="" class="s5img" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_4.0.0" style="position: relative; width: 750px; height: 450px;">
                                                            <div class="s5imgpreloader" id="id5kf35e_4imgpreloader" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_4.0.0.0"></div>
                                                            <img id="id5kf35e_4imgimage" alt="" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35e_4.0.0.$image" src="./img/ca1e0d_f5ddbea84edd4f2396377b975dd258e3-mv2.png" style="width: 750px; height: 450px; object-fit: cover;">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div id="ie8j1bwt" data-align="center" data-disabled="false" data-margin="0" data-should-use-flex="true" style="left: 320px; position: absolute; top: 935px; height: 148px; min-height: 30px; width: 148px;" class="s11" data-state="desktop shouldUseFlex center" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8j1bwt" data-prev-text="Статистика" data-prev-min-width="130" data-prev-width="148"><a href="javascript:$('#menustatistic').click();" target="_self" id="ie8j1bwtlink" class="g-transparent-a s11link" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8j1bwt.0"><span id="ie8j1bwtlabel" class="s11label" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$ie8j1bwt.0.0">Статистика</span></a></div>
                                                <div style="left: 468px; width: 512px; position: absolute; top: 935px; height: 263px;" class="s9" id="id5kf35f_4" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f_4">
                                                    <div id="id5kf35f_4bg" class="s9bg" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f_4.0"></div>
                                                    <div id="id5kf35f_4inlineContent" class="s9inlineContent" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f_4.1">
                                                        <div style="left: 36px; width: 439px; position: absolute; top: 26px;" class="s7" id="id5kf35f_5" data-reactid=".0.$SITE_ROOT.$desktop_siteRoot.$PAGES_CONTAINER.1.1.$SITE_PAGES.$c5n4.1.$id5kf35f_4.1.$id5kf35f_5">
                                                            <h6 class="font_6" style="text-align:center;"><a id="menudocaboutpoll" href="#" target="_self">Современные опросы помогают нашим пользователям</a></h6>
                                                            <p class="font_8" style="text-align:center;">&nbsp;</p>
                                                            <p class="font_8" style="text-align:center;"><span class="wixGuard">​</span></p>
                                                            <ul class="font_8" style="margin-left:40px;">
                                                                <li>
                                                                    <p class="font_8">удовлетворённость клиентов</p>
                                                                </li>
                                                                <li>
                                                                    <p class="font_8">маркетинговое исследование</p>
                                                                </li>
                                                                <li>
                                                                    <p class="font_8">управление кадрами</p>
                                                                </li>
                                                                <li>
                                                                    <p class="font_8">образовательный процесс</p>
                                                                </li>
                                                                <li>
                                                                    <p class="font_8">мероприятия</p>
                                                                </li>
                                                                <li>
                                                                    <p class="font_8">друзья и семья</p>
                                                                </li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



            </div>
        </div>
        <div id="opinionpollcontainer" style="display: none;">
            <c:forEach items="${requestScope.polls}" var="item">
                <div class="bl">

                    <c:if test="${sessionScope.user.typeOfUser}">
                        <div style="position: absolute;">
                            <a href="/Controller?command=Edit&id_poll=${item.id}">
                                <svg  x="0px" y="0px" viewBox="0 0 300 300" width="30px" height="30px">
                                    <path d="M149.996,0C67.157,0,0.001,67.161,0.001,149.997S67.157,300,149.996,300s150.003-67.163,150.003-150.003    S232.835,0,149.996,0z M221.302,107.945l-14.247,14.247l-29.001-28.999l-11.002,11.002l29.001,29.001l-71.132,71.126    l-28.999-28.996L84.92,186.328l28.999,28.999l-7.088,7.088l-0.135-0.135c-0.786,1.294-2.064,2.238-3.582,2.575l-27.043,6.03    c-0.405,0.091-0.817,0.135-1.224,0.135c-1.476,0-2.91-0.581-3.973-1.647c-1.364-1.359-1.932-3.322-1.512-5.203l6.027-27.035    c0.34-1.517,1.286-2.798,2.578-3.582l-0.137-0.137L192.3,78.941c1.678-1.675,4.404-1.675,6.082,0.005l22.922,22.917    C222.982,103.541,222.982,106.267,221.302,107.945z" fill="#4e9153" fill-opacity="0.5"/>
                                </svg>
                            </a>
                        </div>
                    </c:if>
                    
                    <div class="b1-title">${item.titlePoll}</div>
                    <hr>
                    <div class="b1-desc">${item.description}</div>
                    <form action="/Controller" method="get">
                        <input type="hidden" name="command" value="pass_poll">
                        <input type="hidden" name="id_poll" value="${item.id}">
                        <input type="submit" class="buttonpoll" value="POLL"></button>
                    </form>
                </div>
            </c:forEach>
            <div class="pagination">
                <ul>
                    <li class="prev <c:if test = "${requestScope.page == 1}">disabled</c:if>"><a href="/Controller?command=load_content&page=${requestScope.page-1}">&lt;</a></li>

                    <c:forEach var="i" begin="1" end="${requestScope.pageCount}">
                        <li <c:if test = "${requestScope.page == i}">class="active"</c:if> ><a href="/Controller?command=load_content&page=${i}">${i}</a></li>
                    </c:forEach>


                    <li class="next <c:if test = "${requestScope.page == requestScope.pageCount}">disabled</c:if>">
                        <a href="/Controller?command=load_content&page=${requestScope.page+1}">&gt;</a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="peoplecontainer" style="display: none;">
            <c:forEach items="${requestScope.users}" var="usermap">
                <div class="people-item-conteiner">
                    <div class="userimground" style="background: url(${usermap.key.photoPath}); background-size: cover; background-position-x: 50%;"></div>
                    <p><span>${usermap.key.surname}&nbsp;${usermap.key.name}</span></p>
                    <p>Возраст:<span>${usermap.key.age}</span></p>
                    <p>Пройдено тестов:<span>${usermap.value}</span></p>
                </div>
                <hr>

            </c:forEach>
        </div>
        <c:if test="${sessionScope.user.typeOfUser}">
            <div id="statpoll" style="display: none;">
                <br>
                <table class="table-fill">
                    <thead>
                    <tr>
                        <th class="text-left">Название опроса</th>
                        <th class="text-left">Прохождений</th>
                    </tr>
                    </thead>
                    <tbody class="table-hover">
                    <c:forEach items="${requestScope.poppoll}" var="poppollmap">
                        <tr>
                            <td class="text-left">${poppollmap.key.titlePoll}</td>
                            <td class="text-left">${poppollmap.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>


            </div>
            <div id="statuser" style="display: none;">
                <br>
                <table class="table-fill">
                    <thead>
                    <tr>
                        <th class="text-left">Пользователь</th>
                        <th class="text-left">Пройденные опросы</th>
                    </tr>
                    </thead>
                    <tbody class="table-hover">
                    <c:forEach items="${requestScope.polluser}" var="pollusermap">
                        <tr>
                            <td class="text-left">${pollusermap.key.surname} ${pollusermap.key.name}</td>
                            <td class="text-left">
                                <c:forEach items="${pollusermap.value}" var="polllist">
                                    <p>${polllist.titlePoll}</p>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <div id="supportcontainer" style="display: none;">
            <div class="profileinfo">
                <div class="profileinforow">
                    Ваши претензии, предложения и замечания отправляете на почтовый адрес qwerty@mail.ru
                </div>
            </div>
        </div>
        <div id="usersettingscontainer" style="display: none;">
            <form action="/Controller" method="post">

                <input type="hidden" name="command" value="user_settings"/>

                <div class="profileinfo">
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Почта</div>
                            <div class="profilerowtext">
                                <input id="firstemail" type="email" name="email" required autocomplete="off"
                                                               pattern="^[^@]+@[^@]+\.[a-zA-Z]{2,}$" title="name@example.com" value="${sessionScope.user.login}"/>
                            </div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Фамилия</div>
                            <div class="profilerowtext">
                                <input type="text" name="lastname" required autocomplete="off" pattern="^[A-ZА-Я][a-zа-я]{1,}$"
                                                               title="Фамилия с большой буквы" value="${sessionScope.user.surname}"/>
                            </div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Имя</div>
                            <div class="profilerowtext">
                                <input type="text" name="firstname" required autocomplete="off" pattern="^[A-ZА-Я][a-zа-я]{1,}$"
                                                               title="Имя с большой буквы" value="${sessionScope.user.name}"/>
                            </div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Возраст</div>
                            <div class="profilerowtext">
                                <input type="number" name="year" required autocomplete="off" min="7" max="120" title="7 – 120 лет" value="${sessionScope.user.age}"/>
                            </div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Пол</div>
                            <div class="profilerowtext">
                                <select name="gender">
                                    <option value="-1" <c:if test="${sessionScope.user.gender==-1}">selected</c:if>>Не установлен</option>
                                    <option value="0" <c:if test="${sessionScope.user.gender==0}">selected</c:if>>Женщина</option>
                                    <option value="1" <c:if test="${sessionScope.user.gender==1}">selected</c:if>>Мужчина</option>
                                </select>
                            </div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Страна</div>
                            <div class="profilerowtext"><input type="text" name="country" value="${sessionScope.user.country}"></div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Телефон</div>
                            <div class="profilerowtext"><input type="text" name="phone" value="${sessionScope.user.phone}"></div>
                        </label>
                    </div>
                    <div class="profileinforow">
                        <label>
                            <div class="profilerowcaption">Ссылка на личный сайт</div>
                            <div class="profilerowtext"><input type="text" name="site-link" value="${sessionScope.user.siteLink}"></div>
                        </label>
                    </div>
                </div>

                <input type="submit">
            </form>



            <form action="FileUpload" method="post" enctype="multipart/form-data">
                <input type="file" name="data">
                <input type="hidden" name="user" value="${sessionScope.user.login}">
                <input type="submit">
            </form>
        </div>
        <div id="profilecont" style="display: none;">
            <div class="profileinfo">
                <div class="profileinforow">
                    <div class="profilerowcaption">Почта</div>
                    <div class="profilerowtext">${sessionScope.user.login}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Имя</div>
                    <div class="profilerowtext">${sessionScope.user.name}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Фамилия</div>
                    <div class="profilerowtext">${sessionScope.user.surname}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Возраст</div>
                    <div class="profilerowtext">${sessionScope.user.age}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Пол</div>
                    <div class="profilerowtext">
                        <c:choose>
                            <c:when test="${sessionScope.user.gender==0}">
                                Женский
                            </c:when>
                            <c:when test="${sessionScope.user.gender==1}">
                                Мужской
                            </c:when>
                            <c:otherwise>
                                Не установлен
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Страна</div>
                    <div class="profilerowtext">${sessionScope.user.country}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Телефон</div>
                    <div class="profilerowtext">${sessionScope.user.phone}</div>
                </div>
                <div class="profileinforow">
                    <div class="profilerowcaption">Ссылка на личную страницу</div>
                    <div class="profilerowtext">${sessionScope.user.siteLink}</div>
                </div>
            </div>
            <button class="buttonpoll">
                <a href="javascript:$('#menusettings').click();">изменить</a>
            </button>
        </div>
        <div id="useractivity" style="display: none;">
            <div>Пройденные опросы</div>
            <c:forEach items="${requestScope.userpolls}" var="pollfromuser">
                <div class="bl">

                    <c:if test="${sessionScope.user.typeOfUser}">
                        <div style="position: absolute;">
                            <a href="/Controller?command=Edit&id_poll=${item.id}">
                                <svg  x="0px" y="0px" viewBox="0 0 300 300" width="30px" height="30px">
                                    <path d="M149.996,0C67.157,0,0.001,67.161,0.001,149.997S67.157,300,149.996,300s150.003-67.163,150.003-150.003    S232.835,0,149.996,0z M221.302,107.945l-14.247,14.247l-29.001-28.999l-11.002,11.002l29.001,29.001l-71.132,71.126    l-28.999-28.996L84.92,186.328l28.999,28.999l-7.088,7.088l-0.135-0.135c-0.786,1.294-2.064,2.238-3.582,2.575l-27.043,6.03    c-0.405,0.091-0.817,0.135-1.224,0.135c-1.476,0-2.91-0.581-3.973-1.647c-1.364-1.359-1.932-3.322-1.512-5.203l6.027-27.035    c0.34-1.517,1.286-2.798,2.578-3.582l-0.137-0.137L192.3,78.941c1.678-1.675,4.404-1.675,6.082,0.005l22.922,22.917    C222.982,103.541,222.982,106.267,221.302,107.945z" fill="#4e9153" fill-opacity="0.5"/>
                                </svg>
                            </a>
                        </div>
                    </c:if>

                    <div class="b1-title">${pollfromuser.titlePoll}</div>
                    <hr>
                    <div class="b1-desc">${pollfromuser.description}</div>
                </div>
            </c:forEach>
        </div>
        <div id="docaboutdesign" style="display: none;">
            <iframe src="https://docs.google.com/document/d/1g1Jw5k0XOz2jTTlXXnggByICm7cmMKDHg-9Q5cIPweg/pub?embedded=true" width="100%" height="900px"></iframe>
        </div>
        <div id="docaboutpoll" style="display: none;">
            <iframe src="https://docs.google.com/document/d/1jeGrpMmQeDY9l3r7RPRovfhFS-y9OO0EdVihIlMgTec/pub?embedded=true" width="100%" height="900px"></iframe>
        </div>
        <div id="addpollcontainer" style="display: none;">
            <form action="/Controller" method="post">
                <input type="hidden" name="command" value="add_poll">
                <div class="profileinfo">
                    <label>
                        <div class="profileinforow">
                            <div class="profilerowcaption">Название</div>
                            <div class="profilerowtext"><input type="text" name="title"></div>
                        </div>
                    </label>
                    <label>
                        <div class="profileinforow">
                            <div class="profilerowcaption">Описание</div>
                            <div class="profilerowtext"><input type="text" name="description"></div>
                        </div>
                    </label>
                    <label>
                        <div class="profileinforow">
                            <div class="profilerowcaption">Тема</div>
                            <div class="profilerowtext"><input type="text" name="topic"></div>
                        </div>
                    </label>
                </div>

                <input class="buttonpoll" type="submit" value="Создать">
            </form>
        </div>
    </div>
</div>

<!--контент-->


<br>
<hr>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
<script src="/js/background.js"></script>
<script src="/js/switchlang.js"></script>
<script src="/js/profile.js"></script>
<script src="/js/menuuser.js"></script>
<script src="/js/menuadmin.js"></script>
<script src="/js/pagination.js"></script>
</body>
</html>
