package block.service;

import java.util.Scanner;

public class InsuranceProvider {
    public static void main(String[] args){
        //Insurance suggester
        String need="";
        Scanner scanner=new Scanner(System.in);
        //store in array
        String[] starHealth={"Accidental","NaturalCalamities","Unfortunate death"};
        String[] icicLife={"Marriage","Health"};
        String[] myInsurance={"Property_damage","Vehicle_Insurance"};

        System.out.println("There are insurance services like Health ,Accidental,Marriage, NaturalCalamities,Unfortunate death,Property_damage,Vehicle_Insurance");
        System.out.println("----Choose the required insurance ,we are here to suggest you-----");
        need=scanner.nextLine();

       for(int integer=0;integer<starHealth.length;integer++) {

           if (need.equals(starHealth[integer])) {
               System.out.println("You are suggested to have a Star Health Insurance where it includes " + need + "\tinsurance");

           }
       }
        for(int integer=0;integer<icicLife.length;integer++){
            if(need.equals(icicLife[integer])) {
                System.out.println("You are suggested to have a ICIC Lfe Insurance where it includes " + need + "\tinsurance");
                break;
            }
        }
       for(int integer=0;integer<=myInsurance.length;integer++){
           if(need.equals(myInsurance[integer])) {
            System.out.println("You are suggested to have a My Insurance where it includes "+need+ "\tinsurance");
            break;}
        }
    }
}
