package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.TblFieldType;

public interface TblFieldTypeService {
	TblFieldType saveorUpdate(Long fieldId,String fieldTypeName,Long totalNumberField);
	List<TblFieldType> findbyFieldId(Long fieldId);
	TblFieldType findByFieldIdAndTypeName(Long fieldId,String fieldTypeName);
}
