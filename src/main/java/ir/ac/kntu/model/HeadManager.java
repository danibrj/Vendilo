package ir.ac.kntu.model;

public class HeadManager {
    private String firstNameHm;
    private String usernameHm;
    private String passwordHm;

    public HeadManager(String firstNameHm,String username, String password) {
        this.firstNameHm = firstNameHm;
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

    public String getFirstNameHm() {
        return firstNameHm;
    }

    public void setFirstNameHm(String firstNameHm) {
        this.firstNameHm = firstNameHm;
    }
}
