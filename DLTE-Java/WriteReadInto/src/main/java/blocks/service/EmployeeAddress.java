package blocks.service;


//1st
import java.io.NotSerializableException;
import java.io.Serializable;

public class EmployeeAddress implements Serializable {
    private String homeAddress;
    private String area;
    private String city;
    private String state;
    private Long pincode;

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "homeAddress='" + homeAddress + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pincode=" + pincode +
                '}';
    }

    public EmployeeAddress() {
        this.homeAddress = homeAddress;
        this.area = area;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }
}
