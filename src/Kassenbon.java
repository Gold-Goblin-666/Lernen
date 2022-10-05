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


        //Aufgabe:
        //Wenn string zu lang für eine Spalte,
        //diesen auf mehrere Spalten aufteilen



        System.out.println( "Kassenbon" + '\n' + "kasse 1 " + '\n' + datumzeit + '\n' + "--------------------------------------------------------------------------------------------------------------------------------" );

        for( int i = 0 ; i < positionen.size() ; i++ ){
            System.out.print(positionen.get(i) + " ");

            Rechnungsposition position = positionen.get(i);

            double preis = position.getPrice();

            String rundenpreis =String.format("%.2f",preis);

            System.out.print(rundenpreis + eur);


            double preisMehrere = preis * position.anzahl;

            String rundenMehrere = String.format("%.2f",preisMehrere);

            String preisLaenge =Double.toString(preis);

            String positoinenString = positionen.get(i).toString();

            int length = rundenMehrere.length();
            int lenghtpreis = rundenpreis.length();
            int lenghtPositionen = positoinenString.length();
            int eurlenght = eur.length();


            int leerzeichenMitte = 128-4-1- lenghtPositionen - lenghtpreis - length - eurlenght ;

            String z = "";

            for(int b=0; b<leerzeichenMitte; b++){
                z = z + " ";
            }
            System.out.println(z + rundenMehrere + eur);

            gesammt = gesammt + preisMehrere;

        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        String rundenalles =String.format("%.2f",gesammt);

        int leerzeichenEnde = 128-rundenalles.length() - eur.length();

        String t = "";

        for(int i=0; i<leerzeichenEnde; i++){
            t = t + " ";
        }

        System.out.println(t + rundenalles + eur);

        System.out.println(" " + '\n'+'\n');


        return gesammt;
    }
}
