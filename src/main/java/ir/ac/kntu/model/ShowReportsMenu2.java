package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowReportsMenu2 {

    private static final ShowReportsMenu2 SRM2Instance = new ShowReportsMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ShowReportsMenu2 getSRM2Instance() {
        return SRM2Instance;
    }

    public void show(RegularUser user) {
        KindOfReport[] values = KindOfReport.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + " " + values[i]);
        }
        System.out.println("choose your report title: ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        if (choose >= 1 && choose <= values.length) {
            KindOfReport selected = values[choose - 1];
            user.getUserSuportWorking().addReport(selected);
        } else {
            System.out.println("invalid choose!!!");
        }

    }
}
