package co.com.wfnar.ias.DBO;

import co.com.wfnar.ias.Order;
import co.com.wfnar.ias.Product;
import co.com.wfnar.ias.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductDBO> products;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static OrderDBO fromDomain(Order order) {

        OrderDBO orderDBO = new OrderDBO(
                order.getId(),
                order.getCustomerId(),
                null,
                order.getTotalAmount(),
                order.getStatus()
        );

        List<ProductDBO>  productsDbo = order.getProducts()
                .stream()
                .map(productDBO -> {
                    ProductDBO producto = ProductDBO.fromDomain(productDBO);
                    producto.setOrder(orderDBO);

                    return producto;
                })
                .toList();

        orderDBO.products = productsDbo;


        return orderDBO;
    }

    public static Order toDomain(OrderDBO orderDBO) {

        List<Product> products = orderDBO.getProducts().stream().map(ProductDBO::toDomain).toList();

        Order order = new Order(
                orderDBO.getId(),
                orderDBO.getCustomerId(),
                products
        );

        return  order;
    }
}
