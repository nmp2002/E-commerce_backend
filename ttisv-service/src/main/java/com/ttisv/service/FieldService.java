package com.ttisv.service;

import javax.validation.Valid;

import com.ttisv.bean.Field;

public interface FieldService {
	Field findByFieldName(String fieldName);
	Field findById(Integer id);
	Field addField(Field field);
	Field updateField(Field field);
}
