package ru.kpfu.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.models.News;
import ru.kpfu.itis.models.Tag;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.NewsService;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/news")
public class NewsServlet extends HttpServlet {

    private NewsService newsService;
    private ObjectMapper objectMapper;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        newsService = (NewsService) context.getAttribute("newsService");
        usersService = (UsersService) context.getAttribute("usersService");
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);

        if (userByEmailOptional.isPresent()) {
            User user = userByEmailOptional.get();
            req.setAttribute("Email", req.getSession().getAttribute("Email"));
            req.setAttribute("FirstName", user.getFirstName());

        }
        if (req.getSession().getAttribute("Email") == null) {
            String enfRegister = "<a href=\"signUp\">Регистрация</a>";
            req.setAttribute("EmailNotFoundRegis", enfRegister);
            String enfSignIn = "<a href=\"signIn\">Войти</a>";
            req.setAttribute("EmailNotFoundSignIn", enfSignIn);
        } else {
            String eLogOut = "<li><a href=\"/logout\">Выйти</a></li>";
            req.setAttribute("emailLogOut", eLogOut);
        }
        req.getRequestDispatcher("/WEB-INF/views/news.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Tag tag = objectMapper.readValue(req.getReader(), Tag.class);

        List<News> newsByTagName = newsService.findByTag(tag.getTagName());

        String newsByTagNameAsJson = objectMapper.writeValueAsString(newsByTagName);
        resp.setContentType("application/json");
        resp.getWriter().println(newsByTagNameAsJson);
    }

}
