package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowSecondEditAddressInfo {

    private UsersAddress usersAddress;
    private Scanner scanner = new Scanner(System.in);

    public ShowSecondEditAddressInfo(UsersAddress usersAddress) {
        this.usersAddress = usersAddress;
    }

    public void show(int index, Address selAddress) {
        String newTitle = selAddress.getTitle();
        String newProvince = selAddress.getProvince();
        String newCity = selAddress.getCity();
        String newInfo = selAddress.getAdditionalInfo();
        boolean isCountinue = true;
        while (isCountinue) {
            System.out.println(cyan + "which item do you want to edit:\n" + red + "1" + green + ".address title\n" + red + "2" + green + ".address province\n" + red + "3" + green + ".address city\n" + red + "4" + green + ".address additional information\n" + red + "5" + green + ".finish editing\n" + cyan+ "select: " + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> newTitle = getTitle();
                case 2 -> newProvince = getProvince();
                case 3 -> newCity = getCity();
                case 4 -> newInfo = getInfo();
                case 5 -> {
                    isCountinue = false;
                }
                default -> System.out.println(red+"invalid select!!!"+reset);
            }
        }
        Address updatedAddress = new Address(newTitle, newProvince, newCity, newInfo);
        usersAddress.editAddress(index, updatedAddress);
        System.out.println(green+"Address updated successfully."+reset);
    }

    private String getProvince() {
        System.out.println("Enter new province:");
        String newProvince;
        newProvince = scanner.nextLine();
        return newProvince;
    }

    public String getTitle() {
        System.out.println("Enter new title:");
        String newwTitle;
        newwTitle = scanner.nextLine();
        return newwTitle;
    }

    public String getCity() {
        System.out.println("Enter new city:");
        String newwCity;
        newwCity = scanner.nextLine();
        return newwCity;
    }

    public String getInfo() {
        System.out.println("Enter new information:");
        String newwInfo;
        newwInfo = scanner.nextLine();
        return newwInfo;
    }
}
