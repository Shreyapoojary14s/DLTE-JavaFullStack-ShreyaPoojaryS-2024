package basics.service;

import java.util.Scanner;

public class FDCalculator {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Long amount=0L, intrestRate=0L;
        Integer period=0;
        Float intrest ,maturityamt;
        System.out.println("Enter the Principal amount");
        amount=scanner.nextLong();
        System.out.println("Enter the Intrest rate");
        intrestRate=scanner.nextLong();
        System.out.println("Enter the number of year");
        period=scanner.nextInt();
        float fixedDeposit;
        fixedDeposit=(amount*intrestRate*period)/100;
        System.out.println("With the principal amount"+amount+" where the rate of intrest "+intrestRate+"for a period of "+period+".Total return will be "+fixedDeposit);



    }
}
