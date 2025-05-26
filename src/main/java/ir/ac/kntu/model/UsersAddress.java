package ir.ac.kntu.model;

import java.util.ArrayList;
import java.util.List;

public class UsersAddress {

    private List<Address> addresses = new ArrayList<>();

    public void addAddresses(Address address) {
        addresses.add(address);
        System.out.println("add address successfully");
    }

    public void editAddress(int index,Address newAddress) {
        if(index>=0 & index < addresses.size()) {
            addresses.set(index, newAddress);
            System.out.println("Address updated");
        }else{
            System.out.println("invalid index");
        }
    }

    public void removeAddress(int index) {
        if(index>=0 & index < addresses.size()) {
            addresses.remove(index);
            System.out.println("address removed");
        }else{
            System.out.println("invalid index");
        }
    }

    public void showAddresses() {
        if(addresses.isEmpty()){
            System.out.println("no addresses added!!!");
        }else{
            for(int i=0;i<addresses.size();i++){
                System.out.println((i+1) + " " + addresses.get(i));
            }
        }
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
