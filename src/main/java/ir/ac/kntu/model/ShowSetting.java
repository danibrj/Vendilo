package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowSetting {
    private static final ShowSetting showSet = new ShowSetting();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSetting getShowSet(){
        return showSet;
    }

    public void show(){
        RegularUserRepository userRepo = new RegularUserRepository();
        RegularUserBugs regularUserBugs = new RegularUserBugs(userRepo);
        System.out.println("----------SETTING----------");
        Setting setting = new Setting(userRepo,regularUserBugs);
        System.out.println("----------updating----------");
        System.out.println("Do you want to update information?");
        System.out.println("1.Yes");
        System.out.println("2.No");
        System.out.println("select your answer: ");
        String answer = scanner.nextLine();
        scanner.nextLine();

        switch (answer) {
            case "Yes":
                System.out.println("Enter your email or phoneNumber: ");
                String input = scanner.nextLine();
                setting.updateInformation(input, scanner);
                break;
            case "No":
                System.out.println("ok. you dont want to update information.");
                break;
            default:
                System.out.println("invalid answer!!!");
        }
    }
}
