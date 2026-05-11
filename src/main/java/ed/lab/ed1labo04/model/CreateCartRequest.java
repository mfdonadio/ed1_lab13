package ed.lab.ed1labo04.model;

import java.util.List;

public class CreateCartRequest {
    private List<CartItemsRequest> cartItems;

    public List<CartItemsRequest> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItemsRequest> cartItems) { this.cartItems = cartItems; }
}
