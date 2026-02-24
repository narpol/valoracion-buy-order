package co.com.wfnar.ias;

import java.util.List;

public class Order {

    Long id;
    String customerId;
    List<Product> products;
    Double totalAmount;
    Status status;

    public Order(Long id, String customerId, List<Product> products, Double totalAmount, Status status) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.totalAmount = totalAmount;
        this.status = status;
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

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
