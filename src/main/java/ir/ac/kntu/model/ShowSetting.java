package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowSetting {
    private static final ShowSetting showSet = new ShowSetting();
    private Scanner scanner = new Scanner(System.in);

    public static ShowSetting getShowSet(){
        return showSet;
    }

    public void show(){
        RegularUserRepository userRepo = new RegularUserRepository();
        RegularUserBugs regularUserBugs = new RegularUserBugs(userRepo);
        System.out.println(cyan+"|----------SETTING----------|"+reset);
        Setting setting = new Setting(userRepo,regularUserBugs);
        System.out.println(cyan+"|----------updating----------|"+reset);
        System.out.println(cyan+"Do you want to update information?"+reset);
        System.out.println(red+"1."+green+"Yes"+reset);
        System.out.println(red+"2."+green+"No"+reset);
        System.out.println(cyan+"select your answer: "+reset);
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
                System.out.println(red+"invalid answer!!!"+reset);
        }
    }
}
