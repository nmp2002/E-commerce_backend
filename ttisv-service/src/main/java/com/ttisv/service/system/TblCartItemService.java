package com.ttisv.service.system;

import com.ttisv.bean.system.TblCartItem;
import java.util.List;

public interface TblCartItemService {
    TblCartItem addOrUpdateCartItem(Long cartId, Long productId, Integer quantity);
    List<TblCartItem> getCartItemsByCartId(Long cartId);
} 