import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//import BlockClass.Book;

public class Category {
    Book b = new Book();
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void removeByISBNorTitle() {
        b.displayOutput();
        System.out.println("Remove book by ISBN or Title.");
        System.out.print("Enter a ISBN or Title of book:");
        String value_to_rv = sc.nextLine();
        int check = 0;
        Iterator<Book> itr = books.iterator();
        while (itr.hasNext()) {
            Book book = itr.next();
            if (value_to_rv.equals(b.getIsbn()) || value_to_rv.equals(b.getTitle())) {
                itr.remove();
                System.out.println("Removed successful.");
                check = 1;
            }
        }
        if (check == 0) {
            System.out.println("There isn't " + value_to_rv + " in category.");
        }
    }

    public static void main(String[] args) throws Exception {
        Book b = new Book();
        Category c = new Category();
        Scanner sc = new Scanner(System.in);
        int op;
        while (true) {
            System.out.println("1. Data input to create new category");
            System.out.println("2. Remove book in category by ISBN");
            System.out.println("3. List all books");
            System.out.println("4. Find book by ISBN or Title");
            System.out.println("5. Count book in this category");
            System.out.println("6. Exit");
            System.out.print("Choice a option: ");
            op = sc.nextInt();
            if (op == 1) {
                b.dataInput();
            } else if (op == 2) {
                c.removeByISBNorTitle();
            } else if (op == 3) {
                b.displayOutput();
            } else {
                break;
            }
        }
    }
}