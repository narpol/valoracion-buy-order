package co.com.wfnar.ias;

import co.com.wfnar.ias.DTO.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderEntryPoint {

    private final OrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<OrderDTO> processOrder(@RequestBody OrderDTO orderDto){
        Order order = orderUseCase.createOrder(OrderDTO.toDomain(orderDto));
        OrderDTO dto = OrderDTO.fromDomain(order);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        Order order = orderUseCase.getOrderById(id);
        OrderDTO dto = OrderDTO.fromDomain(order);

        return new ResponseEntity<>(dto, HttpStatus.FOUND);
    }

    @PutMapping("/{id}/confrim")
    public ResponseEntity<OrderDTO> confirmOrder(@PathVariable Long id){
        Order order = orderUseCase.cancelOrder(id);
        OrderDTO dto = OrderDTO.fromDomain(order);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<OrderDTO> cancelOrder(@PathVariable Long id){
        Order order = orderUseCase.cancelOrder(id);
        OrderDTO dto = OrderDTO.fromDomain(order);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
