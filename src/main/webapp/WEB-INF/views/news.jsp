<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Новости</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <%--JQuery for AJAX--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/news.js"></script>
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

<div class="main-header-news">
    <div class="main-flex-rooms">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Новости</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="blog-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="side-bar">
                    <div class="tags-item">
                        <h4>Поиск по тегам</h4>
                        <div class="tag-links">
                            <button class="tag-buttons" id="accommodation-tag" value="Вбросы">Вбросы</button>
                            <button class="tag-buttons" id="hotel-tag" value="ЦИК">ЦИК</button>
                            <button class="tag-buttons" id="events-tag" value="События">События</button>
                            <button class="tag-buttons" id="booking-tag" value="Голосование">Голосование</button>
                            <button class="tag-buttons" id="holidays-tag" value="Праздники">Праздники</button>
                            <button class="tag-buttons" id="news-tag" value="Новости">Новости</button>
                            <button class="tag-buttons" id="uncategorized-tag" value="Без рубрики">Без рубрики</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="w-100"></div>
            <div class="col-lg-8">
                <div class="blog-post" id="blog-post">

                </div>
            </div>
        </div>
    </div>
</section>

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
