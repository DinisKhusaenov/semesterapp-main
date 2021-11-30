package ru.kpfu.itis.servlets;

import ru.kpfu.itis.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        LoginForm loginForm = LoginForm.builder()
                .email(email)
                .password(password)
                .build();

        try {
            Cookie cookie = usersService.signIn(loginForm);
            req.getSession().setAttribute("Email", email);
            resp.addCookie(cookie);
            resp.sendRedirect("/main");
            return;
        } catch (WrongEmailOrPasswordException e) {
            req.setAttribute("message", "Неправильный логин или пароль.");
        }

        req.getRequestDispatcher("/WEB-INF/views/signIn.jsp").forward(req, resp);
    }
}
