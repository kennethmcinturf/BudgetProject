package BudgetProject.dao;
import BudgetProject.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    User editUser(User user);
}
