import java.util.Scanner;

public class AllMenu {
    Scanner sc = new Scanner(System.in);

    // Hotel Listing
    public void HotelListing() {
        HotelORM orm = new HotelORM();
        CityORM ci_orm = new CityORM();

        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {

            System.out.println("\n\tHotel Listing");
            System.out.println("1. List all hotel in a city");
            System.out.println("2. Add a new hotel");
            System.out.println("3. View detail information of a hotel");
            System.out.println("4. Delete hotel by ID");
            System.out.println("5. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all hotel in a city");
                System.out.print("Enter a country name: ");
                String co = sc.nextLine();
                System.out.print("Enter a city name: ");
                String ci = sc.nextLine();
                String query = "SELECT * FROM hotels AS h INNER JOIN countries AS co ON h.countryid = co.id INNER JOIN cities AS ci ON h.cityid = ci.id WHERE country = '"
                        + co + "' AND city = '" + ci + "';";
                for (var h : orm.rawQueryList(query)) {
                    System.out.println("\nID: " + h.getId());
                    System.out.println("Hotel: " + h.getHotel());
                    System.out.println("CountryID: " + h.getCountry().getId());
                    System.out.println("CityID: " + h.getCity().getId());
                    System.out.println("Stars: " + h.getStar());
                    System.out.println("Cost: " + h.getCost());
                    System.out.println("Info: " + h.getInfo());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add a new hotel");

                System.out.print("Enter a country name: ");
                String co = sc.nextLine();

                System.out.print("Enter a city name: ");
                String ci = sc.nextLine();

                System.out.print("Enter a hotel name: ");
                String hotel = sc.nextLine();

                System.out.print("Enter a number of stars: ");
                int stars = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a cost: ");
                Double cost = sc.nextDouble();
                sc.nextLine();
                System.out.print("Enter a information: ");
                String info = sc.nextLine();

                for (var c1 : ci_orm.listAll()) {
                    if (ci.equals(c1.getCity())) {
                        Hotel h = new Hotel(0, hotel, c1.getCountry(), c1, (short) stars, cost, info);
                        orm.add(h);
                    }
                }
            } else if (op == 3) {
                System.out.println("\n3. View detail information of a hotel");
                for (var h : orm.listAll()) {
                    System.out.println("\nID: " + h.getId());
                    System.out.println("Hotel: " + h.getHotel());
                    System.out.println("CountryID: " + h.getCountry().getId());
                    System.out.println("CityID: " + h.getCity().getId());
                    System.out.println("Stars: " + h.getStar());
                    System.out.println("Cost: " + h.getCost());
                    System.out.println("Info: " + h.getInfo());
                }
            } else if (op == 4) {
                System.out.println("\n4. Delete hotel by ID");
                System.out.print("Enter a ID of hotel to detele: ");
                int id = sc.nextInt();
                sc.nextLine();
                orm.remove(id);
                System.out.println("The ID: " + id + " have been deleted.");
            } else {
                break;
            }
        }
    }

    // Country Listing
    public void CountryListing() {

        CountryORM orm = new CountryORM();

        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {

            System.out.println("\n\tCountry Listing");
            System.out.println("1. List all countries");
            System.out.println("2. Add new country");
            System.out.println("3. Delete country by ID");
            System.out.println("4. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all countries");
                for (var c2 : orm.listAll()) {
                    System.out.println("ID: " + c2.getId() + "; Name: " + c2.getCountry());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add new country");
                System.out.println("Enter a new country name: ");
                String counrty = sc.nextLine();
                Country c = new Country(0, counrty);
                orm.add(c);
                System.out.println("New added country id: " + c.getId());
            } else if (op == 3) {
                System.out.println("\n3. Delete country by ID");
                System.out.print("Enter a ID of country to detele: ");
                int id = sc.nextInt();
                sc.nextLine();
                orm.remove(id);
                System.out.println("The ID: " + id + " have been deleted.");
            } else {
                break;
            }
        }
    }

    // City Listing
    public void CityListing() {
        CityORM orm = new CityORM();
        CountryORM c_orm = new CountryORM();

        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {

            System.out.println("\n\tCity Listing");
            System.out.println("1. List all cities");
            System.out.println("2. Add new city");
            System.out.println("3. Delete city by ID");
            System.out.println("4. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all cities in a country");
                System.out.print("Enter a country name: ");
                String country = sc.nextLine();
                String query = "SELECT * FROM cities AS ct JOIN countries AS c ON ct.countryid = c.id WHERE country = '"
                        + country + "';";
                System.out.println("\nList all cities in a country");
                for (var ct : orm.rawQueryList(query)) {
                    System.out
                            .println("ID: " + ct.getId() + "; City: " + ct.getCity() + "; countryid: " +
                                    ct.getCountry().getId()
                                    + "; UCity: " + ct.getUcity());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add new city");
                System.out.print("Enter a country name: ");
                String co = sc.nextLine();

                System.out.print("Enter a city name: ");
                String ci = sc.nextLine();

                for (var ct : c_orm.listAll()) {
                    if (co.equals(ct.getCountry())) {
                        City city = new City(0, ci, ct);
                        orm.add(city);
                    }
                }
            } else if (op == 3) {
                System.out.println("\n3. Delete city by ID");
                System.out.print("Enter a ID of city to detele: ");
                int id = sc.nextInt();
                sc.nextLine();
                orm.remove(id);
                System.out.println("The ID: " + id + " have been deleted.");
            } else {
                break;
            }
        }
    }

    // Image Listing
    public void ImageListing() {
        ImagesORM orm = new ImagesORM();
        HotelORM hotelORM = new HotelORM();

        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {

            System.out.println("\n\tImage Listing");
            System.out.println("1. List all image");
            System.out.println("2. Add new image");
            System.out.println("3. Delete image by ID");
            System.out.println("4. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all image");
                System.out.print("Enter a country name: ");
                String co = sc.nextLine();

                System.out.print("Enter a city name: ");
                String ci = sc.nextLine();

                System.out.print("Enter a hotel name: ");
                String hotel = sc.nextLine();

                String query = " SELECT i.* " +
                        " FROM images AS i " +
                        " INNER JOIN hotels AS h ON i.hotelid = h.id " +
                        " INNER JOIN countries AS co ON h.countryid = co.id " +
                        " INNER JOIN cities AS ci ON h.cityid = ci.id " +
                        " WHERE country = '" + co + "' AND city = '" + ci + "' AND hotels = '" + hotel + "' ; ";
                for (var i : orm.rawQueryList(query)) {
                    System.out.println("\nID: " + i.getId());
                    System.out.println("Hotel ID: " + i.getHotel().getId());
                    System.out.println("Image Path: " + i.getImagePath());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add new image");
                System.out.print("Enter a country name: ");
                String co = sc.nextLine();

                System.out.print("Enter a city name: ");
                String ci = sc.nextLine();

                System.out.print("Enter a hotel name: ");
                String hotel = sc.nextLine();

                System.out.print("Enter a image path: ");
                String imagepath = sc.nextLine();

                for (var i : hotelORM.listAll()) {
                    if (hotel.equals(i.getHotel())) {
                        Image image = new Image(0, i, imagepath);
                        orm.add(image);
                    }
                }
            } else if (op == 3) {
                System.out.println("\n3. Delete image by ID");
                System.out.print("Enter a ID of image to detele: ");
                int id = sc.nextInt();
                sc.nextLine();
                orm.remove(id);
                System.out.println("The ID: " + id + " have been deleted.");
            } else {
                break;
            }
        }
    }

    // Role Listing
    public void RoleListing() {
        RoleORM roleORM = new RoleORM();

        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();

        while (true) {

            System.out.println("\n\tRole Listing");
            System.out.println("1. List all Roles");
            System.out.println("2. Add new role");
            System.out.println("3. Update role by ID");
            System.out.println("4. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all Roles");
                for (var r1 : roleORM.listAll()) {
                    System.out.println("ID: " + r1.getId() + "; Role: " + r1.getRole());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add new role");
                System.out.print("Enter a role: ");
                String role = sc.nextLine();
                Role r = new Role(0, role);
                roleORM.add(r);
            } else if (op == 3) {
                System.out.println("\n3. Update role by ID");
                System.out.print("Enter a ID of role to update: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a new role: ");
                String role = sc.nextLine();
                Role r = new Role(id, role);
                roleORM.update(r);
                System.out.println("The ID: " + id + " have been updated to " + role);
            } else {
                break;
            }
        }
    }

    // Users Listing
    public void UsersListing() {
        UserORM userORM = new UserORM();
        RoleORM roleORM = new RoleORM();
        // code clears the screen or console
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (true) {

            System.out.println("\n\tUsers Listing");
            System.out.println("1. List all users");
            System.out.println("2. Add new users");
            System.out.println("3. Delete users by ID");
            System.out.println("4. Exit");
            System.out.print("Enter a number of option: ");
            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("\n1. List all users");
                for (var u1 : userORM.listAll()) {
                    System.out.println("\nID: " + u1.getId());
                    System.out.println("Username: " + u1.getUsername());
                    System.out.println("Password: " + u1.getPass());
                    System.out.println("Eamil: " + u1.getEmail());
                    System.out.println("RoleID: " + u1.getRole().getId());
                    System.out.println("Discount: " + u1.getDiscount() + " %");
                    System.out.println("Avatar: " + u1.getAvatar());
                }
            } else if (op == 2) {
                System.out.println("\n2. Add new users");
                System.out.print("Choose a role(Admin or Customer): ");
                String role = sc.nextLine();
                System.out.print("Enter a username: ");
                String username = sc.nextLine();
                System.out.print("Enter a password: ");
                String pwd = sc.nextLine();
                System.out.print("Enter a email: ");
                String email = sc.nextLine();

                System.out.print("Enter a discount: ");
                int dis = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter a avatar: ");
                String avatar = sc.nextLine();

                for (var r1 : roleORM.listAll()) {
                    if (role.equals(r1.getRole())) {
                        User user = new User(0, username, pwd, email, r1, (short) dis, avatar);
                        userORM.add(user);
                    }
                }
            } else if (op == 3) {
                System.out.println("\n3. Delete user by ID");
                System.out.print("Enter a ID of user to detele: ");
                int id = sc.nextInt();
                sc.nextLine();
                userORM.remove(id);
                System.out.println("The ID: " + id + " have been deleted.");
            } else {
                // code clears the screen or console
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            }
        }
    }
}
