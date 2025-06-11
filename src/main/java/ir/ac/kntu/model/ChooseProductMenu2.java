package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ChooseProductMenu2 {

    private static final ChooseProductMenu2 CPM2 = new ChooseProductMenu2();
    private Scanner scanner = new Scanner(System.in);

    public static ChooseProductMenu2 getCpm2() {
        return CPM2;
    }

    public void show(Products prod) {
        boolean isOk = true;
        while (isOk) {
            System.out.println(red + "1" + green + ".increase inventory\n" + red + "2" + green + ".decrease inventory\n" + red + "3" + green + ".quit" + reset);
            System.out.println(cyan+"choose one:"+reset);
            int sel = scanner.nextInt();
            scanner.nextLine();
            switch (sel) {
                case 1:
                    aboutIncrease(prod);
                    break;
                case 2:
                    System.out.println("how much do you want to decrease: ");
                    int amount2 = scanner.nextInt();
                    ProductsManager.getInstance().decreaseInventory(prod, amount2);
                    break;
                case 3:
                    isOk = false;
                    break;
                default:
                    System.out.println(red+"invalid selected!!!"+reset);
            }
        }
    }

    private void aboutIncrease(Products prod) {
        System.out.println("how much do you want to increase: ");
        int amount1 = scanner.nextInt();
        ProductsManager.getInstance().increaseInventory(prod, amount1);
        for(Map.Entry<RegularUser, Boolean> toReq : prod.getLetMeKnow().entrySet()){
            LocalDateTime lmkNotif = LocalDateTime.now();
            Subject subject = Subject.INCREASEPRODUCTINVENTORY;
            NotifValueManage.getNotValManInstance().addprodNotif(toReq.getKey(), prod);
            Notification notification = new Notification(lmkNotif,toReq.getKey(),subject, prod);
            NotificationManager.getNotManInstance().addNotif(notification);
        }
    }
}
