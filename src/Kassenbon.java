import javax.swing.*;
import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class Kassenbon {

    Adresse adresse;
    public List<Rechnungsposition> positionen;


    public Kassenbon() {
        positionen = new ArrayList<Rechnungsposition>();
    }




        @Override
    public String toString() {
        String drucken;

        drucken = "Kassenbon" + '\n' + "kasse 1 " +  '\n' + "--------------------------------" ;

        System.out.println(drucken);

        for( int i = 0 ; i < positionen.size() ; i++ ){
            System.out.println(positionen.get(i));


            System.out.println(Kassensystem.getPrice());
        }










        return drucken ;
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
