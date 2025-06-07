package ir.ac.kntu.model;

public class DiscountCode {
    private String name;
    private String code;
    private float discountValue;
    private int numbsOfTimesOfUse;
    private KindsOfCode kindsOfCode;

    public DiscountCode() {

    }

    public DiscountCode(String name, String code, float discountValue, int numbsOfTimesOfUse, KindsOfCode kindsOfCode) {
        this.name = name;
        this.code = code;
        this.discountValue = discountValue;
        this.numbsOfTimesOfUse = numbsOfTimesOfUse;
        this.kindsOfCode = kindsOfCode;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
    }

    public int getNumsOfTimesOfUse() {
        return numbsOfTimesOfUse;
    }

    public void setNumsOfTimesOfUse(int numsOfTimesOfUse) {
        this.numbsOfTimesOfUse = numsOfTimesOfUse;
    }

    public KindsOfCode getKindsOfCode() {
        return kindsOfCode;
    }

    public void setKindsOfCode(KindsOfCode kindsOfCode) {
        this.kindsOfCode = kindsOfCode;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", code = " + code +
                ", discountValue = " + discountValue + " %"+
                ", numbsOfTimesOfUse = " + numbsOfTimesOfUse +
                ", kindsOfCode = " + kindsOfCode;
    }
}
