package ir.ac.kntu.model;

import java.util.*;

import static ir.ac.kntu.model.Color.*;

public class DiscountCodeManager {
    private static final DiscountCodeManager disManInstance = new DiscountCodeManager();
    private Scanner scanner = new Scanner(System.in);
    private Map<RegularUser, List<DiscountCode>> userDisCode = new HashMap<>();

    public static DiscountCodeManager getDisManInstance() {
        return disManInstance;
    }

    public Map<RegularUser, List<DiscountCode>> getUserDisCode() {
        return userDisCode;
    }

    public void addCode(RegularUser user, DiscountCode code) {
        userDisCode.putIfAbsent(user, new ArrayList<>());
        userDisCode.get(user).add(code);
    }

    public void showCodesGenerally(RegularUser user) {
        List<DiscountCode> codes = userDisCode.getOrDefault(user, new ArrayList<>());
        for (DiscountCode code : codes) {
            System.out.println("name: " + code.getName() + " | type: " + code.getKindsOfCode());
        }
    }

    public void showCodesDetails(DiscountCode code) {
        if (code == null) {
            System.out.println(red + "not found code!!!" + reset);
        }
        System.out.println(code);
    }

}
