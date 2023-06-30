public class Image extends Model {
    private Hotel hotel;
    private String imagePath;

    public Image(int id, Hotel hotel, String imagePath) {
        super(id);
        this.hotel = hotel;
        this.imagePath = imagePath;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        if (imagePath == null)
            this.imagePath = "";
        else
            this.imagePath = imagePath;
    }

}
