package hjelpeklasser;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {
    }

    public static void bytt(int[] a, int i, int j) {
        isNull(a);
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static void skriv(int[] a, int fra, int til) {
        isNull(a);
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i <= til - 1; i++) {
            System.out.print(a[i]);
            if (i < til) {
                System.out.print(" ");
            }
        }
    }


    public static void skrivln(int[] a, int fra, int til) {
        isNull(a);
        fratilKontroll(a.length, fra, til);

        for (int i = fra; i <= til - 1; i++) {
            System.out.print(a[i]);
            if (i < til) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }


    public static void skriv(int[] a) {
        isNull(a);

        skriv(a, 0, a.length);
    }


    public static void skrivln(int[] a) {
        isNull(a);

        skriv(a, 0, a.length);

        System.out.println();
    }


    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k + 1);        // en tilfeldig tall fra 0 til k
            bytt(a, k, i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }


    /**
     * Metode for å finne største tall i tabell.
     *
     * @param a
     * @param fra
     * @param til
     * @return
     */
    public static int maks(int[] a, int fra, int til) {
        isNull(a);
        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }


    public static int maks(int[] a) {
        isNull(a);

        return maks(a, 0, a.length);     // kaller metoden over
    }


    /**
     * Metode for å finne minste verdi i halvåpen tabell
     *
     * @param a
     * @param fra
     * @param til
     * @return
     */
    public static int min(int[] a, int fra, int til) {
        isNull(a);
        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til minste verdi i a[fra:til>
        int minverdi = a[fra];   // minste  verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] < minverdi) {
                m = i;                // indeks til minste verdi oppdateres
                minverdi = a[m];     // misnte verdi oppdateres
            }
        }

        return m;  // posisjonen til misnte verdi i a[fra:til>
    }


    public static int min(int[] a) {
        isNull(a);
        return min(a, 0, a.length);     // kaller metoden over
    }


    public static int[] nestMaks(int[] a) {
        int n = a.length;                                                           // tabellens lengde

        if (n < 2) throw                                                            // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);                                                            // m er posisjonen til tabellens største verdi

        int nm;                                                                     // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                                                                 // den største ligger først
        {
            nm = maks(a, 1, n);                                                 // leter i a[1:n>
        } else if (m == n - 1)                                                      // den største ligger bakerst
        {
            nm = maks(a, 0, n - 1);                                         // leter i a[0:n-1>
        } else {
            int mv = maks(a, 0, m);                                             // leter i a[0:m>
            int mh = maks(a, m + 1, n);                                         // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;                                           // hvem er størst?
        }

        return new int[]{m, nm};                                                    // m i posisjon 0 , nm i posisjon 1

    }


    public static void fratilKontroll(int tabellengde, int fra, int til) {

        if (fra < 0) {
            throw new IndexOutOfBoundsException("Fra (" + fra + ") er negativt!");
        }

        if (til > tabellengde) {
            throw new IndexOutOfBoundsException("Til (" + til + ") er utenfor tabellengden (" + tabellengde + ").");
        }

        if (fra > til) {
            throw new IllegalArgumentException("Fra (" + fra + ") er større enn til (" + til + ") - Illegalt interval!");
        }

        if (fra == til) {
            throw new NoSuchElementException("Fra (" + fra + ") og til (" + til + ") er like - Tomt Intervall!");
        }
    }


    public static void isNull(int[] a) {
        if (a == null) {
            throw new NullPointerException("Tabellen som refereres til er tomt.");
        }
    }

    
    public static void vhKontroll(int tabellengde, int v, int h) {
        if (v < 0) {
            throw new ArrayIndexOutOfBoundsException("v (" + v + ") er negativt!");
        }

        if (h >= tabellengde) {
            throw new ArrayIndexOutOfBoundsException("h (" + h + ") er større en tabellengden (" + tabellengde + ").");
        }

        if (v > h + 1) {
            throw new IllegalArgumentException("v (" + v + ") er større enn h (" + h + ").");
        }
    }

    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }

    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }

    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));  // to hjelpemetoder
    }

    public static void utvalgssortering(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        for (int i = fra; i < til - 1; i++){
            bytt(a, i, min(a, i, a.length));
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

    public static int lineærsøkSistePosisjon(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
}
