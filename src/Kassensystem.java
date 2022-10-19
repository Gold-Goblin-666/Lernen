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

        //csvreader(produkts);
        csvreaderlong(produkts);

        List<Kassenbon> bons = new ArrayList<>();

        // Schleife bis mann Exit eingibt

        boolean kassiererfertig = false;
        boolean produktefertig;


        while (kassiererfertig == false) {

            Kassenbon bon = new Kassenbon();

            System.out.println("Nächster Kunde [Y/N]");
            String naechsterKunde = scanner.nextLine();

            if (naechsterKunde.equals("N")) {
                produktefertig = true;
                kassiererfertig = true;
            } else {
                produktefertig = false;
            }

            while (produktefertig == false) {

                System.out.println("welches Produkt haben sie gekauft ? ");
                String nameProdukt = scanner.nextLine();

                Produkt produkt = findProduktInList(nameProdukt,produkts);

                // findProduktInList == soll produkte in der Liste finden,
                // die mit dem gleichen anfange, wie das was man in die Konsole eingegeben hat
                // und danach ausgeben, welches Produkt mit dem Namen vorhanden sind
                // xerox als bsp


                if (!(nameProdukt.equals(""))) {

                    System.out.println(" Wie viel haben sie von dem Produkt gekauft ? ");

                    int anzahlProdukt = 0;
                    try {
                        anzahlProdukt = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException n) {
                        System.out.println(" Schreibe eine Zahl ");

                    }

                    System.out.println(produkt.getName() + " " + anzahlProdukt);


                    Rechnungsposition rp = new Rechnungsposition(produkt, anzahlProdukt);
                    bon.positionen.add(rp);

                } else {
                    produktefertig = true;
                    System.out.println(" wir sind fertig " + '\n' + '\n' + '\n');

                }
            }

            //System.out.println(bon.toString());

            if (produktefertig == true && kassiererfertig == false) {

                double gesammt = bon.printIt();
                alles = alles + gesammt;

            }
        }

        String rundenAllesEnde = String.format("%.2f", alles);

        System.out.println("Heutiger gesammter verkauf : " + rundenAllesEnde + "€");

        scanner.close();

    }

    private static Produkt findProduktInList(String nameProdukt, List<Produkt> produkts) {

        List< Produkt>matchesProdukt = new ArrayList<>();
        Scanner scannerprod = new Scanner(System.in);


        for (Produkt p : produkts) {

            if (p.getName().contains(nameProdukt) && !(nameProdukt.equals(""))) {

                matchesProdukt.add(p);


            } else {
            }
        }

        if (matchesProdukt.size() == 1 ){

            System.out.println( "Wir haben ein produkt mit diesem namen: ");

            System.out.println(matchesProdukt);

            return  matchesProdukt.get(0);




        } else if (matchesProdukt.size() > 1 ){

            System.out.println("Wir haben mehrere Produkte mit diesem namen:");

            for (int m = 0 ; m < matchesProdukt.size(); m++ ){


                double priceallgemein = matchesProdukt.get(m).getPreis();
                String pricepdodukt = String.format("%.2f",priceallgemein);


                System.out.println( m + "   " + matchesProdukt.get(m).getName() + "  " +pricepdodukt + "€");

            }

            System.out.println("Welches meinen sie ? ");

            int welchesProdukt = scannerprod.nextInt();

            Produkt produktGewaehlt = matchesProdukt.get(welchesProdukt);

            System.out.println("Sie haben das Produkt : " + produktGewaehlt.getName() + " ausgewählt");

            return  produktGewaehlt;



        }

        return null;
    }


    private static List<Produkt> csvreaderlong(List<Produkt> produkts) {
        try {
            Scanner csvscanner = new Scanner(new File("Sample - Superstore - utf8.csv"));

            int i = 0;

            while (csvscanner.hasNextLine()) {
                String line = csvscanner.nextLine();

                //sonderzeichen ersetzen

                String[] split = line.split(";");

                if (i != 0) {

                    double price = Double.parseDouble(split[4]);
                    Produkt produkt = new Produkt(split[0], split[1], split[2], split[3], price);
                    produkts.add(produkt);
                }
                //System.out.println(i);
                i++;

            }
            csvscanner.close();
            // System.out.println( produkts);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return produkts;
    }

}