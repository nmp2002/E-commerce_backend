package com.ttisv.service.dm;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.dm.ObjCbb;
import com.ttisv.bean.dm.TblParam;
import com.ttisv.dao.dm.TblParamsDao;

@Service
@Transactional
public class TblParamsServiceImpl implements TblParamsService {
	@Autowired
	TblParamsDao tblParamsDao;

	@Override
	public Page<TblParam> getListPageParam(Pageable pageable, Map<String, String> map) {
		return tblParamsDao.getListPageParam(pageable, map);
	}

	@Override
	public TblParam getParamById(Long id) {
		return tblParamsDao.getParamById(id);
	}

	@Override
	public TblParam getParamByCode(String paramcode) {
		return tblParamsDao.getParamByCode(paramcode);
	}

	@Override
	public List<ObjCbb> getParamCbb(String paramgroup, String type) {
		return tblParamsDao.getParamCbb(paramgroup, type);
	}

	@Override
	public void saveOrUpdate(TblParam o) {
		// TODO Auto-generated method stub
		tblParamsDao.saveOrUpdate(o);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tblParamsDao.delete(id);
	}

	@Override
	public List<TblParam> getParams() {
		// TODO Auto-generated method stub
		return tblParamsDao.getParams();
	}

	@Override
	public boolean existsByParamcode(String paramcode, Long id) {
		// TODO Auto-generated method stub
		return tblParamsDao.existsByParamcode(paramcode, id);
	}
}
