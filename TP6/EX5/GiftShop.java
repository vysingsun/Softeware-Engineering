import java.util.Scanner;

public class GiftShop {
    public static void main(String[] args) {
        ListProduct listProduct = new ListProduct();
        Scanner sc = new Scanner(System.in);
        int option;

        String name;
        int num, amount_inStock;
        float price;
        int index, numIndex;
        while (true) {
            listProduct.readMenu();
            option = sc.nextInt();

            if (option == 1) {
                listProduct.displayProduct();
            } else if (option == 2) {
                System.out.println("2. Add a product");
                System.out.print("Enter a number of product: ");
                num = sc.nextInt();

                System.out.print("Enter a name of product: ");
                name = sc.next();
                System.out.print("Enter a price of product: ");
                price = sc.nextFloat();
                System.out.print("Enter a value of amount in stock of product: ");
                amount_inStock = sc.nextInt();
                Product product = new Product(num, name, price, amount_inStock);

                listProduct.addProduct(product);
            } else if (option == 3) {
                // System.out.println("3. Remove product from list by index");
                // System.out.print("Enter a index to remove product: ");
                // index = sc.nextInt();
                listProduct.removeProductByIndex();
            } else if (option == 4) {
                System.out.println("4. Update product in list");
                System.out.print("Enter a number of product to update: ");
                numIndex = sc.nextInt();
                listProduct.updateProductByNum(numIndex);
            } else if (option == 5) {
                break;
            }
        }
    }
}
