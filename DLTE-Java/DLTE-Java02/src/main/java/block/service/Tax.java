package block.service;

import java.util.Scanner;

public class Tax {
    public static void main (String[] args){
        double salary;
        char regime;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the salary");
        salary=sc.nextDouble();

        System.out.println("Choose the regime between the old and new");
        regime=sc.next().charAt(0);



    }
}
