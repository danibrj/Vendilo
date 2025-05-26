package ir.ac.kntu.model;

public class DigitalProducts extends Products {
    private String brand;
    private int itlMemorySize;
    private int ramSize;

    public DigitalProducts(String name, long price, int instInventory, String brand, int itlMemorySize, int ramSize) {
        super(name, price, instInventory);
        this.brand = brand;
        this.itlMemorySize = itlMemorySize;
        this.ramSize = ramSize;
    }

    @Override
    public String toString() {
        return super.toString() + "brand: " + brand + ", internalMemorySize: " + itlMemorySize + ", RAMSize: " + ramSize;
    }
}
