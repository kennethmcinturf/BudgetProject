package BudgetProject;

public class Config {
    private String Url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
    private String Username = "root";
    private String Password = "codeup12";

    public String getUrl() {
        return Url;
    }
    public String getUser() {
        return Username;
    }
    public String getPassword() {
        return Password;
    }
}
