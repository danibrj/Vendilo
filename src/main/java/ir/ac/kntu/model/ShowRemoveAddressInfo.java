package ir.ac.kntu.model;

import java.util.Scanner;
import static ir.ac.kntu.model.Color.*;

public class ShowRemoveAddressInfo {
    private UsersAddress usersAddress;
    private Scanner scanner =new Scanner(System.in);

    public ShowRemoveAddressInfo(UsersAddress usersAddress){
        this.usersAddress = usersAddress;
    }
    public void show(){
        usersAddress.showAddresses();
        System.out.println(cyan+"which address do you want to remove: "+reset);
        int num2 = scanner.nextInt();
        scanner.nextLine();
        if(num2 >=1 && num2 <= usersAddress.getAddresses().size()){
            usersAddress.removeAddress(num2 -1);
        }else{
            System.out.println(red+"invalid address number!!!"+reset);
        }
    }
}
