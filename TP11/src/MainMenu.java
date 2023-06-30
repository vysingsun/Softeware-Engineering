import java.util.Scanner;

public class MainMenu extends AllMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AllMenu allMenu = new AllMenu();

        while (true) {

            // code clears the screen or console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("""
                    \tMain Menu
                    1. Hotel listing
                    2. Country listing
                    3. City listing
                    4. Image listing
                    5. Role listing
                    6. Users listing
                    7. Exit app
                        """);
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                allMenu.HotelListing();
            } else if (op == 2) {
                allMenu.CountryListing();
            } else if (op == 3) {
                allMenu.CityListing();
            } else if (op == 4) {
                allMenu.ImageListing();
            } else if (op == 5) {
                allMenu.RoleListing();
            } else if (op == 6) {
                allMenu.UsersListing();
            } else {
                break;
            }
        }
    }
}
