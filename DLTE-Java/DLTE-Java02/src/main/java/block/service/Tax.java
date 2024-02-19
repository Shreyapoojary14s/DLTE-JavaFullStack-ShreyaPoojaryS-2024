package block.service;

import java.util.Scanner;

public class Tax {
    public static void main (String[] args){
        double salary, tax;
        char regime;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the salary");
        salary=sc.nextDouble();

        System.out.println("Choose the regime between the old and new");
        regime=sc.next().charAt(0);
        switch (regime){
            case 'o':
                if(salary >=0 && salary<=250000){
                    tax =  0;
                System.out.println("The tax payed is "+tax);
            }
                else if (salary >=250000 && salary<=550000){
                    tax =  salary*0.05;
                    System.out.println("The tax payed is "+tax);
                }

                else if (salary >=550000 && salary<=750000){
                    tax =  salary*0.20;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=750000 && salary<=1000000){
                    tax =  salary*0.20;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=1000000 && salary<=1500000){
                    tax =  salary*0.30;
                    System.out.println("The tax payed is "+tax);
                }
                else {
                    tax =  salary*0.30;
                    System.out.println("The tax payed is "+tax);
                }


            case  'n' :
                if(salary >=0 && salary<=250000){
                    tax =  0;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=250000 && salary<=500000){
                    tax =  salary*0.05;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=500000 && salary<=750000){
                    tax =  salary*0.10;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=750000 && salary<=1000000){
                    tax =  salary*0.45;
                    System.out.println("The tax payed is "+tax);
                }

                else if (salary >=1000000 && salary<=1250000){
                    tax =  salary*0.20;
                    System.out.println("The tax payed is "+tax);
                }
                else if (salary >=1250000 && salary<=1500000){
                    tax =  salary*0.25;
                    System.out.println("The tax payed is "+tax);
                }
                else {
                    tax =  salary*0.30;
                    System.out.println("The tax payed is "+tax);
                }

        }
        System.out.println("----Thanks for using our services------");





    }
}
