package ir.ac.kntu.model;

public class HeadManager {
    private String usernameHm;
    private String passwordHm;

    public HeadManager(String username, String password) {
        this.usernameHm = username;
        this.passwordHm = password;
    }

    public String getUsernameHm() {
        return usernameHm;
    }

    public void setUsernameHm(String usernameHm) {
        this.usernameHm = usernameHm;
    }

    public String getPasswordHm() {
        return passwordHm;
    }

    public void setPasswordHm(String passwordHm) {
        this.passwordHm = passwordHm;
    }
}
