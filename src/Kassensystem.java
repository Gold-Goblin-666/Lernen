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

        extracted(produkts);

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

    }

    private static List<Produkt> extracted(List<Produkt> produkts) {
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
        return produkts;
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

}