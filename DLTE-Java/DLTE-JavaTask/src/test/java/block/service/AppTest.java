package block.service;

import block.service.task641.Loan;
import block.service.task641.TestClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
public class AppTest
{
    static ArrayList<Loan> loans=new ArrayList<>();

    @Test
    public void testAddLoan() throws IOException, ClassNotFoundException {
        TestClass mainClass=new TestClass();

        Loan loan=new Loan(51484848L,8596.00,"11/02/2024","open","Shreya S Poojary",778965212L);
        mainClass.addLoan(loan);
        assertNotEquals("Shreya S Poojary",mainClass.loanInfo.get(0).getBorrowerName());//fails not equal
    }
    @Test
    public void testAvailability() throws IOException, ClassNotFoundException {
        TestClass mainClass=new TestClass();
        Loan loan=new Loan(12417777L,20848.00,"12/05/2024","open","Kumar",9875525554L);
        mainClass.addLoan(loan);
        mainClass.checkAvailableLoan();
        assertEquals("open",mainClass.loanInfo.get(0).getLoanStatus());//pass
    }

    @Test
    public void testClosedLoan() throws IOException, ClassNotFoundException {
        TestClass mainClass=new TestClass();
        Loan loan=new Loan(78484848L,20848.00,"7/04/2024","open","sinchana",9885245241L);
        Loan loan1=new Loan(75884848L,17848.00,"05/05/2024","close","Gourav",9963545554L);
        mainClass.addLoan(loan);
        mainClass.addLoan(loan1);
        mainClass.checkAvailableLoan();
        mainClass.getCheckClosedLoan();
        assertNotEquals("close",mainClass.loanInfo.get(0).getLoanStatus());//pass
        assertEquals("close",mainClass.loanInfo.get(1).getLoanStatus());//pass
    }
}
