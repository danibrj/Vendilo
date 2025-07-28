package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.Scanner;

import static ir.ac.kntu.model.Color.*;


public class VendiloPlusMenu {
    private static final VendiloPlusMenu vpmInstance = new VendiloPlusMenu();
    private Scanner scanner = new Scanner(System.in);

    public static VendiloPlusMenu getVpmInstance() {
        return vpmInstance;
    }

    public void show(RegularUser user) {
        boolean isContinue = true;
        while (isContinue) {
            System.out.println(cyan + "|----------vendiloPlus Menu----------|\n" + red + "1." + green + "vendilo membership\n" + red + "2." + green + "show status\n" + red + "3." + green + "quit\n" + "choose one: \n" + reset);
            int select = scanner.nextInt();
            scanner.nextLine();
            switch(select){
                case 1 -> part1(user);
                case 2 ->{
                    System.out.println(blue+"status: "+reset);
                    VendiloPlusManager.getVpmInstance().showStatus(user);
                }
                case 3 -> isContinue=false;
                default -> System.out.println(red+ "invalid select!!!"+reset);
            }
        }
    }

    public void part1(RegularUser user){
        boolean isContinue2 = true;
        while (isContinue2) {
            System.out.println(blue + "|----------welcome to membership part----------|" + reset);
            System.out.println(cyan + "choose your Duration: \n" + red + "1." + green + "Monthly\n" + red + "2." + green + "3 Months\n" + red + "3." + green + "1 Year\n" + red + "4." + green + "quit\n" + "choose one: \n" + reset);
            int select2 = scanner.nextInt();
            scanner.nextLine();
            switch (select2) {
                case 1 -> {
                    LocalDateTime today1 = LocalDateTime.now();
                    LocalDateTime oneMonthLater = today1.plusMonths(1);
                    VendiloPlus newVendiloPlus1 = new VendiloPlus(user,today1,oneMonthLater);
                    VendiloPlusManager.getVpmInstance().addToVendiloPlus(newVendiloPlus1);
                }
                case 2 -> {
                    LocalDateTime today2 = LocalDateTime.now();
                    LocalDateTime threeMonthLater = today2.plusMonths(3);
                    VendiloPlus newVendiloPlus2 = new VendiloPlus(user,today2,threeMonthLater);
                    VendiloPlusManager.getVpmInstance().addToVendiloPlus(newVendiloPlus2);
                }
                case 3 -> {
                    LocalDateTime today3 = LocalDateTime.now();
                    LocalDateTime oneYearLater = today3.plusYears(1);
                    VendiloPlus newVendiloPlus3 = new VendiloPlus(user,today3,oneYearLater);
                    VendiloPlusManager.getVpmInstance().addToVendiloPlus(newVendiloPlus3);
                }
                case 4 -> isContinue2=false;

                default -> System.out.println(red + "invalid select!!!" + reset);
            }
        }
    }
}
