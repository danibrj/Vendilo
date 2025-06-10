package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class NotificationMenu {
    private static final NotificationMenu notifInstance = new NotificationMenu();
    private Scanner scanner = new Scanner(System.in);

    public static NotificationMenu getNotifInstance() {
        return notifInstance;
    }

    public void show(RegularUser user) {
        boolean isOk = true;
        while (isOk) {
            System.out.println(cyan + "|----------Notification Menu----------|\n" + red + "1." + green + "show all notifications\n" + red + "2." + green + "show notification's details\n" + red + "3." + green + "quit\n" + "choose one: \n" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> {
                    System.out.println(blue + "all notifications: " + reset);
                    NotificationManager.getNotManInstance().showNotif(user);
                }
                case 2 -> {
                    List<Notification> userNotifications = NotificationManager.getNotManInstance().getUserNotif();
                    List<Notification> target = new ArrayList<>();
                    int index = 0;
                    for (Notification notif : userNotifications) {
                        if (notif.getUser().equals(user)) {
                            target.add(notif);
                            System.out.println((index + 1) + " " + notif);
                            index++;
                        }
                    }
                    System.out.println(cyan + "choose one to see its details: " + reset);
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    if (num < 1 || num > target.size()) {
                        System.out.println(red + "invalid num!!!" + reset);
                        return;
                    }
                    if (target.get(num - 1).getSubject().equals(Subject.INCREASEPRODUCTINVENTORY)) {
                        System.out.println(target.get(num - 1).getProd());
                    } else if (target.get(num - 1).getSubject().equals(Subject.DISCOUNTCODE)) {
                        System.out.println(target.get(num - 1).getCodes());
                    } else if (target.get(num - 1).getSubject().equals(Subject.PUBLICMESSAGE)) {
                        System.out.println(target.get(num - 1).getMessageValue());
                    } else if (target.get(num - 1).getSubject().equals(Subject.SUPPHANDELING)) {
                        System.out.println(target.get(num - 1).getReqq());
                    }
                }
                case 3 -> isOk = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }
}
