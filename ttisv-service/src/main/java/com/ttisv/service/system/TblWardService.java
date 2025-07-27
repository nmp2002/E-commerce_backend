package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import com.ttisv.bean.system.TblWard;

public interface TblWardService {
	TblWard findByWardName(String wardName);
	public List<TblWard> getListWard(Long districtId);
}
