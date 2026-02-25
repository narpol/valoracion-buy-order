package co.com.wfnar.ias;

import java.util.List;

public class Order {

    Long id;
    String customerId;
    List<Product> products;
    Double totalAmount;
    Status status;

    public Order(Long id, String customerId, List<Product> products) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.totalAmount = calculateTotalAmount(products);
        this.status = Status.CREATED;
    }

    private Double calculateTotalAmount(List<Product> products) {
        Double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();
        return totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
