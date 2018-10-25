package objects;

public class User {
    private static String login;
    private static String password;
    private static User user;

    public User() {
        this.login = "dzmitry.aldoshin.87";
        this.password = "10703214ALD";
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

}
