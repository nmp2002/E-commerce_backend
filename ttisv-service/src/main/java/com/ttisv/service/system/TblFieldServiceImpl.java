package com.ttisv.service.system;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ttisv.bean.system.TblField;
import com.ttisv.dao.system.TblFieldDao;
@Service
@Transactional
public class TblFieldServiceImpl implements TblFieldService{
	@Autowired
	TblFieldDao tblFieldDao;
	@Override
	public Page<TblField> getListPageField(Pageable pageable, Map<String, String> map) {
		return tblFieldDao.getListPageField(pageable, map);
	}

	@Override
	public TblField findByFieldName(String fieldName) {
		
		return tblFieldDao.findByFieldName(fieldName);
	}

	@Override
	public TblField findById(Long id) {
		
		return tblFieldDao.findById(id);
	}

	@Override
	public Boolean existsByFieldName(String fieldName) {
		
		return tblFieldDao.existsByFieldName(fieldName);
	}

	@Override
	public TblField saveorUpdate(TblField field) {
		
		
		return tblFieldDao.saveOrUpdate(field);
	}

	@Override
	public List<TblField> findbySupplierId(Long supplierId) {
		// TODO Auto-generated method stub
		return tblFieldDao.findbySupplierId(supplierId);
	}
    @Override
    public boolean existsById(Long fieldId) {
        return tblFieldDao.existsById(fieldId);
    }
    @Override
    public TblField updateStatusField(Long id, Long status) {
        try {
            TblField field = tblFieldDao.findById(id);
            if (field != null) {
                field.setStatus(2L);
                field.setModifiedDate(new Date());
                tblFieldDao.save(field);

            }
            return field;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

	@Override
	public long countActiveFields() {
		// TODO Auto-generated method stub
		return tblFieldDao.countActiveFields();
	}

	@Override
	public long countInactiveFields() {
		// TODO Auto-generated method stub
		return tblFieldDao.countInactiveFields();
	}

	@Override
	public Long countActiveSmallFields(Long fieldId) {
		// TODO Auto-generated method stub
		return tblFieldDao.countActiveSmallFields(fieldId);
	}

	@Override
	public Long countMaintenanceSmallFields(Long fieldId) {
		// TODO Auto-generated method stub
		return tblFieldDao.countMaintenanceSmallFields(fieldId);
	}

}
