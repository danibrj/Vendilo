package ir.ac.kntu.model;

public class Address {
    private String title;
    private String province;
    private String city;
    private String additionalInfo;

    public Address(String title, String province, String city, String additionalInfo) {
        this.title = title;
        this.province = province;
        this.city = city;
        this.additionalInfo = additionalInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return title + " - " + province + " - " + city + " - " + additionalInfo;
    }

}
