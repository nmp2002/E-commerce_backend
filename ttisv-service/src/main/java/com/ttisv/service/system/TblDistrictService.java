package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblDistrict;

public interface TblDistrictService {
	TblDistrict findByDistrictName(String districtName);
	public List<TblDistrict> getListDistrict(Long provinceid);
}
