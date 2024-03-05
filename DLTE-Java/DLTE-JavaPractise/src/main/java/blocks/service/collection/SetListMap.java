package blocks.service.collection;
import java.util.*;

public class SetListMap {
    public static void main(String[] args){
        //list<<arraylist
        ArrayList<Integer> arrayList=new ArrayList<>();
        //adding elements
        arrayList.add(1);
        arrayList.add(7);
        arrayList.add(2);
        arrayList.add(1);
        System.out.println("Elements at list are :"+arrayList);
        System.out.println("It contains 1 :"+arrayList.contains(1));
        System.out.println("size:"+arrayList.size());

        //set <<hashset
        HashSet<Integer> hashSet=new HashSet<>(arrayList);
        LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();
        linkedHashSet.addAll(arrayList);//linkedHashset
        //it doesn't take duplicate,ignores
        System.out.println("Values at linkedListSet are :"+linkedHashSet);
        System.out.println("Values at Hashset are:" +hashSet);
        hashSet.add(420);
        hashSet.add(7);  //ignores
        System.out.println("values at set are:" +hashSet);


        //Map<key,value>
        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("Anusha",89);
        hashMap.put("Sweedal",21);
        System.out.println("Elements in map are :"+hashMap);
        System.out.println("Employee Id of Anusha :"+hashMap.get("Anusha"));
        System.out.println("Values :"+hashMap.values());
        System.out.println("Key :"+hashMap.keySet());
        hashMap.remove("Sweedal");
        System.out.println("map after removing:"+hashMap);

    }
}

