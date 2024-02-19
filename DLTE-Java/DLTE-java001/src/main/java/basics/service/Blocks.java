package basics.service;
//scopes,overloading
public class Blocks {
    static{                 //runs before the public class
        System.out.println("Funds,Bonds");
    }
    public static void main(Integer[] args){
        System.out.println("multiple main");
    }

    public static void main(String args[]){
        System.out.println("CLI banking");

    }
   // Tradition.main(new Integer[]{11,12});
}
class Facility {
    public static void main(String args[]) {
        System.out.println("ATM, Passbook");

    }
}
class Device {
    public static void main(String args[]) {
        System.out.println("internet banking");

    }
}

