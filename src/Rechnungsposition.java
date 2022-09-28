public class Rechnungsposition {

    Produkt produkt;
    Integer anzahl;

    public Rechnungsposition(Produkt produkt, Integer anzahl) {
        this.produkt = produkt;
        this.anzahl = anzahl;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Integer getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(Integer anzahl) {
        this.anzahl = anzahl;
    }

    public double getPrice(){
        return anzahl * produkt.getPreis();
    }





    @Override
    public String toString() {
        return anzahl+ " * " + produkt.getName()  ;
    }
}

