package org.example.Details;

import java.util.List;

public interface InputEmployeeDetails {
    //interface
    void create(List<Employee> employee);
    Employee displayBasedOnEmployeeId(String employeeID);
    Employee displayBasedOnPinCode(int pinCode);
    List<Employee> read();
    void closeConnections();
}

