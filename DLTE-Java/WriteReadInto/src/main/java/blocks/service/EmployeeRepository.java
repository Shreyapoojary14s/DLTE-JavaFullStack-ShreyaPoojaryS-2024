package blocks.service;


//1st
import java.io.*;
import java.util.ArrayList;


public class EmployeeRepository {
    public EmployeeRepository(){
    }
    public  void writeIntoFile(ArrayList<Employee> empl){
        try{
            FileOutputStream fileOutputStream= new FileOutputStream("EmployeeDetail.doc");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(empl);
            fileOutputStream.close();
            objectOutputStream.close();

        }
        catch (IOException e){
            System.out.println(e);
        }

    }
    public ArrayList<Employee>readFromFile() {
        try {
            ArrayList<Employee> array ;
            FileInputStream fileInputStream = new FileInputStream("EmployeeDetail.doc");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            array = (ArrayList<Employee>) objectInputStream.readObject(); //classNotFound exception
            objectInputStream.close();
            fileInputStream.close();
            System.out.println(array.size());
            return array;
        } catch (IOException | ClassNotFoundException  ioException) {
            System.out.println(ioException);
        }
        return null;
    }


}
