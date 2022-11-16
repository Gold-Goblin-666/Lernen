public class Produkt {

    Integer id;
    String produktID;
    String category;
    String subCategory;
    String name;
    Double preis;

    public Produkt(Integer id, String produktID, String category, String subCategory, String name, Double preis) {

        this.id = id;
        this.produktID = produktID;
        this.category = category;
        this.subCategory = subCategory;
        this.name = name;
        this.preis = preis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
