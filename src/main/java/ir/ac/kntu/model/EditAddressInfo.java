package ir.ac.kntu.model;

import java.util.Scanner;

public class EditAddressInfo {

    private UsersAddress usersAddress;
    private Scanner scanner = new Scanner(System.in);

    public EditAddressInfo(UsersAddress usersAddress) {
        this.usersAddress = usersAddress;
    }

    public void show() {
        usersAddress.showAddresses();
        System.out.println("which address do you want to edit: ");
        int num1 = scanner.nextInt();
        scanner.nextLine();

        if (num1 < 1 || num1 > usersAddress.getAddresses().size()) {
            System.out.println("invalid address number!!!");
            return;
        }
        Address selAddress = usersAddress.getAddresses().get(num1 - 1);
        System.out.println("this is your previous address: \n" + selAddress);

        ShowSecondEditAddressInfo showSecondEdit = new ShowSecondEditAddressInfo(usersAddress);
        showSecondEdit.show(num1 - 1, selAddress);

    }
}
