package BudgetProject.controllers;

import BudgetProject.dao.DaoFactory;
import BudgetProject.dao.MySQLUsersDao;
import BudgetProject.models.User;
import BudgetProject.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean meetsRequirement(String string) {
        boolean cap = false;
        boolean number = false;
        for (int i = 0; i < string.length(); i++){
            if (Character.isUpperCase(string.charAt(i))){
                cap = true;
            }else if (Character.isDigit(string.charAt(i))){
                number = true;
            }
        }
        if (cap && number){
            return true;
        }else {
            return false;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/user_info/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String conirmPassword = request.getParameter("confirm_password");

        Boolean inputHasError = !username.isEmpty() ||
                !email.isEmpty() ||
                !password.equals(conirmPassword);

        if (!inputHasError){
            response.sendRedirect("/register");
        }

        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        request.setAttribute("username", username);
        request.getRequestDispatcher("/WEB-INF/user_info/login.jsp").forward(request, response);
    }
}
