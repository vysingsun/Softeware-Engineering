public class Country extends Model {
    // private int id;
    private String country;

    public Country(int id, String country) {
        super(id);
        // this.id = id;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
