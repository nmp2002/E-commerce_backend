package com.ttisv.service.system;

import com.ttisv.bean.system.TblCart;
import java.util.List;

public interface TblCartService {
    TblCart addToCart(Long userId, Long productId, Integer quantity);
    TblCart getCartByUserId(Long userId);
    List<TblCart> getAllCarts();
} 