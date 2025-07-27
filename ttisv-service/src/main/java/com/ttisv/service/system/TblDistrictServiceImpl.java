package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblDistrict;
import com.ttisv.dao.system.TblDistrictDao;
@Service
@Transactional
public class TblDistrictServiceImpl implements TblDistrictService {
	@Autowired
	TblDistrictDao tblDistrictDao;
	@Override
	public TblDistrict findByDistrictName(String districtName) {
		// TODO Auto-generated method stub
		return tblDistrictDao.findByDistrictName(districtName);
	}
	@Override
	 public List<TblDistrict> getListDistrict(Long provinceid) {
        return tblDistrictDao.getListDistrict(provinceid);
    }

}
