public class Hotel extends Model {
    private String hotel;
    private Country country;
    private City city;
    private short star;
    private double cost;
    private String info;

    public Hotel(int id, String hotel, Country country, City city, short star, double cost, String info) {
        super(id);
        this.hotel = hotel;
        this.country = country;
        this.city = city;
        this.star = star;
        this.cost = cost;
        this.info = info;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public short getStar() {
        return star;
    }

    public void setStar(short star) {
        if (star >= 0 && star <= 5) {
            this.star = star;
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
