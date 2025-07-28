package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;


public class FirstRegularUserMenu {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        RegularUserRepository userRepo = RegularUserRepository.getRinstance();
        RegularUserBugs regularUserBugs = new RegularUserBugs(userRepo);
        while (true) {
            System.out.println(cyan + "|----------First User Menu----------|\n" + red + "1." + green + "register\n" + red + "2." + green + "login\n" + red + "3." + green + "quit\nselect your choice: " + reset);
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(red + "please enter a valid choice" + reset);
            }
            switch (choice) {
                case 1:
                    show2(regularUserBugs);
                    break;
                case 2:
                    show3(regularUserBugs);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(red + "invalid choice" + reset);
            }
        }
    }

    public void show2(RegularUserBugs regularUserBugs) {
        try {
            System.out.print("firstName: ");
            String firstName = scanner.nextLine().trim();
            if (firstName.isEmpty()) {
                throw new IllegalArgumentException("First name can't be empty");
            }
            System.out.print("lastName: ");
            String lastName = scanner.nextLine().trim();
            if (lastName.isEmpty()) {
                throw new IllegalArgumentException("Last name can't be empty");
            }
            System.out.print("email: ");
            String email = scanner.nextLine().trim();
            if (!email.contains("@")) {
                throw new IllegalArgumentException("Invalid email format");
            }
            System.out.print("phoneNumber: ");
            String phoneNumber = scanner.nextLine().trim();
            if (phoneNumber.length() < 11) {
                throw new IllegalArgumentException("Phone number too short");
            }
            System.out.print("password: ");
            String password = scanner.nextLine().trim();
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password must be at least 4 characters");
            }
            RegularUser newUser = new RegularUser(firstName, lastName, email, phoneNumber, password);
            if (regularUserBugs.registerRegularUser(newUser)) {
                System.out.println(green + "registering is successfully." + reset);
            } else {
                System.out.println(red + "Failed. User might already exist." + reset);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(red + "Error: " + e.getMessage() + reset);
        } catch (Exception e) {
            System.out.println(red + "please try again." + reset);
        }
    }

    public void show3(RegularUserBugs regularUserBugs) {
        try {
            System.out.println(cyan + "|----------Login----------|\n" + reset);
            System.out.print("Enter your email or phoneNmaber: ");
            String input = scanner.nextLine();

            System.out.print("Enter your password: ");
            String pass = scanner.nextLine();

            if (input.isEmpty() || pass.isEmpty()) {
                throw new IllegalArgumentException("Email/Phone and password can't be empty");
            }

            RegularUser user = regularUserBugs.login(input, pass);
            if (user == null) {
                System.out.println(red + "not found!!!" + reset);
                return;
            }
            if (user.getUserIsBlock().equals(IsBlock.YES)) {
                System.out.println(red + "you blocked by manager!!!" + reset);
                return;
            }
            System.out.println(green + "login is successfully.welcome " + reset + user.getFirstName());
            MainRegularUserMenu.getMrum().show(user);
        } catch (IllegalArgumentException e) {
            System.out.println(red + "Error: " + e.getMessage() + reset);
        } catch (Exception e) {
            System.out.println(red + "Unexpected error occurred during login" + reset);
        }
    }
}
