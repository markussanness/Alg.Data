package week1;

public class ForLoopOperations {

    public static void main(String[] args) {
        int [] a = {};
        int []b = minmax(a);

        int tallet = 4;
        long fak = fak(tallet);

        int maksko = maks(a);
        System.out.println(maksko);
        System.out.println("Fakuleteten til tallet " + tallet + " er " + fak);
        System.out.println("Det misnte tallet er på plass " +b[0]+ " og det største talle er på plass " +b[1]);

    }
    public static int[] minmax(int[]a){
        int[] b = {0, 0};
        int min = 0;
        int max = 0;
        for(int i = 0 ; i < a.length ; i++){
            if (a[i] > a[max]) {
                max = i;

            }
            if(a[i] < a[min]){
                min = i;

            }
        }
        b[1] = max;
        b[0] = min;
        return b;
    }
    public static long fak(int a){
        long tall = 1;
        while(a>1) {
            tall *= a;
            a--;
        }
        return tall;
    }
    public static int maks(int[] a)  // versjon 3 av maks-metoden
    {
        if (a.length == 0) {
            return -1;
        }
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    }
}