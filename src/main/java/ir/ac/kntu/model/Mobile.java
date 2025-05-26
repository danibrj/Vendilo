package ir.ac.kntu.model;

public class Mobile extends DigitalProducts {
    private String cameraInformation;
    private String internetNetwork;

    public Mobile(String name, long price, int instInventory, String brand, int itlMemorySize, int ramSize, String cameraInformation, String internetNetwork) {
        super(name, price, instInventory, brand, itlMemorySize, ramSize);
        this.cameraInformation = cameraInformation;
        this.internetNetwork = internetNetwork;
    }

    @Override
    public String getType(){
        return "mobile";
    }

    @Override
    public String toString() {
        return "MOBILE==>>" + super.toString() + ", cameraInformation: " + cameraInformation + ", internetNetwork: " + internetNetwork;
    }
}
