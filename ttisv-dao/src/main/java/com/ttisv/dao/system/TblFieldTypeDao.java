package com.ttisv.dao.system;

import java.util.List;

import com.ttisv.bean.system.TblFieldType;
import com.ttisv.dao.BaseDao;
public interface TblFieldTypeDao extends BaseDao<TblFieldType> {
	TblFieldType saveorUpdate(Long fieldId,String fieldTypeName,Long totalNumberField);
	TblFieldType findByFieldIdAndTypeName(Long fieldId,String fieldTypeName);
	List<TblFieldType> findbyFieldId(Long fieldId);
	
}
