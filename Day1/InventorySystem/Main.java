package Day1.InventorySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, List<Product>> products = new HashMap<>();

    private static void addProduct(String category, Scanner sc) {

        System.out.println("Enter name of product: ");
        String name = sc.nextLine();
        System.out.println("Enter id: ");
        int id = sc.nextInt();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();

        // initialize the product 
        Product product = new Product(name, id, price);

        // if category not exists in the map 
        if (!products.containsKey(category)) {
            products.put(category, new ArrayList<>());
        }

            
        products.get(category).add(product);

    }

    private static void displayAllProducts(String category) {

        // exception case 
        if (!products.containsKey(category)) {
            System.out.println("Category Not found");
            return;
        }

        System.out.println("No. of products in that category");
        System.out.println(products.get(category).size());

        String maxProduct = "";
        double maxPrice = -1e9;

        for (Product product : products.get(category)) {
            System.out.println(product.id + " " + product.name + " " + product.price);
            if (product.price > maxPrice) {
                maxPrice = product.price;
                maxProduct = product.name;
            }
        }

        System.out.println("Product with highest price is");
        System.out.println(maxProduct);
    }

    private static void displayProductsInDescendingOrder(String category) {
        // exception case 
        if (!products.containsKey(category)) {
            System.out.println("Category Not found");
            return;
        }
        List<List<Product>> productList = new ArrayList<>(products.values());

        for (List<Product> innerList : productList) {
            innerList.sort((p1, p2) -> Double.compare(p2.price, p1.price));
        }

        for (List<Product> innerList : productList) {
            for (Product p : innerList) {
                System.out.println(p.name + " - " + p.price);
            }
        }
    }

    private static void categoryWithHighestPrice() {
        String maxCategory = "";
        double maxPrice = -1e9;

        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {

            for (Product p : products.get(entry.getKey())) {
                if (p.price > maxPrice) {
                    maxPrice = p.price;
                    maxCategory = entry.getKey();
                }
            }
        }

        System.out.println("Category that has product with highest price is: "+maxCategory);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("1 - Store Products\n 2 - Retrieve Products");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter the category");
                String category = sc.nextLine();
                addProduct(category, sc);
            }

            else if (ch == 2) {
                System.out.println("You have 3 choices");
                System.out.println("1. Enter the category to retrieve all products");
                System.out.println("2. Display products based on price in descending order");
                System.out.println("3. Find category that has product with highest price ");

                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println(("Enter category: "));
                    String category = sc.next();
                    displayAllProducts(category);
                }
                else if (choice == 2) {
                    System.out.println(("Enter category: "));
                    String category = sc.next();
                    displayProductsInDescendingOrder(category);
                }
                else {
                    categoryWithHighestPrice();
                }
            }
            else {
                sc.close();
                System.exit(0);
            }
        }
        


    }
}
