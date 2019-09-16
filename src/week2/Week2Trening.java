package week2;

public class Week2Trening {

    /**
     * For halvåpent tabellintervall a[fra:til)
     * bruker her signaturen fra og til
     * @param a
     * @param fra
     * @param til
     * @return
     */
    public static int størstITabell(int[] a, int fra, int til){
    //public static int størstITabell(int[] a, int v, int h)    Denne brukes ved et lukket intervall "v" og "h"
        if(fra < 0 || til > a.length || fra >= til){
            throw new IllegalArgumentException("Feil parameterverdier");
        }

        int m = fra;                //indeks til største verdi i a[fra:til)
        int maksverdi = a[m];       //Største verdien

        for(int i = fra  + 1; i<til; i++){
            if(a[i] > maksverdi){
                m = i;              //Oppdaterer indeks til største
                maksverdi = a[m];   //oppdaterer maksverdien til tallet som ligger i største indeks
            }
        }

        return m;
    }

    public static int maksHeleTabell(int[] a){
        return størstITabell(a, 0, a.length);
    }


}
