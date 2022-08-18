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
        return "Kassenbon{" +
                "adresse=" + adresse +
                ", positionen=" + positionen +
                '}';
    }



//    @Override
//    public String toString() {
//        return "Kassenbon" + '\n' +
//                "kasse 1 " +  '\n' +
//                "--------------------" + '\n' +
//                 positionen  + '}';
//    }



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
