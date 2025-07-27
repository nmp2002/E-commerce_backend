package com.ttisv.service.dm;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.dm.ObjCbb;
import com.ttisv.bean.dm.TblParam;

public interface TblParamsService {

	Page<TblParam> getListPageParam(Pageable pageable, Map<String, String> map);

	TblParam getParamById(Long id);

	TblParam getParamByCode(String paramcode);

	List<ObjCbb> getParamCbb(String paramgroup, String type);

	boolean existsByParamcode(String paramcode, Long id);

	void saveOrUpdate(TblParam o);

	void delete(Long id);

	List<TblParam> getParams();

}