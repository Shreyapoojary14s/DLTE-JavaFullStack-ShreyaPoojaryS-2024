package org.example;

import org.example.Details.EmployeeAddress;
import org.example.Details.EmployeeBasicDetails;

public class EntityEmployee {
    EmployeeBasicDetails employeebasicDetails;
    EmployeeAddress employeePermanentAddress;
    EmployeeAddress employeeTemporaryAddress;

    @Override
    public String toString() {
        return "EntityEmployee{" +
                "employeebasicDetails=" + employeebasicDetails +
                ", employeePermanentAddress=" + employeePermanentAddress +
                ", employeeTemporaryAddress=" + employeeTemporaryAddress +
                '}';
    }

    public EmployeeBasicDetails getEmployeebasicDetails() {
        return employeebasicDetails;
    }

    public void setEmployeebasicDetails(EmployeeBasicDetails employeebasicDetails) {
        this.employeebasicDetails = employeebasicDetails;
    }

    public EmployeeAddress getEmployeePermanentAddress() {
        return employeePermanentAddress;
    }

    public void setEmployeePermanentAddress(EmployeeAddress employeePermanentAddress) {
        this.employeePermanentAddress = employeePermanentAddress;
    }

    public EmployeeAddress getEmployeeTemporaryAddress() {
        return employeeTemporaryAddress;
    }

    public void setEmployeeTemporaryAddress(EmployeeAddress employeeTemporaryAddress) {
        this.employeeTemporaryAddress = employeeTemporaryAddress;
    }

    public EntityEmployee(EmployeeBasicDetails employeebasicDetails, EmployeeAddress employeePermanentAddress, EmployeeAddress employeeTemporaryAddress) {
        this.employeebasicDetails = employeebasicDetails;
        this.employeePermanentAddress = employeePermanentAddress;
        this.employeeTemporaryAddress = employeeTemporaryAddress;
    }
}
