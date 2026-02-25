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
@Table(name = "order")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String customerId;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    List<ProductDBO> products;
    Double totalAmount;
    Status status;

    public static OrderDBO fromDomain(Order order) {
        List<ProductDBO>  productsDto = order.getProducts().stream().map(ProductDBO::fromDomain).toList();

        OrderDBO orderDTO = new OrderDBO(
                order.getId(),
                order.getCustomerId(),
                productsDto,
                order.getTotalAmount(),
                order.getStatus()
        );

        return orderDTO;
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
