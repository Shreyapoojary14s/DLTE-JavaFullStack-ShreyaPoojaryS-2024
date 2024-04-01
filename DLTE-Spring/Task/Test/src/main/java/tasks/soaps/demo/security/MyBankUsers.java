package tasks.soaps.demo.security;

import org.springframework.security.core.*

public class MyBankUsers {
    private String name;
    private String username;
    private String password;
    private String email;
    private long contact;
    private  long aadhaar;
    private String role;

    @Override
    public String toString() {
        return "MyBankUsers{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
                ", aadhaar=" + aadhaar +
                ", role='" + role + '\'' +
                '}';
    }

    public MyBankUsers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public long getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(long aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
