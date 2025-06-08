package ir.ac.kntu.model;

public class Supporter {

    private String firstName;
    private String userName;
    private String password;
    private IsBlock supIsBlock;

    public Supporter(String firstName, String userName, String password) {
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.supIsBlock = IsBlock.NO;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IsBlock getSupIsBlock() {
        return supIsBlock;
    }

    public void setSupIsBlock(IsBlock supIsBlock) {
        this.supIsBlock = supIsBlock;
    }

    @Override
    public String toString() {
        return "firstName = " + firstName +
                ", userName = " + userName +
                ", password = " + password +
                ", isBlock = " + supIsBlock;
    }
}
