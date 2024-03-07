package blocks.service;

import java.io.NotSerializableException;
import java.io.Serializable;

public class Employee implements Serializable {
    private Long employeeID;
    private String employeeName;
    private String employeeEmail;
    private Long employeeMobile;
    //    private String employeeTemporaryAddress;
//    private String employeePermanentAddress;
    private EmployeeAddress employeeTemporaryAddress;
    private EmployeeAddress employeePermanentAddress;

    public Employee() {
    }


    public Employee(Long employeeID, String employeeName, String employeeEmail, Long employeeMobile, EmployeeAddress employeeTemporaryAddress, EmployeeAddress employeePermanentAddress) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeMobile = employeeMobile;
        this.employeeTemporaryAddress = employeeTemporaryAddress;
        this.employeePermanentAddress = employeePermanentAddress;
    }



    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Long getEmployeeMobile() {
        return employeeMobile;
    }

    public void setEmployeeMobile(Long employeeMobile) {
        this.employeeMobile = employeeMobile;
    }


    public EmployeeAddress getEmployeeTemporaryAddress() {
        return employeeTemporaryAddress;
    }

    public void setEmployeeTemporaryAddress(EmployeeAddress employeeTemporaryAddress) {
        this.employeeTemporaryAddress = employeeTemporaryAddress;
    }

    public EmployeeAddress getEmployeePermanentAddress() {
        return employeePermanentAddress;
    }

    public void setEmployeePermanentAddress(EmployeeAddress employeePermanentAddress) {
        this.employeePermanentAddress = employeePermanentAddress;
    }

}
