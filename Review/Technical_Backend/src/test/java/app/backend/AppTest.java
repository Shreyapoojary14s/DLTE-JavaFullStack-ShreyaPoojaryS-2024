package app.backend;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import app.backend.entity.EmployeeDetails;
import app.backend.entity.EmployeePermanentAddress;
import app.backend.entity.EmployeeTemporaryAddress;
import app.backend.remotes.EmployeeRepository;
import app.backend.services.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


public class AppTest 
{
    @Mock
    private EmployeeRepository mockRepository;

    @InjectMocks
    private EmployeeService employeeService;
//EXECUTES BEFORE EACH TEST
    @Before
    public void setUp() {

        MockitoAnnotations.openMocks(this);
    }
//insert employee
    @Test
    public void testEmployeeDetails() {

        EmployeeDetails details = new EmployeeDetails();
        details.setEmployeeID(12345);
        details.setEmployeeFirstName("Shreya");
        details.setEmployeeMiddleName("S");
        details.setEmployeeLastName("Poojary");
        details.setEmail("siri.poojary@gmail.com");
        details.setPhoneNumber(155557890L);

        when(mockRepository.insertEmployeeDetails(details)).thenReturn(details);

        EmployeeDetails result = employeeService.callInsertEmployeeDetails(details);

        assertNotNull(result);
    }


//insert temp
    @Test
    public void testEmployeeTemporaryAddress() {
        EmployeeTemporaryAddress temporaryAddress = new EmployeeTemporaryAddress();
        temporaryAddress.setEmployeeID(7445);
        temporaryAddress.setTemporaryHouseName("3/35C shreya");
        temporaryAddress.setTemporaryStreetName("Aloor");
        temporaryAddress.setTemporaryCity("Kunadapur");
        temporaryAddress.setTemporaryState("Karnataka");
        temporaryAddress.setPincodeTemporary(585451);
        when(mockRepository.insertEmployeeTemporaryAddress(temporaryAddress)).thenReturn(temporaryAddress);
        EmployeeTemporaryAddress result = employeeService.callInsertEmployeeTemporaryAddress(temporaryAddress);
        assertNotNull(result);

    }
//filtering
    @Test
    public void testEmployeeProfilesByPincode() {
        int pincode = 86985;

        when(mockRepository.filterEmployeeProfilesByPincode(pincode)).thenReturn(new ArrayList<>());

        List<EmployeeDetails> result = employeeService.callFilterEmployeeProfilesByPincode(pincode);

        assertNotNull(result);
        assertEquals(0, result.size());

    }
    //INSERT
    @Test
    public void testEmployeePermanentAddress() {
        // Set up permanent address...
        EmployeePermanentAddress permanentAddress = new EmployeePermanentAddress();
        permanentAddress.setEmployeeID(12345);
        permanentAddress.setPermanentHouseName("3/35C kumar");
        permanentAddress.setPermanentStreetName("raniju");
        permanentAddress.setPermanentCity("Hunsemakki");
        permanentAddress.setPermanentState("Karnataka");
        permanentAddress.setPincodePermanent(969656);
        when(mockRepository.insertEmployeePermanentAddress(permanentAddress)).thenReturn(permanentAddress);
        EmployeePermanentAddress result = employeeService.callInsertEmployeePermanentAddress(permanentAddress);
        assertNotNull(result);
    }

    @Test
    public void testEmployeeProfile() {
        when(mockRepository.outputEmployeeProfile()).thenReturn(new ArrayList<>());
        List<EmployeeDetails> result = employeeService.callOutputEmployeeProfile();
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
