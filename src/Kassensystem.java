import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kassensystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double alles = 0;

        List<Produkt> produkts = new ArrayList<>();

        try{
            Scanner csvscanner = new Scanner(new File("CSVKassenbon.csv"));

            int i = 0;

            while (csvscanner.hasNextLine() ){
                String line = csvscanner.nextLine();
                String[] split = line.split(";");

                if (i != 0) {
                    double price = Double.parseDouble(split[1].replace(",", "."));
                    Produkt produkt = new Produkt(split[0], price);
                    produkts.add(produkt);
                }
                i++;
            }
            csvscanner.close();
           // System.out.println( produkts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


/*        Produkt wurst = new Produkt( "Wurst", 4.20);
        produkts.add(wurst);

        Produkt kaese = new Produkt("Kaese", 2.30);
        produkts.add(kaese);

        Produkt brot = new Produkt("Brot",2.10);
        produkts.add(brot);

        Produkt dvd = new Produkt("DVD", 12.00);
        produkts.add(dvd);
*/



        List<Kassenbon> bons = new ArrayList<>();

        // Schleife bis mann Exit eingibt

        boolean kassiererfertig = false;
        boolean produktefertig;


        while (kassiererfertig == false ){

            Kassenbon bon = new Kassenbon();

            System.out.println("Nächster Kunde [Y/N]");
            String naechsterKunde = scanner.nextLine();

            if (naechsterKunde.equals("N")){
                produktefertig = true;
                kassiererfertig = true;
            } else {
                produktefertig = false;
            }

            while ( produktefertig == false ) {


                // scanner = new Scanner(System.in);
                // Warum muss es neu initialisiert werden


                System.out.println(" welches Produkt haben sie gekauft ? ");
                String nameProdukt = scanner.nextLine();

                if (!(nameProdukt.isEmpty())) {

                    System.out.println(" Wie viel haben sie von dem Produkt gekauft ? ");

                    int anzahlProdukt = 0;
                    try {
                        anzahlProdukt = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException n) {
                        System.out.println(" Schreibe eine Zahl ");

                    }

                    System.out.println(nameProdukt + " " + anzahlProdukt);

                    Rechnungsposition rp = new Rechnungsposition(nameProdukt, anzahlProdukt);
                    bon.positionen.add(rp);

                } else {
                    produktefertig = true;
                    System.out.println( " wir sind fertig "  + '\n'+ '\n'+ '\n');

                }
            }

            //System.out.println(bon.toString());

            if (produktefertig == true && kassiererfertig == false){

                double gesammt = bon.printIt(produkts);
                alles = alles + gesammt;

            }
        }

        System.out.println("Heutiger gesammter verkauf : " + alles + "€");

        scanner.close();






//        System.out.println("welches produkt haben sie gekauft");
//        String nameProdukt1 = scanner.next();
//        System.out.println("Wie viel haben sie von dem Produkt gekauft");
//        int anzahlProdukt1 = scanner.nextInt();
//        System.out.println(nameProdukt1 + anzahlProdukt1);
//
//        Rechnungsposition bon1 = new Rechnungsposition( nameProdukt1 , anzahlProdukt1 );
//        bons.add(bon1);
//
//        System.out.println(bon1);
//
//
//
//
//        System.out.println("welches produkt haben sie gekauft");
//        String nameProdukt2 = scanner.next();
//        System.out.println("Wie viel haben sie von dem Produkt gekauft");
//        int anzahlProdukt2 = scanner.nextInt();
//        System.out.println(nameProdukt2 + anzahlProdukt2);
//
//        Rechnungsposition bon2 = new Rechnungsposition("" + nameProdukt2 , anzahlProdukt2 );
//        bons.add(bon2);
//
//
//
//
//
//        System.out.println("welches produkt haben sie gekauft");
//        String nameProdukt3 = scanner.next();
//        System.out.println("Wie viel haben sie von dem Produkt gekauft");
//        int anzahlProdukt3 = scanner.nextInt();
//        System.out.println(nameProdukt3 + anzahlProdukt3);
//
//        Rechnungsposition bon3 = new Rechnungsposition("" + nameProdukt3 ,anzahlProdukt3 );
//        bons.add(bon3);
//
//
//
//        System.out.println("welches produkt haben sie gekauft");
//        String nameProdukt4 = scanner.next();
//        System.out.println("Wie viel haben sie von dem Produkt gekauft");
//        int anzahlProdukt4 = scanner.nextInt();
//        System.out.println(nameProdukt4 + anzahlProdukt4);
//
//        Rechnungsposition bon4 = new Rechnungsposition("" + nameProdukt4 , anzahlProdukt4 );
//        bons.add(bon4);































//          System.out.println(getPrice(nameProdukt, produkts ));

//        System.out.println(getPrice("Brot", produkts ));





//        double preisGesammt;
//        preisGesammt = (preisgesammtWurst + preisgesammtKaese + preisgesammtBrot + preisgesammtDVD);
//
//
//        if (preisGesammt > inhaltBrieftache) {
//
//            System.out.println("-----------------------------------------------------------");
//            System.out.println(" ihnen fehlen " + (preisGesammt - inhaltBrieftache) + " EUR um diese Artikel zu Kaufen");
//            System.out.println("-----------------------------------------------------------");
//
//        } else {
//
//            System.out.println("---------------------Beleg---------------------");
//
//            System.out.println("Wurst" + "   " + anzahlWurst + " x " + preisWurst + " EUR");
//            System.out.println("                     " + preisgesammtWurst + " EUR");
//
//            System.out.println("Kaese" + "   " + anzahlKaese + " x " + preisKaese + " EUR");
//            System.out.println("                     " + preisgesammtKaese + " EUR");
//
//            System.out.println("Brot " + "   " + anzahlBrot + " x " + preisBrot + " EUR");
//            System.out.println("                     " + preisgesammtBrot + " EUR");
//
//            System.out.println("DVD  " + "   " + anzahlDVD + " x " + preisDVD + " EUR");
//            System.out.println("                     " + preisgesammtDVD + " EUR");
//
//            System.out.println("----------------------------------------------");
//
//            System.out.println("Gesamt " + "              " + preisGesammt + " EUR");
//            System.out.println("Gegeben" + "              " + inhaltBrieftache + " EUR");
//            System.out.println(" ");
//            System.out.println("Zurueck" + "              " + (inhaltBrieftache - preisGesammt) + " EUR");


    }

    static Double getPrice(String name, List<Produkt> produkts){

        for ( int i = 0 ; i < produkts.size() ; i ++ ) {

            Produkt produkt = produkts.get(i);

            if( produkt.getName().equals(name)){

                return produkt.getPreis();
            }
        }
        return null;
    }

    public
    try{
        Scanner csvscanner = new Scanner(new File("CSVKassenbon.csv"));

        int i = 0;

        while (csvscanner.hasNextLine() ){
            String line = csvscanner.nextLine();
            String[] split = line.split(";");

            if (i != 0) {
                double price = Double.parseDouble(split[1].replace(",", "."));
                Produkt produkt = new Produkt(split[0], price);
                produkts.add(produkt);
            }
            i++;
        }
        csvscanner.close();
        // System.out.println( produkts);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }

}


