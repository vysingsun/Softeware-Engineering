public class Publishers extends Model {
    private String publishername;
    private Addresses addresses;

    public Publishers(int id, String publishername, Addresses addresses) {
        super(id);
        this.publishername = publishername;
        this.addresses = addresses;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

}
