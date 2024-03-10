package block.service.files779;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class MyBankDatabase <T> implements Activity<T>{
    ArrayList<T> bankDataBase;
    @Override
    public String createNewData(T object) {
        bankDataBase.add(object);
        return "data added successfully!";
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyBankDatabase<CreditCard> storeCardData= new MyBankDatabase<>();
        storeCardData.bankDataBase=new ArrayList<>(25);
        //input
        CreditCard creditCardOne=new CreditCard(8111184155L,"Shreya",new Date(2024,12,22),917,214500,9624);
        CreditCard creditCardTwo=new CreditCard(89635542557L,"Asha",new Date(2024,14,17),569,56300,9696);
        CreditCard creditCardThree=new CreditCard(4481184155L,"Shreya S POojary",new Date(2024,12,22),917,214500,9624);
        CreditCard creditCardFour=new CreditCard(8955522227L,"AshaLatha",new Date(2024,14,17),69,5680,9696);
        storeCardData.createNewData(creditCardOne);
        storeCardData.createNewData(creditCardTwo);
        storeCardData.createNewData(creditCardThree);
        storeCardData.createNewData(creditCardFour);
        storeCardData.writeTofile();
        storeCardData.readFromfile();
    }
    //reading
    public void readFromfile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream=new FileInputStream("Mybankdb");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        bankDataBase= (ArrayList<T>) objectInputStream.readObject();
        int size=bankDataBase.size();
        for(int index=0;index<size;index++) {
            if (bankDataBase.get(index) != null) {
                System.out.println(bankDataBase.get(index).toString());
            }
        }
    }
//    FileInputStream fileInputStream=new FileInputStream("Mybankdb");
//    ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
//    bankDataBase= (ArrayList<T>) objectInputStream.readObject();
//    int size=bankDataBase.size();
//        for(int index=0;index<size;index++) {
//        if (bankDataBase.get(index) != null) {

    //writing into file
    public void writeTofile() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("Mybankdb");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bankDataBase);
        fileOutputStream.close();
        objectOutputStream.close();
    }

}