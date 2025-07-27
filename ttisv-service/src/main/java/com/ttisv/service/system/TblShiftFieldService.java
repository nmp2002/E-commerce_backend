package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ttisv.bean.system.TblShiftField;



public interface TblShiftFieldService {
	Page<TblShiftField> getListPageShiftField(Pageable pageable, Map<String, String> map);
	    public boolean deleteShiftField(Long shiftFieldId);
	    TblShiftField saveorUpdate(TblShiftField shiftfield);
	    List<TblShiftField> getShiftFieldsByFieldId(Long fieldId);
	    List<TblShiftField> getShiftFieldsByFieldType(Long fieldId,String fieldType);
	    TblShiftField findById(Long id);
		Boolean existingByShiftFieldName(Long shiftFieldName,Long fieldId);
		Boolean existingByTimeStart(String timeStart);
}
