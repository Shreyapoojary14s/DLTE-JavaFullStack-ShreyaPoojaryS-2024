package block.service.task637;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface MyBank {
        ArrayList<LoanEntity> loan=new ArrayList<>(25);
        void writeIntoFile() throws IOException;
        void readFromFile() throws IOException, ClassNotFoundException;
        void addNewLoan(LoanEntity loan);
        void checkAvailability();
        void checkClosedLoan();

}

