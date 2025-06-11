package ir.ac.kntu.model;

import java.util.*;

import static ir.ac.kntu.model.Color.*;

public class UserManagement {
    private static final UserManagement umInstance = new UserManagement();
    private Scanner scanner = new Scanner(System.in);

    public static UserManagement getUmInstance() {
        return umInstance;
    }

    public void show(HeadManagerLogin headManagerLogin, SupportersLogin supportersLogin, HeadManager headManager) {
        boolean isOk = true;
        while (isOk) {
            System.out.println(cyan + "|----------User management Menu----------|\n" + red + "1." + green + "List Of All Users\n" + red + "2." + green + "Create User\n" + red + "3." + green + "Edit User\n" + red + "4." + green + "Block\n" + red + "5." + green + "Unblock\n" + red + "6." + green + "quit\n" + blue + "choose one: \n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> listOfAllUsers(headManagerLogin, supportersLogin, headManager);
                case 2 -> CreateUserMenu.gethMlmInstanse().show(headManagerLogin, supportersLogin);
                case 3 -> editUsers(headManagerLogin, headManager, supportersLogin);
                case 4 -> blockUser(headManagerLogin, headManager, supportersLogin);
                case 5 -> unblockUser(headManagerLogin,headManager,supportersLogin);
                case 6 -> isOk = false;
                default -> System.out.println(red + "invalid choice!!!" + reset);
            }
        }
    }

    private void listOfAllUsers(HeadManagerLogin headManagerLogin, SupportersLogin supportersLogin, HeadManager headManager) {
        boolean iscontinue1 = true;
        while (iscontinue1) {
            System.out.println(cyan + "|----------List Of All Users----------|\n" + red + "1." + green + "managers\n" + red + "2." + green + "supporters\n" + red + "3." + green + "sellers\n" + red + "4." + green + "regular user\n" + red + "5." + green + "quit\n" + blue + "choose one: \n" + reset);
            int choice2 = scanner.nextInt();
            scanner.nextLine();
            switch (choice2) {
                case 1 -> showManagers(headManagerLogin, headManager);
                case 2 -> showSupporters(supportersLogin);
                case 3 -> showSellers();
                case 4 -> showRegularUsers();
                case 5 -> iscontinue1 = false;
                default -> System.out.println(red + "invalid choice2!!!" + reset);
            }
        }
    }

    public void showManagers(HeadManagerLogin headManagerLogin, HeadManager headManager) {
        System.out.println(cyan + "managers: " + reset);
        List<HeadManager> listOfManager = headManagerLogin.getHeadManagers();
        int index = 0;
        for (HeadManager manager : listOfManager) {
            if (manager.equals(headManager)) {
                continue;
            }
            System.out.println((index + 1) + " " + manager);
            index++;
        }
    }

    public void showSupporters(SupportersLogin supportersLogin) {
        System.out.println(cyan + "supporters: " + reset);
        List<Supporter> listOfSupporter = supportersLogin.getSupporters();
        for (int i = 0; i < listOfSupporter.size(); i++) {
            System.out.println((i + 1) + " " + listOfSupporter.get(i));
        }
    }

    public void showSellers() {
        System.out.println(cyan + "Sellers: " + reset);
        List<Seller> listOfSeller = SellerRepository.getSinstance().getAllSellers();
        for (int i = 0; i < listOfSeller.size(); i++) {
            System.out.println((i + 1) + " " + listOfSeller.get(i));
        }
    }

    public void showRegularUsers() {
        System.out.println(cyan + "Regular User: " + reset);
        List<RegularUser> listOfRegUser = RegularUserRepository.getRinstance().getAllUsers();
        for (int i = 0; i < listOfRegUser.size(); i++) {
            System.out.println((i + 1) + " " + listOfRegUser.get(i));
        }
    }

    public void editUsers(HeadManagerLogin headManagerLogin, HeadManager headManager, SupportersLogin supportersLogin) {
        boolean iscontinue2 = true;
        while (iscontinue2) {
            System.out.println(cyan + "which type of user do you want to edit?\n" + red + "1." + green + "managers\n" + red + "2." + green + "supporters\n" + red + "3." + green + "regular user\n" + red + "4." + green + "quit\n" + blue + "choose one: \n" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch (select) {
                case 1 -> {
                    System.out.println(cyan + "managers: " + reset);
                    List<HeadManager> listOfManager2 = headManagerLogin.getHeadManagers();
                    int index = 0;
                    showEditManager(headManager, listOfManager2, index);
                }
                case 2 -> showEditSupporter(supportersLogin);
                case 3 -> showEditRegularUser();
                case 4 -> iscontinue2 = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }

    public void showEditManager(HeadManager headManager, List<HeadManager> listOfManager2, int index) {
        for (HeadManager value : listOfManager2) {
            if (value.equals(headManager)) {
                continue;
            }
            System.out.println((index + 1) + " " + value);
            index++;
        }
        if (listOfManager2.isEmpty()) {
            System.out.println(red + "don't have any manager!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to edit?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfManager2.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        HeadManager manager = listOfManager2.get(num - 1);
        System.out.println("Enter new firstname: ");
        String newManagerName = scanner.nextLine();
        manager.setFirstNameHm(newManagerName);
        System.out.println("Enter new username: ");
        String newManagerUName = scanner.nextLine();
        manager.setUsernameHm(newManagerUName);
        System.out.println(green + "edit successfully." + blue + " new firstname: " + reset + manager.getFirstNameHm() + blue + " | new username: " + reset + manager.getUsernameHm());
    }

    public void showEditSupporter(SupportersLogin supportersLogin) {
        System.out.println(cyan + "supporters: " + reset);
        List<Supporter> listOfSupporter2 = supportersLogin.getSupporters();
        for (int i = 0; i < listOfSupporter2.size(); i++) {
            System.out.println((i + 1) + " " + listOfSupporter2.get(i));
        }
        if (listOfSupporter2.isEmpty()) {
            System.out.println(red + "don't have any supporter!!!" + reset);
            return;
        }
        System.out.println("which  supporter do you want to edit?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfSupporter2.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        Supporter supporter = listOfSupporter2.get(num - 1);
        System.out.println("Enter new name: ");
        String newSupporterName = scanner.nextLine();
        supporter.setFirstName(newSupporterName);
        System.out.println("Enter new username: ");
        String newSupporterUName = scanner.nextLine();
        supporter.setUserName(newSupporterUName);
        System.out.println("----------");
        reportHandle(supporter);
    }

    public void reportHandle(Supporter supporter){
        Set<KindOfReport> types = new HashSet<>();
        KindOfReport[] allType = KindOfReport.values();
        boolean isOkk = true;
        while (isOkk) {
            System.out.println(cyan + "which type of reports can't he handle?\n" + red + "1." + green + "select\n" + red + "2." + green + "quit\n" + reset);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    for (int i = 0; i < allType.length; i++) {
                        System.out.println((i + 1) + " " + allType[i]);
                    }
                    int num2 = scanner.nextInt();
                    scanner.nextLine();
                    if (num2 >= 1 && num2 <= allType.length) {
                        KindOfReport selected = allType[num2 - 1];
                        types.add(selected);
                    } else {
                        System.out.println(red + "invalid choose!!!" + reset);
                    }
                }
                case 2 -> isOkk = false;
                default -> System.out.println(red + "invalid choice!!!" + reset);
            }
        }
        UserSuportWorking.getWInstance().addTo(supporter, types);
        System.out.println(green + "edit successfully." + blue + " new name: " + reset + supporter.getFirstName() + blue + " | new username: " + reset + supporter.getUserName());

    }

    public void showEditRegularUser() {
        System.out.println(cyan + "Regular Users: " + reset);
        List<RegularUser> listOfRegUser2 = RegularUserRepository.getRinstance().getAllUsers();
        for (int i = 0; i < listOfRegUser2.size(); i++) {
            System.out.println((i + 1) + " " + listOfRegUser2.get(i));
        }
        if (listOfRegUser2.isEmpty()) {
            System.out.println(red + "don't have any user!!!" + reset);
            return;
        }
        System.out.println("which  user do you want to edit?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfRegUser2.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        RegularUser user = listOfRegUser2.get(num - 1);
        System.out.println("Enter new firstname: ");
        String newUserFName = scanner.nextLine();
        user.setFirstName(newUserFName);
        System.out.println("Enter new lastname: ");
        String newUserLName = scanner.nextLine();
        user.setLastName(newUserLName);
        System.out.println(green + "edit successfully." + blue + " new firstname: " + reset + user.getFirstName() + blue + " | new lastname: " + reset + user.getLastName());
    }

    public void blockUser(HeadManagerLogin headManagerLogin, HeadManager headManager, SupportersLogin supportersLogin) {
        boolean isOk2 = true;
        while (isOk2) {
            System.out.println(cyan + "which type of user do you want to block?\n" + red + "1." + green + "managers\n" + red + "2." + green + "supporters\n" + red + "3." + green + "regular user\n" + red + "4." + green + "quit\n" + blue + "choose one: \n" + reset);
            int select2 = scanner.nextInt();
            scanner.nextLine();
            switch (select2) {
                case 1 -> blockManager(headManagerLogin, headManager);
                case 2 -> blockSupporter(supportersLogin);
                case 3 -> blockRegularUser();
                case 4 -> isOk2 = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }

    public void blockManager(HeadManagerLogin headManagerLogin, HeadManager headManager) {
        System.out.println(cyan + "managers: " + reset);
        List<HeadManager> listOfManager3 = headManagerLogin.getHeadManagers();
        int index = 0;
        for (HeadManager manager : listOfManager3) {
            if (manager.equals(headManager)) {
                continue;
            }
            System.out.println((index + 1) + " " + manager);
            index++;
        }
        if (listOfManager3.isEmpty()) {
            System.out.println(red + "don't have any manager!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to block?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfManager3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfManager3.get(num - 1).setManagerIsBlock(IsBlock.YES);
        System.out.println("manager blocked");
    }

    public void blockSupporter(SupportersLogin supportersLogin) {
        System.out.println(cyan + "supporters: " + reset);
        List<Supporter> listOfSupporter3 = supportersLogin.getSupporters();
        for (int i = 0; i < listOfSupporter3.size(); i++) {
            System.out.println((i + 1) + " " + listOfSupporter3.get(i));
        }
        if (listOfSupporter3.isEmpty()) {
            System.out.println(red + "don't have any supporter!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to block?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfSupporter3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfSupporter3.get(num - 1).setSupIsBlock(IsBlock.YES);
        System.out.println("supporter blocked");
    }

    public void blockRegularUser() {
        System.out.println(cyan + "regular user: " + reset);
        List<RegularUser> listOfRegUser3 = RegularUserRepository.getRinstance().getAllUsers();
        for (int i = 0; i < listOfRegUser3.size(); i++) {
            System.out.println((i + 1) + " " + listOfRegUser3.get(i));
        }
        if (listOfRegUser3.isEmpty()) {
            System.out.println(red + "don't have any user!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to block?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfRegUser3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfRegUser3.get(num - 1).setUserIsBlock(IsBlock.YES);
        System.out.println("user blocked");
    }

    public void unblockUser(HeadManagerLogin headManagerLogin, HeadManager headManager, SupportersLogin supportersLogin) {
        boolean isOk2 = true;
        while (isOk2) {
            System.out.println(cyan + "which type of user do you want to unblock?\n" + red + "1." + green + "managers\n" + red + "2." + green + "supporters\n" + red + "3." + green + "regular user\n" + red + "4." + green + "quit\n" + blue + "choose one: \n" + reset);
            int select2 = scanner.nextInt();
            scanner.nextLine();
            switch (select2) {
                case 1 -> unblockManager(headManagerLogin, headManager);
                case 2 -> unblockSupporter(supportersLogin);
                case 3 -> unblockRegularUser();
                case 4 -> isOk2 = false;
                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }

    public void unblockManager(HeadManagerLogin headManagerLogin, HeadManager headManager) {
        System.out.println(cyan + "managers: " + reset);
        List<HeadManager> listOfManager3 = headManagerLogin.getHeadManagers();
        int index = 0;
        for (HeadManager manager : listOfManager3) {
            if (manager.equals(headManager)) {
                continue;
            }
            if (manager.getManagerIsBlock().equals(IsBlock.YES)) {
                System.out.println((index + 1) + " " + manager);
                index++;
            }
        }
        if (listOfManager3.isEmpty()) {
            System.out.println(red + "don't have any manager!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to unblock?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfManager3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfManager3.get(num - 1).setManagerIsBlock(IsBlock.NO);
        System.out.println("manager unblocked");
    }

    public void unblockSupporter(SupportersLogin supportersLogin) {
        System.out.println(cyan + "supporters: " + reset);
        List<Supporter> listOfSupporter3 = supportersLogin.getSupporters();
        for (int i = 0; i < listOfSupporter3.size(); i++) {
            if (listOfSupporter3.get(i).getSupIsBlock().equals(IsBlock.YES)) {
                System.out.println((i + 1) + " " + listOfSupporter3.get(i));
            }
        }
        if (listOfSupporter3.isEmpty()) {
            System.out.println(red + "don't have any supporter!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to unblock?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfSupporter3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfSupporter3.get(num - 1).setSupIsBlock(IsBlock.NO);
        System.out.println("supporter unblocked");
    }

    public void unblockRegularUser() {
        System.out.println(cyan + "regular user: " + reset);
        List<RegularUser> listOfRegUser3 = RegularUserRepository.getRinstance().getAllUsers();
        for (int i = 0; i < listOfRegUser3.size(); i++) {
            if (listOfRegUser3.get(i).getUserIsBlock().equals(IsBlock.YES)) {
                System.out.println((i + 1) + " " + listOfRegUser3.get(i));
            }
        }
        if (listOfRegUser3.isEmpty()) {
            System.out.println(red + "don't have any user!!!" + reset);
            return;
        }
        System.out.println("which  manager do you want to unblock?");
        int num = scanner.nextInt();
        scanner.nextLine();
        if (num < 1 || num > listOfRegUser3.size()) {
            System.out.println(red + "invalid num" + reset);
            return;
        }
        listOfRegUser3.get(num - 1).setUserIsBlock(IsBlock.NO);
        System.out.println("user unblocked");
    }
}
