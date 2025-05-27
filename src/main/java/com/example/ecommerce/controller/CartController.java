package com.example.ecommerce.controller;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepo;

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartRepo.findById(cartId).orElse(null);
    }

    // ✅ Always create a new cart instead of using incoming one
    @PostMapping
    public Cart createCart() {
        return cartRepo.save(new Cart());
    }

    @PutMapping("/{cartId}/add-item")
    public Cart addItemToCart(@PathVariable Long cartId, @RequestBody CartItem cartItem) {
        Cart cart = cartRepo.findById(cartId).orElse(null);
        if (cart != null) {
            cart.addItem(cartItem);
            return cartRepo.save(cart);
        }
        return null;
    }
}