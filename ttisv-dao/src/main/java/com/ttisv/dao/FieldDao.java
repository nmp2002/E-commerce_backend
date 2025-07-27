package com.ttisv.dao;
import com.ttisv.bean.Field;

public interface FieldDao extends BaseDao<Field> {
	Field findByFieldName(String fieldName);
	Field findById(Integer id);
	Field addField(Field field);
	boolean deleteField(Integer id);
	Field updateField(Field field);
}
