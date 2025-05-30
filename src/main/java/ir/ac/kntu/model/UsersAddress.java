package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;
import static ir.ac.kntu.model.Color.*;

public class UsersAddress {

    private List<Address> addresses = new ArrayList<>();

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddresses(Address address) {
        addresses.add(address);
        System.out.println(green+"add address successfully"+reset);
    }

    public void editAddress(int index,Address newAddress) {
        if(index>=0 & index < addresses.size()) {
            addresses.set(index, newAddress);
            System.out.println(green+"Address updated"+reset);
        }else{
            System.out.println(red+"invalid index"+reset);
        }
    }

    public void removeAddress(int index) {
        if(index>=0 & index < addresses.size()) {
            addresses.remove(index);
            System.out.println(green+"address removed"+reset);
        }else{
            System.out.println(red+"invalid index"+reset);
        }
    }

    public void showAddresses() {
        if(addresses.isEmpty()){
            System.out.println(red+"no addresses added!!!"+reset);
        }else{
            for(int i=0;i<addresses.size();i++){
                System.out.println((i+1) + " " + addresses.get(i));
            }
        }
    }
}
