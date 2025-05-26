package ir.ac.kntu.model;

public class Laptop extends  DigitalProducts{
    private String gpuModel;
    private String isConnToBul;
    private String hasWebcam;

    public Laptop(String name, long price, int instInventory, String brand, int itlMemorySize, int ramSize, String gpuModel, String isConnToBul, String hasWebcam) {
        super(name, price, instInventory, brand, itlMemorySize, ramSize);
        this.gpuModel = gpuModel;
        this.isConnToBul = isConnToBul;
        this.hasWebcam = hasWebcam;
    }

    @Override
    public String getType(){
        return "laptop";
    }

    @Override
    public String toString(){
        return "LAPTOP==>>" + super.toString() + ", GPUModel: "+ gpuModel + ", isConnectingToBul: "+ isConnToBul + ", haveWebcam: "+ hasWebcam;
    }
}
