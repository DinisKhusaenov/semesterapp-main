<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Голосование</title>

    <%--CSS styles--%>
    <%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <%--JQuery for AJAX, Date Range Picker's files--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/allAvailableRooms.js"></script>

    <%--Date Range Picker's files--%>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
    <script src="${pageContext.request.contextPath}/static/js/daterange.js"></script>

</head>

<body>
<header>
    <div class="header-section">
        <div class="menu">
            <div class="container">
                <div class="row">
                    <div class="col-md-5" style="max-width: 400px">
                        <nav>
                            <ul>
                                <li><a href="main">Главная</a></li>
                                <li><a href="vote">Голосовать</a></li>
                            </ul>
                        </nav>
                    </div>
                    <span style="margin: auto">
                        <div class="top-phone-num">
                            <img src="${pageContext.request.contextPath}static/img/phone.png" alt="">
                            <span>+7 (900) 000-00-00</span>
                        </div>
                    </span>
                    <div class="col-md-5" style="max-width: 400px">
                        <nav>
                                <div class="emailNotFound">

                                        <li><a href="/profile">${FirstName}</a></li>
                                        <%--<li><a href="/logout">Выйти</a></li>--%>

                                    <%--<c:if test="${EmailNotFound == null}">
                                         <li><a href="signUp">Регистрация</a></li>
                                         <li><a href="signIn">Войти</a></li>
                                     </c:if>--%>
                                    <li>${EmailNotFoundRegis}</li>
                                    <li>${EmailNotFoundSignIn}</li>
                                    <li>${emailLogOut}</li>

                                </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="main-header">
    <div class="main-flex">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Надеемся, что вам понравится голосовать онлайн.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="follow-instagram">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Присоединяйтесь к нам в Instagram @putin</h2>
            </div>
        </div>
    </div>
</section>

<%--<div class="footer-room-pic">--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="row">--%>
<%--            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-1.jpg" alt="">--%>
<%--            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-2.jpg" alt="">--%>
<%--            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-3.jpg" alt="">--%>
<%--            <img src="${pageContext.request.contextPath}static/img/room-footer-pic/room-4.jpg" alt="">--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<footer class="footer-info">
    <div class="container">
        <div class="row align-items-start">
            <div class="col">
                <h3 class="contact-name">Адрес</h3>
                <h5 class="contact-desc">Казань</h5>
            </div>
            <div class="col">
                <div class="col">
                    <h3 class="contact-name">Телефон</h3>
                    <h5 class="contact-desc">+7 (900) 000-00-00</h5>
                </div>
            </div>
            <div class="col">
                <h3 class="contact-name">E-mail</h3>
                <h5 class="contact-desc">vote@gmail.com</h5>
            </div>
        </div>
    </div>
</footer>

</body>
</html>
