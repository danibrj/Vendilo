package ir.ac.kntu.projTest;


import ir.ac.kntu.model.*;
import ir.ac.kntu.report.SellerReportGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectTests {

    //1.user charge wallet
    @Test
    public void testChargeIncreasesInventory() {
        UsersWallet wallet = new UsersWallet();
        wallet.charge(1000);
        assertEquals(1000, wallet.getInventory(), "inventory should increase after charging");
    }

    //2.user decrease wallet
    @Test
    public void testDecreaseInventory() {
        UsersWallet wallet = new UsersWallet();
        wallet.charge(10000);
        wallet.decreaseInventory(5000);
        assertEquals(5000, wallet.getInventory());
    }

    //3.add seller
    @Test
    public void testAddSellerToRepository() {
        SellerRepository repo = SellerRepository.getSinstance();
        int beforeSize = repo.getAllSellers().size();

        Seller testSeller = new Seller("danial", "barjasteh", "dani85", "0250582449", "09115525949", "AmDb9014$", "tehran");
        SellerWallet wallet = new SellerWallet();
        wallet.setInventory(250.0);
        repo.addSeller(testSeller);

        int afterSize = repo.getAllSellers().size();
        assertEquals(beforeSize + 1, afterSize);
    }

    //4.increase seller wallet inventory
    @Test
    public void testSellerWalletIncrease() {
        SellerWallet wallet = new SellerWallet();
        wallet.setInventory(100.0);
        wallet.increaseInventory(40.0);
        assertEquals(140.0, wallet.getInventory(), "increase inventory successfully");
    }

    //5.decrease inventory from seller wallet
    @Test
    public void testSellerWalletDecrease() {
        SellerWallet Wallet = new SellerWallet();
        Wallet.increaseInventory(200.0);
        Wallet.getMoney(50.0);
        assertEquals(150.0, Wallet.getInventory(), "get money was successfully");
    }


    //6.create a seller and Accuracy of information
    @Test
    public void testSellerCreation() {
        Seller seller = new Seller("danial", "barjasteh", "dani85", "0250582449", "09115525949", "AmDb9014$", "tehran");
        seller.getSellerWallet().setInventory(250.0);
        assertEquals("danial", seller.getFirstName());
        assertEquals("barjasteh", seller.getLastName());
        assertEquals(250.0, seller.getSellerWallet().getInventory(), "inventory ok");
    }

    //7.increase  product inventory
    @Test
    public void testIncProductInventory() {
        Products prod = new Products("name", 12, 2);
        ProductsManager.getInstance().increaseInventory(prod, 3);
        assertEquals(5, prod.getInstanceInventory(), "increase to 5 was successfully");
    }

    //8.decrease product inventory
    @Test
    public void testDecProductInventory() {
        Products prod = new Products("name", 12, 5);
        ProductsManager.getInstance().decreaseInventory(prod, 3);
        assertEquals(2, prod.getInstanceInventory(), "decrease to 2 was successfully");
    }

    //on project3
    //9.
    @Test
    public void testPublicMessage() {
        Scanner scanner = new Scanner(System.in);
        RegularUser user = new RegularUser();
        String message = "this week we have great discount cod";
        LocalDateTime nowDate = LocalDateTime.now();
        Subject subject = Subject.PUBLICMESSAGE;
        NotifValueManage.getNotValManInstance().addPubMessNotif(nowDate, message);

        Notification notification = new Notification(user, nowDate, subject, NotifValueManage.getNotValManInstance().getNotifValue1(nowDate));
        NotificationManager.getNotManInstance().addNotif(notification);


        List<Notification> notifForTest = NotificationManager.getNotManInstance().getUserNotif();
        Notification targetNot = null;
        for (Notification targetNotif : notifForTest)
        {
            if(targetNotif.getUser().equals(user) && targetNotif.getSubject().equals(Subject.PUBLICMESSAGE)){
                targetNot = targetNotif;
            }
        }
        assert targetNot != null;
        assertEquals("this week we have great discount cod", targetNot.getMessageValue(),"test ok");
    }
}
