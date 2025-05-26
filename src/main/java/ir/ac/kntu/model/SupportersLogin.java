package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class SupportersLogin {
    private List<Supporter> supporters;

    public SupportersLogin() {
        supporters = new ArrayList<>();

        supporters.add(new Supporter("Supporter1", "DanialBrj", "AmDb901"));
        supporters.add(new Supporter("Supporter2", "DanialAtm", "AmDb913"));

    }

    public Supporter login(String userName, String password) {
        for (Supporter sp : supporters) {
            if (sp.getUserName().equals(userName) && sp.getPassword().equals(password)) {
                return sp;
            }
        }
        return null;
    }
}
