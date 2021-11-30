package ru.kpfu.itis.servlets;

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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

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
            req.setAttribute("FirstName", user.getFirstName());
            req.setAttribute("LastName", user.getLastName());
        }
        String eLogOut = "<li><a href=\"/logout\">Выйти</a></li>";
        req.setAttribute("emailLogOut", eLogOut);

        if (req.getSession().getAttribute("Email") == null) {
            resp.sendRedirect("/signIn");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        usersService.deleteByEmail(email);
        resp.sendRedirect("/logout");
    }
}
