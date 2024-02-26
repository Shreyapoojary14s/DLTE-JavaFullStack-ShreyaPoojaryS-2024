package blocks.service;

public class MyBond {
    public static void main(String[] args) {
        //initalization

        Bonds bonds[] = {
                new Bonds(80000.0, 5.2, true, "Siri", 2),
                new Bonds(75000.0, 3.4, false, "Jackie", 2),
                new Bonds(55000.0, 4.0, true, "Nishmitha", 1),
                new Bonds(60000.0, 5.0, true, "Medhini", 1),

        };
        MyBond myBond = new MyBond();
        MyBond.sort(bonds);
    }

    //sorting based on high intrest rate
    public static void sort(Bonds bonds[]) {
        for (int i = 0; i < bonds.length; i++) {
            for (int j = i; j < bonds.length; j++) {
                if (bonds[i].getInterestRate().compareTo(bonds[j].getInterestRate()) <= 0) {
                    Bonds temp = bonds[i];
                    bonds[i] = bonds[j];
                    bonds[j] = temp;
                }
            }

        }
        System.out.println("Bonds sorted Based on Intrest rate\t");
        ;
        for (Bonds each1 : bonds) {
            System.out.println(each1.toString());
        }
    }
}
