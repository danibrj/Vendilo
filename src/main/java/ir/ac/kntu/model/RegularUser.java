package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class RegularUser {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private List<RegularUser> regularUserss = new ArrayList<>();
    private UsersWallet usersWallet = new UsersWallet();
    private ShoppingCart cart = ShoppingCart.getSpInstance();
    private UsersAddress usersAddress = new UsersAddress();
    private List<OrderUser> orderUsers = new ArrayList<>();
    private UserSuportWorking userSuportWorking = UserSuportWorking.getWInstance();
    private DiscountCode discountCode = new DiscountCode();
    private IsBlock userIsBlock;

    public RegularUser(String firstName, String lastName, String email, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.userIsBlock = IsBlock.NO;
        regularUserss.add(this);
    }

    public RegularUser() {

    }

    public IsBlock getUserIsBlock() {
        return userIsBlock;
    }

    public void setUserIsBlock(IsBlock userIsBlock) {
        this.userIsBlock = userIsBlock;
    }

    public UserSuportWorking getUserSuportWorking() {
        return userSuportWorking;
    }

    public void setUserSuportWorking(UserSuportWorking userSuportWorking) {
        this.userSuportWorking = userSuportWorking;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    public List<OrderUser> getOrderUsers() {
        return orderUsers;
    }

    public void addorder(OrderUser order) {
        orderUsers.add(order);
    }

    public UsersWallet getUsersWallet() {
        return usersWallet;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public UsersAddress getUsersAddress() {
        return usersAddress;
    }

    public List<RegularUser> getRegularUserss() {
        return regularUserss;
    }

    public void setRegularUserss(RegularUser regularUser) {
        regularUserss.add(regularUser);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", phoneNumber = " + phoneNumber +
                ", password = " + password +
                ", isBlock = " + userIsBlock;
    }
}
