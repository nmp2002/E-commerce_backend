package com.ttisv.service.system;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblShiftField;
import com.ttisv.dao.system.TblShiftFieldDao;

@Service
@Transactional
public class TblShiftFieldServiceImpl implements TblShiftFieldService {

    @Autowired
    TblShiftFieldDao tblShiftFieldDao;

    @Override
    public Page<TblShiftField> getListPageShiftField(Pageable pageable, Map<String, String> map) {
        return tblShiftFieldDao.getListPageShiftField(pageable, map);
    }

    @Override
    public boolean deleteShiftField(Long shiftFieldId) {
        return tblShiftFieldDao.deleteShiftField(shiftFieldId);
    }

	@Override
	public TblShiftField saveorUpdate(TblShiftField shiftfield) {
		
		return tblShiftFieldDao.saveorUpdate(shiftfield);
	}

	@Override
	public List<TblShiftField> getShiftFieldsByFieldId(Long fieldId) {
		// TODO Auto-generated method stub
		return tblShiftFieldDao.getShiftFieldsByFieldId(fieldId);
	}

	@Override
	public List<TblShiftField> getShiftFieldsByFieldType(Long fieldId, String fieldType) {
		// TODO Auto-generated method stub
		return tblShiftFieldDao.getShiftFieldsByFieldType(fieldId, fieldType);
	}

	@Override
	public TblShiftField findById(Long id) {
		// TODO Auto-generated method stub
		return tblShiftFieldDao.findById(id);
	}

	@Override
	public Boolean existingByShiftFieldName(Long shiftFieldName,Long fieldId) {
		// TODO Auto-generated method stub
		return tblShiftFieldDao.existingByShiftFieldName(shiftFieldName,fieldId);
	}

	@Override
	public Boolean existingByTimeStart(String timeStart) {
		// TODO Auto-generated method stub
		return null;
	}
}
