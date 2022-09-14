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


        System.out.println( "Kassenbon" + '\n' + "kasse 1 " + '\n' + datumzeit + '\n' + "--------------------------------" );

        for( int i = 0 ; i < positionen.size() ; i++ ){
            System.out.print(positionen.get(i) + " ");

            Rechnungsposition position = positionen.get(i);

            System.out.println(Kassensystem.getPrice(position.getName(), produkts ));

            System.out.println(Kassensystem.getPrice(position.getName(), produkts ) * position.anzahl);

            gesammt = gesammt + Kassensystem.getPrice(position.getName(), produkts ) * position.anzahl;




        }

        System.out.println("-------------------------------");

        System.out.println(gesammt);

        System.out.println(" " + '\n'+'\n');


        return gesammt;


    }









//    @Override
//    public String toString() {
//        return "Kassenbon{" +
//                "adresse=" + adresse +
//                ", positionen=" + positionen +
//                '}';
//    }

//Datum
    //Zeit


}
