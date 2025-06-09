package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static ir.ac.kntu.model.Color.*;
import static ir.ac.kntu.model.Color.reset;

public class SupportersLogin {
    private List<Supporter> supporters = supporters = new ArrayList<>();


    public Supporter login(String userName, String password) {
        for (Supporter sp : supporters) {
            if (sp.getUserName().equals(userName) && sp.getPassword().equals(password)) {
                return sp;
            }
        }
        return null;
    }



    public void addSupper(Supporter supporter){
        if(supporters.contains(supporter)){
            System.out.println(red+"supporter already exist!!!"+reset);
            return;
        }
        supporters.add(supporter);
        System.out.println(green +"add supporter successfully"+reset);
    }

    public List<Supporter> getSupporters() {
        return supporters;
    }
}
