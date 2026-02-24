package co.com.wfnar.ias.DBO;

import co.com.wfnar.ias.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String productName;
    Double price;

    public static ProductDBO fromDomain(Product product){
        ProductDBO productDBO = new ProductDBO(
                product.getId(),
                product.getProductName(),
                product.getPrice()
        );

        return productDBO;
    }

    public static Product toDomain(ProductDBO productDBO){
        Product product = new Product(
                productDBO.getId(),
                productDBO.getProductName(),
                productDBO.getPrice()
        );
        return product;
    }

}
