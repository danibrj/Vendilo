package ir.ac.kntu.model;

import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;

public class ShowReportsMenu2 {

    private static final ShowReportsMenu2 SRM2Instance = new ShowReportsMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ShowReportsMenu2 getSRM2Instance() {
        return SRM2Instance;
    }

    public void show(RegularUser user) {
        KindOfReport[] values = KindOfReport.values();
        int index = 0;
        for (KindOfReport value : values) {
            if (!value.equals(KindOfReport.AUTHENTICATION)) {
                System.out.println((index + 1) + " " + value);
                index++;
            }
        }
        System.out.println(cyan + "choose your report title: " + reset);
        int choose = scanner.nextInt();
        scanner.nextLine();
        if (choose >= 1 && choose <= values.length) {
            KindOfReport selected = values[choose - 1];
            user.getUserSuportWorking().addReport(selected, user);
        } else {
            System.out.println(red + "invalid choose!!!" + reset);
        }

    }
}
