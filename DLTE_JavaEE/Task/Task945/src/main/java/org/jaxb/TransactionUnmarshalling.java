package org.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

    public class TransactionUnmarshalling {
        public static void main(String[] args) throws JAXBException {
            // Create a new File object representing the XML file "scheme.xml".
            File file=new File("scheme.xml");
            Scanner scanner=new Scanner(System.in);
            // Create a JAXBContext object for the MyTransaction class.
            JAXBContext context= JAXBContext.newInstance(MyTransaction.class);
            // Create an Unmarshaller object from the JAXBContext.
            Unmarshaller unmarshaller= context.createUnmarshaller();
            // Unmarshal the XML file into a MyTransaction object.
            MyTransaction transactions = (MyTransaction) unmarshaller.unmarshal(file);
            System.out.println("Enter the username");
            String name=scanner.next();
            for (Transaction transaction:transactions.getTransactionList()){
                if(transaction.getTransactionTo().equals(name)){
                    System.out.println("Name: "+transaction.getTransactionTo()+" "+"       Amount: "+transaction.getAmount()+"      Date: "+transaction.getDateOfTransaction());

                }
            }
            //CLLOSE
            scanner.close();

        }

}
