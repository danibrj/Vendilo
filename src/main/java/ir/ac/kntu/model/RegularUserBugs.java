package ir.ac.kntu.model;

public class RegularUserBugs {
    private RegularUserRepository userRepo;

    public RegularUserBugs(RegularUserRepository userRepo) {
        this.userRepo = userRepo;
    }

//    public boolean isEmailAndPnOk(String email, String phoneNumber){
//        for(RegularUser rUser : regularUser.getRegularUserss()){
//            if(rUser.getEmail().equals(email) || rUser.getPhoneNumber().equals(phoneNumber)){
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isPasswordOk(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%&+=]).{8,}$");
    }

    public boolean isEmailFormatOk(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean isPnFormatOk(String phoneNumber) {
        return phoneNumber.matches("^09\\d{9}$");
    }

    public boolean registerRegularUser(RegularUser regularUser) {
        if (userRepo.isEmailOrPhoneExists(regularUser.getEmail(), regularUser.getPhoneNumber())) {
            System.out.println("the email or phoneNumber is repetitive");
            return false;
        }
        if (!isPasswordOk(regularUser.getPassword())) {
            System.out.println("the password format is wrong!!!");
            return false;
        }
        if (!isEmailFormatOk(regularUser.getEmail())) {
            System.out.println("the email format is wrong!!!");
            return false;
        }
        if (!isPnFormatOk(regularUser.getPhoneNumber())) {
            System.out.println("the phoneNumber format is wrong!!!");
            return false;
        }


        return userRepo.addUser(regularUser);
    }

    public RegularUser login(String input, String password) {
        RegularUser user = userRepo.findUserByLogin(input, password);
        if (user == null) {
            System.out.println("Login failed");
        }
        return user;
    }
}
