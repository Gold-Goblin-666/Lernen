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


        System.out.println( "Kassenbon" + '\n' + "kasse 1 " + '\n' + datumzeit + '\n' + "--------------------------------------------------------------------------------------------------------------------------------" );

        for( int i = 0 ; i < positionen.size() ; i++ ){
            System.out.print(positionen.get(i) + " ");

            Rechnungsposition position = positionen.get(i);

            double preis = position.getPrice();

            String rundenpreis =String.format("%.2f",preis);

            System.out.print(rundenpreis + " EUR");


            double preisMehrere = preis * position.anzahl;

            String rundenMehrere = String.format("%.2f",preisMehrere);

            String preisLaenge =Double.toString(preis);

            String positoinenString = positionen.get(i).toString();

            int length = rundenMehrere.length();
            int lenghtpreis = preisLaenge.length();
            int lenghtPositionen = positoinenString.length();


            int leerzeichenMitte = 128-4-1-4- lenghtPositionen - lenghtpreis - length ;

            String z = "";

            for(int b=0; b<leerzeichenMitte; b++){
                z = z + " ";
            }
            System.out.println(z + rundenMehrere + " EUR");

            gesammt = gesammt + preisMehrere;

        }

        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");

        String rundenalles =String.format("%.2f",gesammt);

        int leerzeichenEnde = 128-rundenalles.length()-4;

        String t = "";

        for(int i=0; i<leerzeichenEnde; i++){
            t = t + " ";
        }

        System.out.println(t + rundenalles + " EUR");

        System.out.println(" " + '\n'+'\n');


        return gesammt;
    }
}
