public class Produkt {
    String produktID;
    String category;
    String subCategory;
    String name;
    Double preis;

    public Produkt(String produktID, String category, String subCategory, String name, Double preis) {

        this.produktID = produktID;
        this.category = category;
        this.subCategory = subCategory;
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

    public String getProduktID() {
        return produktID;
    }

    public void setProduktID(String produktID) {
        this.produktID = produktID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }
}
