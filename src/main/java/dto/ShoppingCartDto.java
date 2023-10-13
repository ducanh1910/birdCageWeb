package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Customer;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
    private Long id;
    private double totalPrice;
    private int totalItems;

    private Customer customer;
    private Set<CartItemDto> cartItems;

}
