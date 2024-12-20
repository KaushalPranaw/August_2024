package DesignPatterns.Structural.Composite;

public class TestCompositeDesign {
    public static void main(String[] args) {
        // Create individual products
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Headphones", 200);
        Product product3 = new Product("Mouse", 50);

        // Create a box and add products to it
        Box smallBox = new Box(10); // 10 is the packaging cost
        smallBox.addItem(product1);
        smallBox.addItem(product2);

        // Create another box and add a product and a smaller box to it
        Box bigBox = new Box(20); // 20 is the packaging cost
        bigBox.addItem(smallBox); // Adding the small box
        bigBox.addItem(product3); // Adding a standalone product

        // Calculate the total price
        System.out.println("Total price of the big box: $" + bigBox.getPrice());
    }
}
