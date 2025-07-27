package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblCity;
import com.ttisv.dao.system.TblCityDao;

@Service
@Transactional
public class TblCityServiceImpl implements TblCityService {

	@Autowired
	TblCityDao tblCityDao;
	@Override
	public TblCity findByprovinceName(String provinceName) {
		// TODO Auto-generated method stub
		return tblCityDao.findByprovinceName(provinceName);
	}
	@Override
	public List<TblCity> getListCity(Map<String, String> map) {
		// TODO Auto-generated method stub
		return tblCityDao.getListCity(map);
	}
	@Override
	public TblCity getCitybyId(Long provinceid) {
		// TODO Auto-generated method stub
		return tblCityDao.getCitybyId(provinceid);
	}

}
