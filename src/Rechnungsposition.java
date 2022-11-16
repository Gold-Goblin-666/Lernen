import java.sql.*;

public class Rechnungsposition {

    Produkt produkt;
    Integer anzahl;

    private Kassenbon bon;

    public Rechnungsposition(Produkt produkt, Integer anzahl, Kassenbon bon) {
        this.produkt = produkt;
        this.anzahl = anzahl;
        this.bon = bon;
    }

    public Kassenbon getBon() {
        return bon;
    }

    public void setBon(Kassenbon bon) {
        this.bon = bon;
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

    void eintragRechnungspositionenInSQL (Kassenbon kassenbon) throws SQLException {

//SELECT * FROM transferprojekt.rechnungspositionen;
//insert into transferprojekt.rechnungspositionen (produkt_id, bon_id, anzahl) value (' 1 ' , ' 2 ' , ' 3 ' );
//delete FROM transferprojekt.rechnungspositionen where id < 100 ;


        String url = "jdbc:mysql://localhost:3306/transferprojekt";
        String username = "java";
        String password = "123";
        //System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            //System.out.println("Database connected!");

            Integer produkt_id = getProdukt().getId();
            Integer bon_id =  kassenbon.getId() + 1;

            System.out.println("bon_id : " + bon_id);

            Integer anzahl = getAnzahl() ;

            //System.out.println( produkt_id + " " + bon_id + " " + anzahl  );

            String rechnungspositionenSQL = "insert into transferprojekt.rechnungspositionen (produkt_id, bon_id, anzahl) value (" +  produkt_id + "," + bon_id + "," +  anzahl + ");";
            System.out.println( rechnungspositionenSQL );

            PreparedStatement statement = connection.prepareStatement(rechnungspositionenSQL);
            statement.execute();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database!", e);
        }
    }
}

