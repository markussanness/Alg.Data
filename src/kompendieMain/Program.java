package kompendieMain;

import hjelpeklasser.Tabell;

public class Program {

    public static void main(String ... args){


        int[] a = Tabell.randPerm(20);                  // en tilfeldig tabell
        int[] b = null;
        for (int k : a) System.out.print(k + " ");         // skriver ut a

        int m = Tabell.maks(a);                            // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

        Tabell.skriv(a, 3, 8);
        System.out.println();
        Tabell.skriv(a);
        System.out.println();

        Tabell.skrivln(a, 3, 8);
        Tabell.skrivln(a);

        int[] d = {};
        int[] c = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
        System.out.println(Tabell.lineærsøk(c,32));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,31));              // utskrift: -11
        System.out.println(Tabell.lineærsøk(c,-3));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(d,0));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,2));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,15));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,16));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,40));              // utskrift: 10
        System.out.println(Tabell.lineærsøk(c,41));              // utskrift: 10



        //Tabell.skriv(a, -2, 10);           //negativ fra
        //Tabell.skriv(a, 3, 21);            //til utenfor tabellengde
        //Tabell.skriv(a, 10, 3);            //fra større enn til
        //Tabell.skriv(a, 10, 10);           //fra og til er like store, tomt intervall

        //Tabell.maks(a, -2, 10);           //negativ fra
        //Tabell.maks(a, 3, 21);            //til utenfor tabellengde
        //Tabell.maks(a, 10, 3);            //fra større enn til
        //Tabell.maks(a, 10, 10);           //fra og til er like store, tomt intervall

        Tabell.maks(b, 1,5);

    }
}
