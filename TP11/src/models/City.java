
public class City extends Model {
    // private int id;
    private String city;
    private Country country;
    private String ucity;

    public City(int id, String city, Country country) {
        super(id);
        setCity(city);
        setCountry(country);
        // this.city = city;
        // this.country = country;
        // this.ucity = ucity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
        this.ucity = city + "_";
        if (this.country != null) {
            this.ucity += country.getId();
        }
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
        this.ucity = city + "_";
        if (this.country != null) {
            this.ucity += country.getId();
        }
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
        this.ucity = city + "_";
        if (this.country != null) {
            this.ucity += country.getId();
        }
    }

}