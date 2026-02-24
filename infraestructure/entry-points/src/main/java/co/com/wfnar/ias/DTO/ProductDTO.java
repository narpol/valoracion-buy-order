package co.com.wfnar.ias.DTO;

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


}
