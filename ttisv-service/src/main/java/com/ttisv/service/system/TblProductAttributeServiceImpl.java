package com.ttisv.service.system;

import com.ttisv.bean.system.TblProductAttribute;
import com.ttisv.dao.system.TblProductAttributeDao;
import com.ttisv.service.system.TblProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TblProductAttributeServiceImpl implements TblProductAttributeService {

    @Autowired
    private TblProductAttributeDao tblProductAttributeDao;

    @Override
    public TblProductAttribute create(TblProductAttribute attribute) {
        attribute.setCreatedDate(new Date());
        tblProductAttributeDao.save(attribute);
        return attribute;
    }

    @Override
    public TblProductAttribute update(Long id, TblProductAttribute attribute) {
        TblProductAttribute existingAttribute = getById(id);
        if (existingAttribute != null) {
            existingAttribute.setAttributeName(attribute.getAttributeName());
            existingAttribute.setAttributeValue(attribute.getAttributeValue());
            existingAttribute.setModifiedDate(new Date());
            // Assuming modifiedby would be set from security context
            tblProductAttributeDao.update(existingAttribute);
            return existingAttribute;
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        TblProductAttribute attribute = getById(id);
        if (attribute != null) {
            tblProductAttributeDao.delete(attribute);
            return true;
        }
        return false;
    }

    @Override
    public TblProductAttribute getById(Long id) {
        return tblProductAttributeDao.get(id);
    }

    @Override
    public List<TblProductAttribute> getByProductId(Long productId) {
        return tblProductAttributeDao.findByProductId(productId);
    }

    @Override
    public List<TblProductAttribute> getAll() {
        return tblProductAttributeDao.find("FROM TblProductAttribute");
    }
} 