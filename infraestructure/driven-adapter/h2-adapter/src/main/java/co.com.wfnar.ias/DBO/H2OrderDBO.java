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
public class H2OrderDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<H2ProductDBO> products;

    private Double totalAmount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public static H2OrderDBO fromDomain(Order order) {

        H2OrderDBO orderDBO = new H2OrderDBO(
                order.getId(),
                order.getCustomerId(),
                null,
                order.getTotalAmount(),
                order.getStatus()
        );

        List<H2ProductDBO>  productsDbo = order.getProducts()
                .stream()
                .map(productDBO -> {
                    H2ProductDBO producto = H2ProductDBO.fromDomain(productDBO);
                    producto.setOrder(orderDBO);

                    return producto;
                })
                .toList();

        orderDBO.products = productsDbo;


        return orderDBO;
    }

    public static Order toDomain(H2OrderDBO orderDBO) {

        List<Product> products = orderDBO.getProducts().stream().map(H2ProductDBO::toDomain).toList();

        Order order = new Order(
                orderDBO.getId(),
                orderDBO.getCustomerId(),
                products
        );

        return  order;
    }
}
