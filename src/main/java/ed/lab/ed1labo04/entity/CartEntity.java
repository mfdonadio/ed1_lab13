package ed.lab.ed1labo04.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;

    // @OneToMany: un carrito puede tener muchos items. CascadeType.ALL propaga automáticamente save/delete/update del carrito a sus items.
    //Decidi probarlo de una :D
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItems;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public List<CartItemEntity> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItemEntity> cartItems) { this.cartItems = cartItems; }
}
