package co.com.wfnar.ias;

import co.com.wfnar.ias.DTO.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderEntryPoint {

    private OrderUseCase orderUseCase;

    @PostMapping
    public ResponseEntity<String> processOrder(@RequestBody OrderDTO orderDto){
        String message = orderUseCase.createOrder(OrderDTO.toDomain(orderDto));
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
}
