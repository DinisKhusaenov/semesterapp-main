<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.kpfu.itis.models.Deputy" %>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>Голосование</title>

    <%--CSS styles--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">

    <%--JQuery for AJAX--%>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/deputi.js"></script>

    <%--Date Range Picker's files--%>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
    <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css"/>
    <script src="${pageContext.request.contextPath}/static/js/daterange.js"></script>

</head>

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
                                <li>${emailLogOut}</li>

                            </div>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="main-header-rooms">
    <div class="main-flex-rooms">
        <div class="second-flex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main-title">
                            <h1>Голосование</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="room-availability spad">

    <table>
        <%
            List<Deputy> deputies = (List) request.getAttribute("ListDeputies");
        %>
        <%--<tr>
            <th>Фото</th>
            <th>Имя</th>
            <th>Фамилия</th>
            <th>Возраст</th>
            <th>Партия</th>
            <th>Процент</th>
            <th>Описание</th>
        </tr>--%>
        <div class="card-group">
        <% for (int i = 0; i < 5; i++) {%>


            <%--<tr>
                <img src="<%=deputies.get(i).getPhoto()%>" class="img-thumbnail" alt="">
                <td><%=deputies.get(i).getPhoto()%></td>
                <td><%=deputies.get(i).getFirst_name()%></td>
                <td><%=deputies.get(i).getLast_name()%></td>
                <td><%=deputies.get(i).getAge()%></td>
                <td><%=deputies.get(i).getFraction()%></td>
                <td><%=deputies.get(i).getVote()%></td>
                <td><%=deputies.get(i).getTitle()%></td>
            </tr>--%>
<%--            <a href="#" id="button2" class="buttonText">--%>
                <div class="card">
                    <img class="card-img-top" src="<%=deputies.get(i).getPhoto()%>" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"><%=deputies.get(i).getFirst_name()%> <%=deputies.get(i).getLast_name()%></h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-muted"><%=deputies.get(i).getVote()%>%</small></p>
                    </div>
                </div>
<%--            </a>--%>
        <%}%>
        </div>

    </table>
    <div class="container">
        <div class="room-check">
            <div class="row">
                <div class="col-mg-6">
                    <div class="check-form">
                        <h2>Проголосуйте</h2>
                        <div>
                            <div class="datepicker">
                            </div>
                            <div class="room-quantity">
                                <div class="row">
                                    <div class="single-quantity">

                                        <div class="col-lg-4">
                                            <form method="post">
                                                <select id="adults-number" name="adults-number">
                                                    <% for (int i = 0; i < 5; i++) {%>
                                                        <option value="<%=deputies.get(i).getId()%>"><%=deputies.get(i).getFirst_name()%> <%=deputies.get(i).getLast_name()%></option>
                                                    <%}%>
                                                </select>
                                                <button id="check-vote-deputy-btn" name="check-vote-deputy-btn">Проголосовать</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <p></p>

                            <%--@elvariable id="noAvailableRooms" type=""--%>
                            <c:if test="${not empty noAvailableRooms}">
                                <h6 class="text-danger">${noAvailableRooms}</h6>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about-room">
            <div class="row">
                <div class="col-lg-10 offset-lg-1">
                    <h2>“Не важно кто голосует, важно — кто голоса подсчитывает.”.</h2>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="room-section spad">
    <div class="container" id="available-rooms">

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
                    <h5 class="contact-desc">+7 (999) 000-54-54</h5>
                </div>
            </div>
            <div class="col">
                <h3 class="contact-name">E-mail</h3>
                <h5 class="contact-desc">booking@gmail.com</h5>
            </div>
        </div>
    </div>
    <div id="popup" class="popup ${popupLink}">
        <div class="popup__body">
            <div class="popup__content">
                <a href="/main" class="popup__close">Вернуться на главную</a>
                <div class="popup__title">Вы уже проголосовали за ${FirstNameDep} ${LastNameDep}</div>
                <div class="popup__text">Ждите результатов</div>
            </div>
        </div>
    </div>
</footer>
<script src="${pageContext.request.contextPath}/static/js/popup.js"></script>
</body>
</html>
