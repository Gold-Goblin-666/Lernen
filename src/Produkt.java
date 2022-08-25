import java.util.List;

public class Produkt {

    String name;
    Double preis;

    public Produkt(String name, Double preis) {
        this.name = name;
        this.preis = preis;
    }


    public Double getPreis() {
        return preis;
    }

    public void setPreis(Double preis) {
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
