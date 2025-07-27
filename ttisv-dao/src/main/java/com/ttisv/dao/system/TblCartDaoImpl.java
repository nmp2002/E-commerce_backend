package com.ttisv.dao.system;

import com.ttisv.bean.system.TblCart;
import com.ttisv.dao.impl.BaseDaoImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TblCartDaoImpl extends BaseDaoImpl<TblCart> implements TblCartDao {
	@Override
	public TblCart findByUserId(Long userId) {
	    String hql = "FROM TblCart c WHERE c.userId = :userId AND c.status = 1";
	    Map<String, Object> params = new HashMap<>();
	    params.put("userId", userId);
	    List<TblCart> carts = find(hql, params);
	    if (carts.isEmpty()) {
	        // Nếu chưa có cart, tạo mới
	        TblCart newCart = new TblCart();
	        newCart.setUserId(userId);
	        newCart.setStatus(1L); // hoặc status mặc định
	        newCart.setCreatedDate(new Date());
	        // set các trường khác nếu cần
	        save(newCart); // hoặc cartRepository.save(newCart)
	        return newCart;
	    } else {
	        return carts.get(0);
	    }
	}
    @Override
    public TblCart saveOrUpdateCart(TblCart cart) {
        saveOrUpdate(cart);
        return cart;
    }

    @Override
    public List<TblCart> findAll() {
        String hql = "FROM TblCart";
        return find(hql);
    }
} 