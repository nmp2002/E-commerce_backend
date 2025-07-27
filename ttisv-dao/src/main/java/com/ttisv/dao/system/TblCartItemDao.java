package com.ttisv.dao.system;

import java.util.List;

import com.ttisv.bean.system.TblCart;
import com.ttisv.bean.system.TblCartItem;
import com.ttisv.dao.BaseDao;

public interface TblCartItemDao extends BaseDao<TblCartItem> {
	List<TblCartItem> findByCartId(Long cartId);
	TblCartItem findByCartIdAndProductId(Long cartId, Long productId);
	TblCartItem saveOrUpdateCartItem(TblCartItem item);
}
