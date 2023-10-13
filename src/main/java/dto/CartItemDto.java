package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private int quantity;
    private double unitPrice;

    private ShoppingCartDto shoppingCart;
    private ProductDto product;
}
