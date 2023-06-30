import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListProduct {
    ArrayList<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ArrayList<Product> getListProduct() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("The product has been added.");
    }

    public void displayProduct() {
        int i = 0;
        if (getListProduct().isEmpty()) {
            System.out.println("\nThere is no any product.Please add some products.");
        } else {
            System.out.println("\nIndex\tNumber\tName\tPrice\tAmount in stock");
            for (Product product : getListProduct()) {
                System.out.println((i + 1) + "\t" + product.getNum() + "\t" + product.getName() + "\t"
                        + product.getPrice() + "\t" + product.getAmount_inStock());
                i++;
            }
        }
    }

    public void removeProductByIndex() {
        int i = 0;
        System.out.print("Enter a value of index to remove: ");
        int index = sc.nextInt();
        index = index - 1;
        products.remove(index);
        System.out.println("The product has been remove.");
        // Iterator<Product> itr = products.iterator();
        // while (itr.hasNext()) {
        // Product product = itr.next();
        // if (i == indexOf) {
        // itr.remove();
        // System.out.println(product.getName() + " has been removed");
        // }
        // }
    }

    public void updateProductByNum(int numIndex) {
        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product product = itr.next();
            if (numIndex == product.getNum()) {
                System.out.print("Enter a new name of product: ");
                String newName = sc.nextLine();
                newName = sc.nextLine();
                System.out.print("Enter a new price of product: ");
                float newPrice = sc.nextFloat();
                System.out.print("Enter a new amount in stock of product: ");
                int newAmount_inStock = sc.nextInt();
                product.setName(newName);
                product.setPrice(newPrice);
                product.setAmount_inStock(newAmount_inStock);
                System.out.println("Update successfully.");
            }
        }
    }

    public void readMenu() {
        System.out.println("1. List all products in shop with product number, name, price, and amount in stock\n"
                + "2. Add new product to the list\n3.Remove product from list by index\n"
                + "4.Update product in list\n5.Exit program");
        System.out.print("Enter your option: ");
    }
}
