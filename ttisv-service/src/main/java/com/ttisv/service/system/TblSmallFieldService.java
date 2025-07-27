package com.ttisv.service.system;

import java.util.List;

import com.ttisv.bean.system.TblSmallField;

public interface TblSmallFieldService {
	TblSmallField createSmallField(Long fieldId, String smallFieldName, Long fieldTypeId,String fieldType);
	 List<TblSmallField> getSmallFieldsByFieldId(Long fieldId);
	 public List<TblSmallField> getSmallFieldsByFieldTypeId(Long fieldId, Long fieldTypeId);
	 TblSmallField updateStatusSmallField(Long id,Long active);
	 TblSmallField findSmallFieldById(Long id);
}
