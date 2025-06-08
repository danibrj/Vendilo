package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ir.ac.kntu.model.Color.*;

public class NotificationManager {
    private static final NotificationManager notManInstance = new NotificationManager();
    private Map<RegularUser, List<Notification>> userNotif = new HashMap<>();
    public static NotificationManager getNotManInstance(){
        return notManInstance;
    }

    public Map<RegularUser, List<Notification>> getUserNotif(){
        return  userNotif;
    }

    public void addNotif(RegularUser user,Notification notif){
        userNotif.putIfAbsent(user, new ArrayList<>());
        userNotif.get(user).add(notif);
        System.out.println(green+"discount code added successfully");
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
