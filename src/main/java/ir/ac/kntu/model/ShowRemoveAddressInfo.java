package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowRemoveAddressInfo {
    private UsersAddress usersAddress;
    private Scanner scanner =new Scanner(System.in);

    public ShowRemoveAddressInfo(UsersAddress usersAddress){
        this.usersAddress = usersAddress;
    }
    public void show(){
        usersAddress.showAddresses();
        System.out.println("which address do you want to remove: ");
        int num2 = scanner.nextInt();
        scanner.nextLine();
        if(num2 >=1 && num2 <= usersAddress.getAddresses().size()){
            usersAddress.removeAddress(num2 -1);
        }else{
            System.out.println("invalid address number!!!");
        }
    }
}
