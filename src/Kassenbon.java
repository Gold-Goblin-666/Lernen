import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Kassenbon {

    Adresse adresse;
    public List<Rechnungsposition> positionen;


    public Kassenbon() {
        positionen = new ArrayList<Rechnungsposition>();
    }

    public double printIt(List<Produkt> produkts) {

        double gesammt = 0.0;
        String datumzeit = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());

        String eur = " EUR";

        int breitebon = 128;


        //##########################################################################################################################################
        // Aufgabe:
        //Wenn string zu lang für eine Spalte,
        //diesen auf mehrere Spalten aufteilen

        // Scheuen wie viel plate in spalte, ist
        // Zeichenanzahl im String durch Zeichen frei in Spalte => auf geraden teil aufrunden = Spalten die ich brauche
        // String mit Substring auf die Spalten aufzeieln
        // z.b. 0 bis 50; 51 bis 100; 101 bis rest ( 3 Zeielen mit z.B. gesammt 128 Zeichen
        // ##########################################################################################################################################


        System.out.println("Kassenbon" + '\n' + "kasse 1 " + '\n' + datumzeit + '\n' + "----------------------------------------------------------------");

        for (int i = 0; i < positionen.size(); i++) {


            System.out.println("################################################################");

            String produkthier = positionen.get(i).getProdukt().getName();


            if (produkthier.length() < 25) {

                System.out.println(produkthier);

            } else {

                System.out.println(produkthier);

                int n;


                for (n = 0; n < produkthier.length(); n++) {
                    if (Character.isSpaceChar(produkthier.charAt(n))) {
                        System.out.println(n);


                    }
                }


                System.out.println(produkthier.length());



/*
                int m;

                for (m = 0 ; m +32 < produkthier.length(); m = m +32){

                    System.out.println(produkthier.substring(m,m+32));

                }
                System.out.println(produkthier.substring(m));













*/
            }
            //System.out.println(produkthier);



                System.out.println("################################################################");


                System.out.print(positionen.get(i) + " ");

                Rechnungsposition position = positionen.get(i);

                double preis = position.getPrice();

                String rundenpreis = String.format("%.2f", preis);

                System.out.print(rundenpreis + eur);


                double preisMehrere = preis * position.anzahl;

                String rundenMehrere = String.format("%.2f", preisMehrere);

                String preisLaenge = Double.toString(preis);

                String positoinenString = positionen.get(i).toString();

                int length = rundenMehrere.length();
                int lenghtpreis = rundenpreis.length();
                int lenghtPositionen = positoinenString.length();
                int eurlenght = eur.length();


                int leerzeichenMitte = breitebon - 4 - 1 - lenghtPositionen - lenghtpreis - length - eurlenght;

                String z = "";

                for (int b = 0; b < leerzeichenMitte; b++) {
                    z = z + " ";
                }
                System.out.println(z + rundenMehrere + eur);

                gesammt = gesammt + preisMehrere;

            }

            System.out.println("----------------------------------------------------------------");

            String rundenalles = String.format("%.2f", gesammt);

            int leerzeichenEnde = breitebon - rundenalles.length() - eur.length();

            String t = "";

            for (int i = 0; i < leerzeichenEnde; i++) {
                t = t + " ";
            }

            System.out.println(t + rundenalles + eur);

            System.out.println(" " + '\n' + '\n');


            return gesammt;
        }

}
//128: "--------------------------------------------------------------------------------------------------------------------------------"
// 64: "----------------------------------------------------------------"