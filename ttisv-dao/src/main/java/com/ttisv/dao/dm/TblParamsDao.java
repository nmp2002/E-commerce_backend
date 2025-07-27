package com.ttisv.dao.dm;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.dm.ObjCbb;
import com.ttisv.bean.dm.TblParam;
import com.ttisv.dao.BaseDao;

public interface TblParamsDao extends BaseDao<TblParam> {

	Page<TblParam> getListPageParam(Pageable pageable, Map<String, String> map);

	TblParam getParamById(Long id);

	TblParam getParamByCode(String paramcode);

	List<ObjCbb> getParamCbb(String paramgroup, String type);

	List<TblParam> getParams();

	boolean existsByParamcode(String paramcode, Long id);

}