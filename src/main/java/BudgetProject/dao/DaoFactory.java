package BudgetProject.dao;
import BudgetProject.Config;

public class DaoFactory {
    private static Config config = new Config();
    private static Users usersDao;

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
