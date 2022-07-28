public class Kassenbon {

    public static void main(String[] args) {

        double preisWurst;
        preisWurst = 4.20;

        double preisKaese;
        preisKaese = 2.30;

        double preisBrot;
        preisBrot = 2.10;

        double preisDVD;
        preisDVD = 12.00;

        int anzahlWurst;
        anzahlWurst = 1;

        int anzahlKaese;
        anzahlKaese = 1;

        int anzahlBrot;
        anzahlBrot = 1;

        int anzahlDVD;
        anzahlDVD = 2;

        double preisgesammtWurst;
        preisgesammtWurst = anzahlWurst * preisWurst;

        double preisgesammtKaese;
        preisgesammtKaese = anzahlKaese * preisKaese;

        double preisgesammtBrot;
        preisgesammtBrot = anzahlBrot * preisBrot;

        double preisgesammtDVD;
        preisgesammtDVD = anzahlDVD * preisDVD;

        double inhaltBrieftache;
        inhaltBrieftache = 50.00;

        double preisGesammt;
        preisGesammt = (preisgesammtWurst + preisgesammtKaese + preisgesammtBrot + preisgesammtDVD);


        if (preisGesammt > inhaltBrieftache) {
            System.out.println("-----------------------------------------------------------");
            System.out.println(" ihnen fehlen " + (preisGesammt - inhaltBrieftache) + " EUR um diese Artikel zu Kaufen");
            System.out.println("-----------------------------------------------------------");

        } else {

            System.out.println("---------------------Beleg---------------------");

            System.out.println("Wurst" + "   " + anzahlWurst + " x " + preisWurst + " EUR");
            System.out.println("                     " + preisgesammtWurst + " EUR");

            System.out.println("Kaese" + "   " + anzahlKaese + " x " + preisKaese + " EUR");
            System.out.println("                     " + preisgesammtKaese + " EUR");

            System.out.println("Brot " + "   "  + anzahlBrot + " x " + preisBrot + " EUR");
            System.out.println("                     " + preisgesammtBrot + " EUR");

            System.out.println("DVD  " + "   "  + anzahlDVD + " x " + preisDVD + " EUR");
            System.out.println("                     " + preisgesammtDVD + " EUR");

            System.out.println("----------------------------------------------");

            System.out.println("Gesamt " + "              " + preisGesammt + " EUR" );
            System.out.println("Gegeben" + "              " +  inhaltBrieftache + " EUR" );
            System.out.println( " ");
            System.out.println("Zurueck" + "              " + (inhaltBrieftache - preisGesammt) + " EUR");

        }
    }
}


