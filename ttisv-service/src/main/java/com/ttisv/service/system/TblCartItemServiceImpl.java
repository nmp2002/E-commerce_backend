package com.ttisv.service.system;

import com.ttisv.bean.system.TblCartItem;
import com.ttisv.dao.system.TblCartItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TblCartItemServiceImpl implements TblCartItemService {
    @Autowired
    private TblCartItemDao cartItemDao;

    @Override
    public TblCartItem addOrUpdateCartItem(Long cartId, Long productId, Integer quantity) {
        TblCartItem item = cartItemDao.findByCartIdAndProductId(cartId, productId);
        if (item == null) {
            item = new TblCartItem();
            item.setCartId(cartId);
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
        return item;
    }

    @Override
    public List<TblCartItem> getCartItemsByCartId(Long cartId) {
        return cartItemDao.findByCartId(cartId);
    }
} 