package ru.kpfu.itis.servlets;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
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
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
    }


}
