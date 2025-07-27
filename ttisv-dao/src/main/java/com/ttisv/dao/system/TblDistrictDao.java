package com.ttisv.dao.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblDistrict;
import com.ttisv.dao.BaseDao;

public interface TblDistrictDao extends BaseDao<TblDistrict> {
	TblDistrict findByDistrictName(String districtName);
	public List<TblDistrict> getListDistrict(Long provinceid);
}
