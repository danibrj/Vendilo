package ir.ac.kntu.model;

import java.util.Scanner;

public class ShowAddresses {
    private static final ShowAddresses showAdd = new ShowAddresses();
    private Scanner scanner = new Scanner(System.in);

    public static ShowAddresses getShowAdd(){
        return showAdd;
    }

    public void show(RegularUser user){
        UsersAddress usersAddress = user.getUsersAddress();
        boolean isOkk2 = true;
        while (isOkk2) {
            System.out.println("----------ADDRESSES----------\n1-->|---------SHOW ADDRESS---------|<--\n2-->|---------EDIT ADDRESS---------|<--\n3-->|---------DELETE ADDRESS-------|<--\n4-->|---------ADD ADDRESS----------|<--\n5.quit\nselect your move: ");
            int move = scanner.nextInt();
            scanner.nextLine();
            switch (move) {
                case 1 -> usersAddress.showAddresses();
                case 2 -> new EditAddressInfo(usersAddress).show();
                case 3 -> new ShowRemoveAddressInfo(usersAddress).show();
                case 4 -> show2(usersAddress);
                case 5 -> {
                    isOkk2 = false;
                }
                default -> System.out.println("invalid move!!!");
            }
        }
    }

    public void show2(UsersAddress usersAddress){
        System.out.println("Enter  title:");
        String title = scanner.nextLine();
        System.out.println("Enter  province:");
        String province;
        while(true) {
            province = scanner.nextLine().trim();
            boolean bool = false;
            for (Province prov : Province.values()) {
                if (prov.name().equalsIgnoreCase(province)){
                    bool = true;
                    break;
                }
            }
            if(bool){
                break;
            }else{
                System.out.println("Invalid province. Please try again.\ncorrect province: ");
            }
        }
        System.out.println("Enter  city:");
        String city = scanner.nextLine();
        System.out.println("Enter  information:");
        String info = scanner.nextLine();
        Address adress = new Address(title,province,city,info);
        usersAddress.addAddresses(adress);
    }
}
