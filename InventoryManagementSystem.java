import java.util.ArrayList;

public class InventoryManagementSystem {
    private ArrayList<Product> products;

    public InventoryManagementSystem() {
        products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        if (product != null) {
            products.add(product);
        }
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductsInStock() {
        ArrayList<Product> inStock = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getStockQuantity() > 0) {
                inStock.add(product);
            }
        }
        return inStock;
    }

    public void updateProductPrice(String name, double newPrice) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setPrice(newPrice);
            }
        }
    }

    public void removeProduct(String name) {
        Product productToRemove = null;
        for (Product product : products) {
            if (product.getName().equals(name)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            products.remove(productToRemove);
        }
    }

    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (Product product : products) {
            totalValue += product.getPrice() * product.getStockQuantity();
        }
        return totalValue;
    }

    public void printProducts() {
        System.out.println("Inventory Products:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice() + ", Stock: " +
                    product.getStockQuantity());
        }
    }
}
