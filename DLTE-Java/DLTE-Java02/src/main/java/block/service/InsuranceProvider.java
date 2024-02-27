package block.service;

import java.util.Scanner;

public class InsuranceProvider {
    public static void main(String[] args) {
        //Insurance suggester
        String need = "";
        Scanner scanner = new Scanner(System.in);
        //store in array
        String[] starHealth = {"Accidental", "NaturalCalamities", "Unfortunate death"};
        String[] icicLife = {"Marriage", "Health"};
        String[] myInsurance = {"Property_damage", "Vehicle_Insurance"};

        //System.out.println("There are insurance services like Health ,Accidental,Marriage, NaturalCalamities,Unfortunate death,Property_damage,Vehicle_Insurance");
        // System.out.println("----Choose the required insurance ,we are here to suggest you-----");
        //  need=scanner.nextLine();

        for (int integer = 0; integer < args.length; integer++) {
            for (String each : starHealth) {
                if (each.contains(args[integer])) {
                    System.out.println("Star health provides " + args[integer]);
                }
            }
            for (String each : icicLife) {
                if (each.contains(args[integer])) {
                    System.out.println("ICIC helath insurance provides " + args[integer]);
                }
            }
            for (String each : myInsurance) {
                if (each.contains(args[integer])) {
                    System.out.println("My Insurance  provides " + args[integer]);
                }
            }


        }
    }
}
