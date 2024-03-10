package block.service.task469;

import java.util.ArrayList;
import java.util.Arrays;

public class MyBankDatabase<T> implements  GenericsActivity<T> {
    public ArrayList<Object> dataList;
    T[] myObjects;
    @Override
    public String insertNewRecord(Object objects) {
        for(int index=0;index< myObjects.length;index++){
            if(myObjects[index]==null){
                myObjects[index]= (T) objects;
                return objects+" has inserted ";
            }
        }
        return objects+" has not inserted";
    }

    @Override
    public void viewAll() {
        System.out.println(Arrays.toString(myObjects));
    }

    @Override
    public T read(int index) {
        if(index>=0&&index< myObjects.length)
            return myObjects[index];
        return null;
    }

    @Override
    public String delete(int index) {
        if(index>=0&&index< myObjects.length&&myObjects[index]!=null){
            T object=myObjects[index];
            myObjects[index]=null;
            return object+" has deleted";
        }
        return null;
    }

//    @Override
//    public void update(int index, Object object) {
//    T object=myObjects[index];
//            myObjects[index]=null;
//    }

    @Override
    public void update(int index, T object) {
        if(index>=0&&index< myObjects.length){
            myObjects[index]=object;
            System.out.println(object+" has updated at "+index);
        }
        else
            System.out.println(object+" hasn't updated at "+index);
    }

    //public boolean create(T creditCard1) {
    //}

    public void writeIntoFile() {
    }

  //  public  readFromFile() {
  //  }
}
