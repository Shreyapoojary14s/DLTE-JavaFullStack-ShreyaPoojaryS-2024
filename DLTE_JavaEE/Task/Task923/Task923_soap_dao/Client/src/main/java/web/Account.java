
package web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "account", propOrder = {
    "email",
    "password",
    "phoneNumber",
    "userName"
})
public class Account {

    protected String email;
    protected String password;
    protected Long phoneNumber;
    protected String userName;


    public String getEmail() {
        return email;
    }
    public void setEmail(String value) {
        this.email = value;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String value) {
        this.password = value;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long value) {
        this.phoneNumber = value;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String value) {
        this.userName = value;
    }

}
