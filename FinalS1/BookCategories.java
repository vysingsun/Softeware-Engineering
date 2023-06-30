public class BookCategories extends Model {
    private Categories categories;

    public BookCategories(int id, Categories categories) {
        super(id);
        this.categories = categories;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

}
