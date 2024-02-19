package block.service;
import java.util.Scanner;
import java.lang.Math;
public class SIP {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long invest;
        double rate;
        int year;
        double total;
        System.out.println("Enter the Monthly investment");
        invest=sc.nextInt();
        System.out.println("Enter the expected return in percentage");
        rate=sc.nextInt();
        System.out.println("Enter the time duration");
        year=sc.nextInt();
        rate=rate/(12*100);
        year*=12;
        total= (invest*((Math.pow(1+rate,year)-1)/rate)*(1+rate));
        System.out.println("The Resultant output is"+total);

    }
}
