import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Kassenbon {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String datumzeit;

    public List<Rechnungsposition> positionen;

    public Kassenbon() {
        datumzeit = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        positionen = new ArrayList<Rechnungsposition>();
    }

    public double printIt() throws SQLException {

        double gesammt = 0.0;
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
            gesammt = printRechnungspositionen(gesammt, euro);

            // Hier Datum in SQLDatenbank bei Table bon einfügen
        kassenbonToDB();
        return gesammt;
    }

    private double printRechnungspositionen(double gesammt, String euro) throws SQLException {

        int breitebon = 64;

        for (int loopMiddle = 0; loopMiddle < positionen.size(); loopMiddle = loopMiddle +1) {

            Rechnungsposition position = positionen.get(loopMiddle);
            String produkthier = positionen.get(loopMiddle).getProdukt().getName();

            double preis = positionen.get(loopMiddle).getPrice();
            String rundenpreis = String.format("%.2f", preis);
            int lenghtPreis = rundenpreis.length();

            int anzahl = positionen.get(loopMiddle).getAnzahl();
            int lenghtAnzahl = String.valueOf(anzahl).length();

            double preisMehrere = preis * position.anzahl;
            String rundenMehrere = String.format("%.2f", preisMehrere);
            int lengthRundenMehrere = rundenMehrere.length();

            int lenghtEuro = euro.length();

            if (produkthier.length() <= 32) {
                int leerzeichenMitte = breitebon - lenghtAnzahl - 3 - produkthier.length() - lengthRundenMehrere - lenghtEuro;
                String z = "";
                for (int b = 0; b < leerzeichenMitte; b++) {
                    z = z + " ";
                }

                System.out.println(anzahl + " * " + produkthier + z + rundenMehrere + euro);
               position.eintragRechnungspositionenInSQL(this);
            } else {

                String zeichenkette = produkthier;
                Boolean isFirstLine = true;
                while (zeichenkette.length() > 0) {
                    int split_index = getSplit(zeichenkette, 32);
                    String print_line = zeichenkette.substring(0, split_index);
                    zeichenkette = zeichenkette.substring(split_index);
                    if (isFirstLine) {

                        int leerzeichenMitte = breitebon - lenghtAnzahl - 3 - print_line.length() - lengthRundenMehrere - lenghtEuro;
                        String z = "";
                        for (int b = 0; b < leerzeichenMitte; b++) {
                            z = z + " ";
                        }

                        System.out.println(anzahl + " * " + print_line + z + rundenMehrere + euro);
                        isFirstLine = false;
                    } else {
                        int leerzeichenMitte = lenghtAnzahl + 3;
                        String z = "";
                        for (int b = 0; b < leerzeichenMitte; b++) {
                            z = z + " ";
                        }

                        System.out.println(z + print_line);
                    }
                }
                position.eintragRechnungspositionenInSQL(this);
            }
            gesammt = gesammt + preisMehrere;
        }

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

    private void kassenbonToDB() throws SQLException {

//SELECT * FROM transferprojekt.bon;
//insert into transferprojekt.bon (datumzeit) value ("12/10/2022 12:30");
//insert into transferprojekt.bon (datumzeit) value ("04/10/2006 12:30");
//delete FROM transferprojekt.bon where id < 100 ;


        String url = "jdbc:mysql://localhost:3306/transferprojekt";
        String username = "java";
        String password = "123";
        //System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            //System.out.println("Database connected!");

            String datumZeitString = datumzeit;
            //System.out.println( datumZeitString );

            String datumZeitSQL = "insert into transferprojekt.bon (datumzeit) value (\"" + datumZeitString + "\");";
            //System.out.println( datumZeitSQL );

            PreparedStatement statement = connection.prepareStatement(datumZeitSQL);
            statement.execute();

            String sql = "SELECT LAST_INSERT_ID() as id;";

            //PreparedStatement stmt = connection.prepareStatement(sql);
            //ResultSet rs = stmt.executeQuery();
            //this.id = rs.getInt("id");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            this.id = rs.getInt("id");
            System.out.println("this.id : " + this.id);


        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
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