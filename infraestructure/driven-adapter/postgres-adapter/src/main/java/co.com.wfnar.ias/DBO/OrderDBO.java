package co.com.wfnar.ias.DBO;

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
    List<Product> products;
    Double totalAmount;
    Status status;
}
