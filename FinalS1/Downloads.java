
// import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Downloads extends Model {
    private Users users;
    private Books books;
    private Timestamp downloaded_at;

    public Downloads(int id, Users users, Books books, Timestamp downloaded_at) {
        super(id);
        this.users = users;
        this.books = books;
        this.downloaded_at = downloaded_at;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Timestamp getDownloaded_at() {
        return downloaded_at;
    }

    public void setDownloaded_at(Timestamp downloaded_at) {
        this.downloaded_at = downloaded_at;
    }

}
