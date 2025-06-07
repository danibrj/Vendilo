package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;


public class FirstRegularUserMenu {
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        RegularUserRepository userRepo = RegularUserRepository.getRinstance();
        RegularUserBugs regularUserBugs = new RegularUserBugs(userRepo);
        while (true) {
            System.out.println(cyan + "|----------First User Menu----------|\n"+ red + "1."+ green+ "register\n" + red + "2." +green +"login\n" + red +"3." + green +"quit\nselect your choice: " + reset);
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
                    System.out.println(red +"invalid choice"+ reset);
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
            System.out.println(green + "registering is successfully." + reset);
        }
    }

    public void show3(RegularUserBugs regularUserBugs){
        System.out.println(cyan + "|----------Login----------|\n"+reset);
        System.out.print("Enter your email or phoneNmaber: ");
        String input = scanner.nextLine();
        System.out.println();
        System.out.print("Enter your password: ");
        String pass = scanner.nextLine();
        System.out.println();
        RegularUser user = regularUserBugs.login(input, pass);
        if (user != null) {
            System.out.println(green + "login is successfully.welcome "+ reset + user.getFirstName());
            MainRegularUserMenu.getMrum().show(user);
        } else {
            System.out.println(red +"invalid failed!!!" + reset);
        }
    }
}
