import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Inventories extends Model {
    private Books books;
    private int copies;
    private String srcurl;
    // private Time created_at;
    private Timestamp created_at;

    public Inventories(int id, Books books, int copies, String srcurl, Timestamp created_at) {
        super(id);
        this.books = books;
        this.copies = copies;
        this.srcurl = srcurl;
        // this.created_at = new Timestamp(new Date().getTime());
        this.created_at = created_at;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getSrcurl() {
        return srcurl;
    }

    public void setSrcurl(String srcurl) {
        this.srcurl = srcurl;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
