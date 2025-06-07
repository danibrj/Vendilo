package ir.ac.kntu.model;

public class DiscountCode {
    private String name;
    private String code;
    private int discountValue;
    private int numbsOfTimesOfUse;
    private KindsOfCode kindsOfCode;

    public DiscountCode(){

    }

    public DiscountCode(String name, String code, int discountValue, int numbsOfTimesOfUse, KindsOfCode kindsOfCode) {
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

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValue) {
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
        return "DiscountCode{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", discountValue=" + discountValue +
                ", numsOfTimesOfUse=" + numbsOfTimesOfUse +
                ", kindsOfCode=" + kindsOfCode +
                "}";
    }
}
