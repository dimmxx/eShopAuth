package servlet;

import controller.DbWorker;
import controller.UserController;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(300);

        DbWorker db = new DbWorker();
        User user = new User(username, password);

        UserController userController = new UserController(user, db);

        user = userController.authUser(user);

        if (user.getRole() != null) {
            user.setMessageSb("Access granted. You are logged in as ");
            user.setMessageSb(user.getRole());
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("sessionName", user.getUsername() + session.getId());
        } else {
            user.setMessageSb("Access denied. Enter a correct username and password or register");
            session.setAttribute("user", null);
            session.setAttribute("role", null);
            session.setAttribute("sessionName", null);
        }

        req.setAttribute("user", user);
        RequestDispatcher rd =
                req.getRequestDispatcher("WEB-INF/view/account.jsp");
        rd.forward(req, resp);


    }
}
