package com.ttisv.dao.system;
import java.util.List;
import java.util.Map;
import com.ttisv.bean.system.TblWard;
import com.ttisv.dao.BaseDao;

public interface TblWardDao extends BaseDao<TblWard> {
	TblWard findByWardName(String wardName);
	public List<TblWard> getListWard(Long districtId);
}
