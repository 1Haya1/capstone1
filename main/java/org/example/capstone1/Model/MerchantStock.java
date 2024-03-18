package org.example.capstone1.Model;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {

    @NotNull(message = "must be not empty")
    private Integer id;

    @NotNull(message = "Product ID must not be empty")
    private Integer productId;

    @NotNull(message = "Merchant ID must not be empty")
    private Integer merchantId;

   @NotNull(message = "must be not empty")
    @Size(min = 11, message = "have to be more than 10 at start")
    private Integer stock;

}
