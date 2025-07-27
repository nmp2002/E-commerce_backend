package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblCity;
import com.ttisv.dao.BaseDao;

public interface TblCityDao extends BaseDao<TblCity> {
	TblCity findByprovinceName(String provinceName);
	public List<TblCity> getListCity(Map<String, String> map);
	 TblCity getCitybyId(Long provinceid);
}
