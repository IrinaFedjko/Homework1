package final_project;

import java.time.LocalDate;

public class DatabaseOfOrders {

    private String name;
    private int productsId;
    private LocalDate expiredDate;
    private double price;
    private int quantity;

    public DatabaseOfOrders(String name, int productId, LocalDate expiredDate, double price, int quantity) {
        this.name = name;
        this.productsId = productId;
        this.expiredDate = expiredDate;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductId() {
        return productsId;
    }

    public void setProductId(int productId) {
        this.productsId = productId;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", productId=" + productsId +
                ", expiredDate=" + expiredDate +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}