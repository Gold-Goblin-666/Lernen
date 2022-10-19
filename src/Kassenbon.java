import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Kassenbon {

    public List<Rechnungsposition> positionen;

    public Kassenbon() {
        positionen = new ArrayList<Rechnungsposition>();
    }

    public double printIt() {



        double gesammt = 0.0;
        String datumzeit = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

        String euro = " EUR";


        //##########################################################################################################################################
        // Aufgabe:
        //Wenn string zu lang für eine Spalte,
        //diesen auf mehrere Spalten aufteilen

        // Scheuen wie viel Platz in spalte, ist
        // Zeichenanzahl im String durch Zeichen frei in Spalte => auf geraden teil aufrunden = Spalten die ich brauche
        // String mit Substring auf die Spalten aufzeieln
        // z.b. 0 bis 50; 51 bis 100; 101 bis rest ( 3 Zeielen mit z.B. gesammt 128 Zeichen
        // ##########################################################################################################################################


        System.out.println("Kassenbon" + '\n' + "kasse 1 " + '\n' + datumzeit + '\n' + "----------------------------------------------------------------");
        for (int i = 0; i < positionen.size(); i++) {
            gesammt = printRechnungspositionen(gesammt, euro, i);
        }

        return gesammt;
    }

    private double printRechnungspositionen(double gesammt, String euro, int i) {

        int breitebon = 64;
        Rechnungsposition position = positionen.get(i);
        String produkthier = positionen.get(i).getProdukt().getName();

        double preis = positionen.get(i).getPrice();
        String rundenpreis = String.format("%.2f", preis);
        int lenghtPreis = rundenpreis.length();

        int anzahl = positionen.get(i).getAnzahl();
        int lenghtAnzahl = String.valueOf(anzahl).length();

        double preisMehrere = preis * position.anzahl;
        String rundenMehrere = String.format("%.2f", preisMehrere);
        int lengthRundenMehrere = rundenMehrere.length();

        int lenghtEuro = euro.length();


        if (produkthier.length() <= 32) {
            int leerzeichenMitte = breitebon - lenghtAnzahl - 3 - produkthier.length() - lengthRundenMehrere - lenghtEuro ;
            String z = "";
            for (int b = 0; b < leerzeichenMitte; b++) {
                z = z + " ";
            }

            System.out.println(anzahl + " * " + produkthier  + z +  rundenMehrere + euro);
        } else {

            String zeichenkette = produkthier;
            Boolean isFirstLine = true;
            while (zeichenkette.length() > 0) {
                int split_index = getSplit(zeichenkette, 32);
                String print_line = zeichenkette.substring(0, split_index);
                zeichenkette = zeichenkette.substring(split_index);
                if (isFirstLine) {

                    int leerzeichenMitte = breitebon - lenghtAnzahl - 3 - print_line.length() - lengthRundenMehrere - lenghtEuro ;
                    String z = "";
                    for (int b = 0; b < leerzeichenMitte; b++) {
                        z = z + " ";
                    }

                    System.out.println(anzahl + " * " + print_line  + z +  rundenMehrere + euro);
                    isFirstLine = false;
                } else {
                    int leerzeichenMitte = lenghtAnzahl + 3 ;
                    String z = "";
                    for (int b = 0; b < leerzeichenMitte; b++) {
                        z = z + " ";
                    }

                    System.out.println(z + print_line);
                }
            }
        }

        gesammt = gesammt + preisMehrere;

        System.out.println("----------------------------------------------------------------");
        String rundenGesammt = String.format("%.2f", gesammt);

        int leerzeichenEnde = breitebon - rundenGesammt.length() - euro.length();
        String t = "";
        for (int k = 0; k < leerzeichenEnde; k++) {
            t = t + " ";
        }

        System.out.println(t + rundenGesammt + euro);

        System.out.println(" " + '\n' + '\n');
        return gesammt;
    }

    private int getSplit(String zeichenkette, int h) {

        if (zeichenkette.length() <= h){
            return zeichenkette.length();
        }

        for (int b = h; b > 0; b--) {
            if (Character.isSpaceChar(zeichenkette.charAt(b))) {
                int split_an = b+1;
                return split_an;
            }
        }
        return h;
    }

}
//128: "--------------------------------------------------------------------------------------------------------------------------------"
// 64: "----------------------------------------------------------------"