package ir.ac.kntu.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VendiloPlusManager {
    private static final VendiloPlusManager vpmInstance = new VendiloPlusManager();
    private List<VendiloPlus> listOfVenPlus= new ArrayList<>();

    public static VendiloPlusManager getVpmInstance() {
        return vpmInstance;
    }


    public VendiloPlus findVendByUser(RegularUser user){
        for(VendiloPlus fVend : listOfVenPlus){
            if(fVend.getUser().equals(user)){
                return fVend;
            }
        }
        return null;
    }

    public void addToVendiloPlus(VendiloPlus vendiloPlus){
        if(!listOfVenPlus.contains(vendiloPlus)){
            listOfVenPlus.add(vendiloPlus);
            System.out.println("add successfully");
        }
    }

    public void showStatus(RegularUser user){
        for(VendiloPlus vend : listOfVenPlus){
            if(vend.getUser().equals(user)){
                System.out.println("user: " + user.getFirstName() + " "+user.getLastName() + " | end on: "+ vend.getExpirationDate());
                if(vend.getExpirationDate().isBefore(LocalDateTime.now())){
                    System.out.println("finished your deadline on : "+ vend.getExpirationDate());
                }
            }
        }
    }
}
