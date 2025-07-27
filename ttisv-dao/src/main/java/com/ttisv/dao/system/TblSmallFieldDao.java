package com.ttisv.dao.system;

import java.util.List;

import com.ttisv.bean.system.TblSmallField;
import com.ttisv.dao.BaseDao;

public interface TblSmallFieldDao extends BaseDao<TblSmallField>{
	TblSmallField createSmallField(Long fieldId, String smallFieldName, Long fieldTypeId,String fieldType);
	public  List<TblSmallField> getSmallFieldsByFieldId(Long fieldId);
	TblSmallField findByFieldIdAndSmallFieldName(Long fieldId, String smallFieldName,String fieldType);
	 public List<TblSmallField> getSmallFieldsByFieldTypeId(Long fieldId, Long fieldTypeId);
	 TblSmallField findSmallFieldById(Long id);
}
