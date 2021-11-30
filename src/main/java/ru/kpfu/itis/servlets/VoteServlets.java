package ru.kpfu.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.form.VoteForm;
import ru.kpfu.itis.models.Deputy;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.services.DeputyService;
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

@WebServlet("/vote")
public class VoteServlets extends HttpServlet {
    private DeputyService deputyService;
    private ObjectMapper objectMapper;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        deputyService = (DeputyService) context.getAttribute("deputyService");
        usersService = (UsersService) context.getAttribute("usersService");
        objectMapper = new ObjectMapper();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);
        User user = null;
        if (userByEmailOptional.isPresent()) {
            user = userByEmailOptional.get();
            req.setAttribute("FirstName", user.getFirstName());
            if (user.getDeputies_id() != 0) {
                String popup = "popup-link";
                req.setAttribute("popupLink", popup);
                Optional<Deputy> findByIdOption = deputyService.findById(Long.valueOf(user.getDeputies_id()));
                Deputy deputy = findByIdOption.get();
                req.setAttribute("FirstNameDep", deputy.getFirst_name());
                req.setAttribute("LastNameDep", deputy.getLast_name());
            }
        }
        String eLogOut = "<li><a href=\"/logout\">Выйти</a></li>";
        req.setAttribute("emailLogOut", eLogOut);

        List<Deputy> voteDeputies;
        voteDeputies = deputyService.getAllDeputy();
        req.setAttribute("ListDeputies", voteDeputies);

        if (req.getSession().getAttribute("Email") == null) {
            resp.sendRedirect("/signIn");
        } else {
            req.getRequestDispatcher("/WEB-INF/views/vote.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        VoteForm voteForm = objectMapper.readValue(req.getReader(), VoteForm.class);
        List<Deputy> voteDeputies;
//        voteDeputies = deputyService.getVoteDeputy(voteForm);
        User user = null;

        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("Email");
        Optional<User> userByEmailOptional = usersService.findOneByEmail(email);
        Long userID = null;
        if (userByEmailOptional.isPresent()) {
            user = userByEmailOptional.get();
            userID = user.getId();

        }
        String deputies_id = req.getParameter("adults-number");
        System.out.println(deputies_id);
        usersService.updateDeputiesIdByID(Long.valueOf(deputies_id), userID);
        resp.sendRedirect("/main");

//        String voteAsJson = objectMapper.writeValueAsString(voteDeputies);
//        resp.setContentType("application/json");
//        resp.getWriter().println(voteAsJson);
    }


}
