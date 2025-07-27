package com.ttisv.springbootwildfly.controllers;

import com.ttisv.bean.system.TblCart;
import com.ttisv.bean.system.TblCartItem;
import com.ttisv.service.system.TblCartService;
import com.ttisv.service.system.TblCartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TblCartController {
    @Autowired
    private TblCartService cartService;
    @Autowired
    private TblCartItemService cartItemService;

    @PostMapping("/add")
    public TblCart addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
        return cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping("/user/{userId}")
    public TblCart getCartByUser(@PathVariable Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @GetMapping("/items/{cartId}")
    public List<TblCartItem> getCartItems(@PathVariable Long cartId) {
        return cartItemService.getCartItemsByCartId(cartId);
    }
} 