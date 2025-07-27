package com.ttisv.dao.system;

import com.ttisv.bean.system.TblCartItem;
import com.ttisv.dao.impl.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TblCartItemDaoImpl extends BaseDaoImpl<TblCartItem> implements TblCartItemDao {
    @Override
    public List<TblCartItem> findByCartId(Long cartId) {
        String hql = "FROM TblCartItem ci WHERE ci.cartId = :cartId";
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        return find(hql, params);
    }

    @Override
    public TblCartItem findByCartIdAndProductId(Long cartId, Long productId) {
        String hql = "FROM TblCartItem ci WHERE ci.cartId = :cartId AND ci.productId = :productId";
        Map<String, Object> params = new HashMap<>();
        params.put("cartId", cartId);
        params.put("productId", productId);
        List<TblCartItem> items = find(hql, params);
        return items.isEmpty() ? null : items.get(0);
    }

    @Override
    public TblCartItem saveOrUpdateCartItem(TblCartItem item) {
        saveOrUpdate(item);
        return item;
    }
} 