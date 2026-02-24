package co.com.wfnar.ias.DTO;

import co.com.wfnar.ias.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class ProductDTO {

    Long id;
    String productName;
    Double price;

    public static ProductDTO fromDomain(Product product){
        ProductDTO productDTO = new ProductDTO(
                product.getId(),
                product.getProductName(),
                product.getPrice()
        );

        return productDTO;
    }

    public static Product toDomain(ProductDTO productDTO){
        Product product = new Product(
                productDTO.getId(),
                productDTO.getProductName(),
                productDTO.getPrice()
        );
        return product;
    }


}
