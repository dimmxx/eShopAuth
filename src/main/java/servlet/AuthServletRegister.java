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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthServletRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        String comment = req.getParameter("comment");
        String agree = req.getParameter("agree");

        int ageInt =1;
        try{
            ageInt = Integer.parseInt(age);
        }catch (NumberFormatException e){ }

        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(300);
        if (gender != null && gender != "") {
            session.setAttribute("gender", gender);
        }
        if (gender != null && address != "") {
            session.setAttribute("address", address);
        }

        User user = new User(username, password, email, ageInt, gender, address, comment, Integer.parseInt(agree));
        StringBuilder errorMessage = checkInput(req);

        if (errorMessage.length() == 0) {

            DbWorker db = new DbWorker();
            UserController userController = new UserController(user, db);
            user.setRole("user");
            User temp = user;
            user = null;
            user = userController.addUser(temp);
            if (user.getMessageSb().toString().contains("succeded")) {
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                session.setAttribute("sessionName", user.getUsername() + session.getId());
            } else {
                user.setMessageSb("Registration failed.\n");
            }
            req.setAttribute("user", user);

            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/view/account.jsp");
            rd.forward(req, resp);
        } else {
            user.setMessageSb("Registration failed:\n");
            user.setMessageSb(errorMessage.toString());
            req.setAttribute("user", user);
            RequestDispatcher rd =
                    req.getRequestDispatcher("WEB-INF/view/account.jsp");
            rd.forward(req, resp);
        }


    }

    protected StringBuilder checkInput(HttpServletRequest request) {

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        final Pattern VALID_NAME_REGEX =
                Pattern.compile("^[A-Za-z]{3,8}$");
        final Pattern VALID_PASS_REGEX =
                Pattern.compile("^[A-Za-z0-9]{3,8}$");
        final Pattern VALID_AGE_REGEX =
                Pattern.compile("^[0-9]{2,3}$");

        Matcher matcher;
        StringBuilder errorMessage = new StringBuilder();

        matcher = VALID_NAME_REGEX.matcher(request.getParameter("username"));
        if (!matcher.find()) {
            errorMessage.append("<li>Invalid username (3-8 only letters)</li>");
        }
        matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(request.getParameter("email"));
        if (!matcher.find()) {
            errorMessage.append("<li>Invalid email (Looks like not email address)</li>");
        }
        if (!request.getParameter("password").equals(request.getParameter("repassword"))) {
            errorMessage.append("<li>Passwords do not match</li>");
        }
        matcher = VALID_PASS_REGEX.matcher(request.getParameter("password"));
        if (!matcher.find()) {
            errorMessage.append("<li>Invalid password (3-8 letters and numbers)</li>");
        }
        matcher = VALID_AGE_REGEX.matcher(request.getParameter("age"));
        if (!matcher.find()) {
            errorMessage.append("<li>Invalid age (only numerals allowed)</li>");
        }
        return errorMessage;
    }


}