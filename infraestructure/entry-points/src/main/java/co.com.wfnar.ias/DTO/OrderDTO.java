package co.com.wfnar.ias.DTO;

import co.com.wfnar.ias.Order;
import co.com.wfnar.ias.Product;
import co.com.wfnar.ias.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class OrderDTO {

    Long id;
    String customerId;
    List<ProductDTO> products;
    Double totalAmount;
    Status status;

    public static OrderDTO fromDomain(Order order) {
        List<ProductDTO>  productsDto = order.getProducts().stream().map(ProductDTO::fromDomain).toList();

        OrderDTO orderDTO = new OrderDTO(
                order.getId(),
                order.getCustomerId(),
                productsDto,
                order.getTotalAmount(),
                order.getStatus()
                );

        return orderDTO;
    }

    public static Order toDomain(OrderDTO orderDTO) {

        List<Product> products = orderDTO.getProducts().stream().map(ProductDTO::toDomain).toList();

        Order order = new Order(
                orderDTO.getId(),
                orderDTO.getCustomerId(),
                products,
                orderDTO.totalAmount,
                orderDTO.getStatus()
        );

        return  order;
    }
}
