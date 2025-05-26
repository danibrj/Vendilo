package ir.ac.kntu.model;

import java.util.Scanner;

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
            System.out.println("which item do you want to edit: \n1.address title\n2.address province\n3.address city\n4.address additional information\n5.finish editing\nselect: ");
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
                default -> System.out.println("invalid select!!!");
            }
        }
        Address updatedAddress = new Address(newTitle, newProvince, newCity, newInfo);
        usersAddress.editAddress(index, updatedAddress);
        System.out.println("Address updated successfully.");
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
