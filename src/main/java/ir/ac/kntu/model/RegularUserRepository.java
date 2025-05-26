package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class RegularUserRepository {

    private static final RegularUserRepository Rinstance = new RegularUserRepository();
    private List<RegularUser> users = new ArrayList<>();

    public static RegularUserRepository getRinstance() {
        return Rinstance;
    }

    public boolean addUser(RegularUser user) {
        if (!isEmailOrPhoneExists(user.getEmail(), user.getPhoneNumber())) {
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean isEmailOrPhoneExists(String email, String phoneNumber) {
        for (RegularUser user : users) {
            if (user.getEmail().equals(email) || user.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public List<RegularUser> getAllUsers() {
        return users;
    }

    public RegularUser findUserByLogin(String input, String password) {
        for (RegularUser user : users) {
            if ((user.getEmail().equals(input) || user.getPhoneNumber().equals(input)) &&
                    user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}