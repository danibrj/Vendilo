package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;
import static ir.ac.kntu.model.Color.*;


public class HeadManagerLogin {
    private List<HeadManager> headManagers;

    public HeadManagerLogin() {
        this.headManagers = new ArrayList<>();
        headManagers.add(new HeadManager("headMn", "headMn901$"));
    }

    public HeadManager login(String usernameHm, String passwordHm) {
        for (HeadManager hdMn : headManagers) {
            if (hdMn.getUsernameHm().equals(usernameHm) && hdMn.getPasswordHm().equals(passwordHm)) {
                return hdMn;
            }
        }
        return null;
    }

    public void addManager(HeadManager manager) {
        if(!headManagers.contains(manager)){
            headManagers.add(manager);
            System.out.println(green +"add manager successfully"+reset);
        }
        System.out.println(red+"already exist!!!"+reset);
    }
}
