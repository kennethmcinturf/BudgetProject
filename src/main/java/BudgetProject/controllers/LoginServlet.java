package BudgetProject.controllers;

import BudgetProject.dao.DaoFactory;
import BudgetProject.models.User;
import BudgetProject.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (user == null){
            request.setAttribute("username", username);
            request.getRequestDispatcher("WEB-INF/user_info/login.jsp").forward(request, response);
        }
        boolean validAttempt = Password.check(password, user.getPassword());

        if (validAttempt){
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("username", user.getUsername());
            request.getSession().setAttribute("email", user.getEmail());
            request.getSession().setAttribute("userid", user.getId());
            response.sendRedirect("/profile");
        }else {
            request.setAttribute("username", username);
            request.getRequestDispatcher("WEB-INF/user_info/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/user_info/login.jsp").forward(request, response);
    }
}
