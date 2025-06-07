package ir.ac.kntu.model;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;
import static ir.ac.kntu.model.Color.reset;

public class ShowCodeDetails {
    private static final ShowCodeDetails scdInstance = new ShowCodeDetails();
    private Scanner scanner = new Scanner(System.in);

    public static ShowCodeDetails getScdInstance() {
        return scdInstance;
    }

    public void showDetails(RegularUser user, DiscountCodeManager codeManager) {
        Map<RegularUser, List<DiscountCode>> copyUserDisCode = codeManager.getUserDisCode();
        for (RegularUser reUser : copyUserDisCode.keySet()) {
            if (reUser.equals(user)) {
                for (int i = 0; i < copyUserDisCode.get(user).size(); i++) {
                    System.out.println((i + 1) + " " + copyUserDisCode.get(user).get(i).getName());
                }
            }
        }
        System.out.println(blue + "choose one: " + reset);
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > copyUserDisCode.get(user).size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        DiscountCode disCode = copyUserDisCode.get(user).get(num - 1);
        codeManager.showCodesDetails(disCode);
    }
}
