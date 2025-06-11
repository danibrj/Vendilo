package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

import static ir.ac.kntu.model.Color.*;

public class NotificationManager {
    private static final NotificationManager notManInstance = new NotificationManager();
    private List<Notification> userNotif = new ArrayList<>();

    public static NotificationManager getNotManInstance(){
        return notManInstance;
    }

    public List<Notification> getUserNotif() {
        return userNotif;
    }

    public void addNotif(Notification notif){
        userNotif.add(notif);
        System.out.println(green+"add Notification successfully"+reset);
    }

    public void showNotif(RegularUser user){
        int index =0;
        for(Notification notif : userNotif){
            if(notif.getUser().equals(user)){
                System.out.println((index + 1) + " " + notif);
                index++;
            }
        }
    }

//    public void showNotifGenerally(RegularUser user) {
//        List<Notification> notifs = userNotif.getOrDefault(user, new ArrayList<>());
//        for (Notification notif : notifs) {
//            System.out.println("name: " + notif.get+ " | type: " + notif.getKindsOfCode());
//        }
//    }
//
//    public void showNotifDetails(Notification notif) {
//        if (code == null) {
//            System.out.println(red + "not found code!!!" + reset);
//        }
//        System.out.println(code);
//    }
}
