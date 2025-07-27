package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblCity;

public interface TblCityService {
	TblCity findByprovinceName(String provinceName);
	public List<TblCity> getListCity(Map<String, String> map);
	 TblCity getCitybyId(Long provinceid);
}
