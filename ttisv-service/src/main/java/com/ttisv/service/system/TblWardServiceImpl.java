package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblWard;
import com.ttisv.dao.system.TblWardDao;

@Service
@Transactional
public class TblWardServiceImpl implements TblWardService {
	
	@Autowired
	TblWardDao tblWardDao;
	@Override
	public TblWard findByWardName(String wardName) {
		// TODO Auto-generated method stub
		return tblWardDao.findByWardName(wardName);
	}
	@Override
	public List<TblWard> getListWard(Long districtId) {
		// TODO Auto-generated method stub
		return tblWardDao.getListWard(districtId);
	}
	
}
