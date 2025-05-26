package ir.ac.kntu.model;

import java.util.Scanner;

public class FirstRegularUserMenu {

    private Scanner scanner = new Scanner(System.in);

    public void show() {
        RegularUserRepository userRepo = RegularUserRepository.getRinstance();
        RegularUserBugs regularUserBugs = new RegularUserBugs(userRepo);
        while (true) {
            System.out.println("----------Main User Menu----------\n1.register\n2.login\n3.quit\nselect your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
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
                    System.out.println("invalid choice");
            }
        }
    }

    public void show2(RegularUserBugs regularUserBugs){
        System.out.print("firstName: ");
        String firstName = scanner.nextLine();
        System.out.println();
        System.out.print("lastName: ");
        String lastName = scanner.nextLine();
        System.out.println();
        System.out.print("email: ");
        String email = scanner.nextLine();
        System.out.println();
        System.out.print("phoneNumber: ");
        String phoneNumber = scanner.nextLine();
        System.out.println();
        System.out.print("password: ");
        String password = scanner.nextLine();
        System.out.println();
        RegularUser newUser = new RegularUser(firstName, lastName, email, phoneNumber, password);
        if (regularUserBugs.registerRegularUser(newUser)) {
            System.out.println("registering is successfully.");
        }
    }

    public void show3(RegularUserBugs regularUserBugs){
        System.out.print("Enter your email or phoneNmaber: ");
        String input = scanner.nextLine();
        System.out.println("Enter your password: ");
        String pass = scanner.nextLine();
        RegularUser user = regularUserBugs.login(input, pass);
        if (user != null) {
            System.out.println("login is successfully.welcome " + user.getFirstName());
            MainRegularUserMenu.getMrum().show(user);
        } else {
            System.out.println("invalid failed!!!");
        }
    }
}
