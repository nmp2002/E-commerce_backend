package com.ttisv.service.system;

import com.ttisv.bean.system.TblCart;
import com.ttisv.bean.system.TblCartItem;
import com.ttisv.dao.system.TblCartDao;
import com.ttisv.dao.system.TblCartItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TblCartServiceImpl implements TblCartService {
    @Autowired
    private TblCartDao cartDao;
    @Autowired
    private TblCartItemDao cartItemDao;

    @Override
    public TblCart addToCart(Long userId, Long productId, Integer quantity) {
        TblCart cart = cartDao.findByUserId(userId);
        if (cart == null) {
            cart = new TblCart();
            cart.setUserId(userId);
            cart.setStatus(1L); // 1: active
            cart.setCreatedDate(new Date());
            cartDao.saveOrUpdateCart(cart);
        }
        TblCartItem item = cartItemDao.findByCartIdAndProductId(cart.getId(), productId);
        if (item == null) {
            item = new TblCartItem();
            item.setCartId(cart.getId());
            item.setProductId(productId);
            item.setQuantity(quantity);
            item.setPrice(0.0); // TODO: lấy giá sản phẩm
            item.setCreatedDate(new Date());
            cartItemDao.saveOrUpdateCartItem(item);
        } else {
            item.setQuantity(item.getQuantity() + quantity);
            item.setModifiedDate(new Date());
            cartItemDao.saveOrUpdateCartItem(item);
        }
        return cart;
    }

    @Override
    public TblCart getCartByUserId(Long userId) {
        return cartDao.findByUserId(userId);
    }

    @Override
    public List<TblCart> getAllCarts() {
        return cartDao.findAll();
    }
} 