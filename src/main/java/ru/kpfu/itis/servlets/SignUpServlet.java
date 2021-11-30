package ru.kpfu.itis.servlets;

import ru.kpfu.itis.exceptions.DuplicateEntryException;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UsersService usersService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        this.usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (User.validate(req, resp)) {
            try {
                UserForm userForm = UserForm.builder()
                        .firstName(req.getParameter("firstName"))
                        .lastName(req.getParameter("lastName"))
                        .email(req.getParameter("email"))
                        .password(req.getParameter("password"))
                        .build();

                usersService.signUp(userForm);
                resp.sendRedirect("/signIn");
                return;

            } catch (DuplicateEntryException e) {
                req.setAttribute("message", "Пользователь с таким email уже существует.");
            }
        } else {
            req.setAttribute("message", "Вы ввели некорректные данные или заполнили не все поля.");
        }

        req.getRequestDispatcher("/WEB-INF/views/signUp.jsp").forward(req, resp);
    }
}
