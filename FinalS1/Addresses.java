public class Addresses extends Model {
    private String houseno;
    private String streetno;
    private String streetname;
    private String villagename;
    private String districtname;
    private String communename;
    private String provincename;
    private String cityname;
    private String countryname;
    private int iscurrent;

    public Addresses(int id, String houseno, String streetno, String streetname, String villagename,
            String districtname, String communename, String provincename, String cityname, String countryname,
            int iscurrent) {
        super(id);
        this.houseno = houseno;
        this.streetno = streetno;
        this.streetname = streetname;
        this.villagename = villagename;
        this.districtname = districtname;
        this.communename = communename;
        this.provincename = provincename;
        this.cityname = cityname;
        this.countryname = countryname;
        this.iscurrent = iscurrent;
    }

    public String getHouseno() {
        return houseno;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public String getStreetno() {
        return streetno;
    }

    public void setStreetno(String streetno) {
        this.streetno = streetno;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getVillagename() {
        return villagename;
    }

    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getCommunename() {
        return communename;
    }

    public void setCommunename(String communename) {
        this.communename = communename;
    }

    public String getProvincename() {
        return provincename;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public int getIscurrent() {
        return iscurrent;
    }

    public void setIscurrent(int iscurrent) {
        this.iscurrent = iscurrent;
    }

}
