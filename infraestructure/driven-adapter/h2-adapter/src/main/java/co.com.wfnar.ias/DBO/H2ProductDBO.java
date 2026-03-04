package co.com.wfnar.ias.DBO;

import co.com.wfnar.ias.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class H2ProductDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private H2OrderDBO order;

    public static H2ProductDBO fromDomain(Product product){
        H2ProductDBO productDBO = new H2ProductDBO(
                product.getId(),
                product.getProductName(),
                product.getPrice(),
                null
        );

        return productDBO;
    }

    public static Product toDomain(H2ProductDBO productDBO){
        Product product = new Product(
                productDBO.getId(),
                productDBO.getProductName(),
                productDBO.getPrice()
        );
        return product;
    }

}
