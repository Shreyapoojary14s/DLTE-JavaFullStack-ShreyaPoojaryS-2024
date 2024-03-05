package blocks.service.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

public class TreeSetPract {
    public static void main(String[]args){
        TreeSet<Integer> treeSet=new TreeSet<>();
       // TreeSet<Integer> treeSet=new TreeSet<>(Collections.reverseOrder()); //descending order
        //adding elements into tree set
        treeSet.add(4001 );
        treeSet.add(4002 );
        treeSet.add(4003 );
        treeSet.add(4004 );
        System.out.println(treeSet);
        treeSet.add(4006);
        treeSet.add(4005);
        treeSet.add(4003); //ignore duplicate
        System.out.println(treeSet);

    }
}
