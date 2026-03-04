package co.com.wfnar.ias;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {

    @Test
    public void createdOrderTest(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", 2400000.00));
        products.add(new Product(2L, "Mouse", 100000.00));

        Order order = new Order(1L, "WF-01", products);

        Assertions.assertEquals(Status.CREATED, order.getStatus());
        Assertions.assertEquals(2500000.00, order.getTotalAmount());

    }
}
