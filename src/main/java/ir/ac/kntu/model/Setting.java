package ir.ac.kntu.model;

import java.util.*;

public class Setting {

    private RegularUserRepository userRepo;
    private RegularUserBugs regularUserBugs;

    public Setting(RegularUserRepository userRepo, RegularUserBugs regularUserBugs) {
        this.userRepo = userRepo;
        this.regularUserBugs = regularUserBugs;
    }

    public RegularUser finedRegularUserInfo(String input) {
        for (RegularUser info : userRepo.getAllUsers()) {
            if (info.getEmail().equals(input) || info.getPhoneNumber().equals(input)) {
                return info;
            }
        }
        return null;
    }

    public void updateInformation(String input, Scanner scanner) {
        RegularUser regularUser = finedRegularUserInfo(input);
        if (regularUser == null) {
            System.out.println("user not found!!!");
            return;
        }
        while (true) {
            System.out.println("what title you want to update? \n1.firstName\n\"2.lastName\n3.email\n4.phoneNumber\n5.password\n6.quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> updateTi(scanner, regularUser);
                case 2 -> updateTiLn(scanner, regularUser);
                case 3 -> emailPart(regularUser,scanner);
                case 4 -> phonePart(regularUser,scanner);
                case 5 -> passwordPart(regularUser,scanner);
                case 6 -> {
                    return;
                }
                default -> System.out.println("invalid choice");
            }
        }
    }

    public void updateTiLn(Scanner scanner, RegularUser regularUser) {
        System.out.println("new lastName: ");
        regularUser.setLastName(scanner.nextLine());
    }

    public void updateTi(Scanner scanner, RegularUser regularUser) {
        System.out.println("new firstName: ");
        regularUser.setFirstName(scanner.nextLine());
    }

    public void emailPart(RegularUser regularUser,Scanner scanner){
        System.out.println("new email: ");
        String email = scanner.nextLine();
        if (!regularUserBugs.isEmailFormatOk(email)) {
            System.out.println("email format Error!!!");
        } else if (userRepo.isEmailOrPhoneExists(email, regularUser.getPhoneNumber())) {
            System.out.println("Email already in use.");
        } else {
            regularUser.setEmail(email);
        }
    }

    public void phonePart(RegularUser regularUser,Scanner scanner) {
        System.out.println("new phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        if (!regularUserBugs.isPnFormatOk(phoneNumber)) {
            System.out.println("phoneNumber format Error!!!");
        } else if (userRepo.isEmailOrPhoneExists(regularUser.getEmail(), phoneNumber)) {
            System.out.println("phone number already in use.");
        } else {
            regularUser.setPhoneNumber(phoneNumber);
        }
    }

    public void passwordPart(RegularUser regularUser,Scanner scanner) {
        System.out.println("new password: ");
        String password = scanner.nextLine();
        if (!regularUserBugs.isPasswordOk(password)) {
            System.out.println("password format Error!!!");
        } else {
            regularUser.setPassword(password);
        }
    }

}
