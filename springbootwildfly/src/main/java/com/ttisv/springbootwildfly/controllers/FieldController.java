package com.ttisv.springbootwildfly.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblCity;
import com.ttisv.bean.system.TblDistrict;
import com.ttisv.bean.system.TblField;
import com.ttisv.bean.system.TblFieldType;
import com.ttisv.bean.system.TblSmallField;
import com.ttisv.bean.system.TblSupplier;
import com.ttisv.bean.system.TblUser;
import com.ttisv.bean.system.TblWard;
import com.ttisv.common.utils.StringUtils;
import com.ttisv.service.system.TblCityService;
import com.ttisv.service.system.TblDistrictService;
import com.ttisv.service.system.TblFieldService;
import com.ttisv.service.system.TblFieldTypeService;
import com.ttisv.service.system.TblSmallFieldService;
import com.ttisv.service.system.TblSupplierService;
import com.ttisv.service.system.TblWardService;
import com.ttisv.springbootwildfly.common.Constants;
import com.ttisv.springbootwildfly.payload.request.FieldRequest;
import com.ttisv.springbootwildfly.payload.request.FieldTypeRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;
import com.ttisv.springbootwildfly.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/fields")
public class FieldController extends BaseController {

    @Autowired
    TblFieldService fieldService;
    @Autowired 
    TblCityService	cityService;
    @Autowired 
    TblDistrictService	districtService;
    @Autowired
    TblWardService wardService;
    @Autowired
    TblSupplierService supplierService;
    
    @Autowired
    TblFieldTypeService	fieldTypeService;
    
    @Autowired
    TblSmallFieldService smallFieldService;
    @GetMapping("/field")
    public ResponseEntity<TblField> getFieldByFieldName(@Valid @RequestParam String fieldName) {
        TblField field = fieldService.findByFieldName(fieldName);
        if (field != null) {
            return new ResponseEntity<>(field, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    	
    @GetMapping("/fieldId")
    public ResponseEntity<TblField> getFieldByFieldId(@Valid @RequestParam Long Id) {
        TblField field = fieldService.findById(Id);
        if (field != null) {
            return new ResponseEntity<>(field, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
 
    
	@GetMapping("/findById")
	public ResponseEntity<TblField> findById(@Valid @RequestParam Long id) {
		try {
			TblField field = fieldService.findById(id);
			return new ResponseEntity<TblField>(field, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<TblField>(HttpStatus.NOT_FOUND);
		}
	}

    @GetMapping("/list")
    public ResponseEntity<Page<TblField>> findAllField(@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
    	int sizeRecord = 10;
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(sizeRecord);
		Map<String, String> map = new HashMap<>();
		Page<TblField> list = fieldService.getListPageField(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblField>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Page<TblField>>(list, HttpStatus.OK);
    }
    
	@SuppressWarnings("deprecation")
	@CrossOrigin
	@RequestMapping(value = "/paging", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Page<TblField>> findAllField(@RequestBody String req, HttpServletRequest request,
			HttpServletResponse resp) {
		FieldRequest acctreq = gson.fromJson(req, FieldRequest.class);
		int currentPage = acctreq.getPage();
		int pageSize = 10;
		Map<String, String> map = taoMapTraCuu(acctreq);
		Page<TblField> list = fieldService.getListPageField(PageRequest.of(currentPage - 1, pageSize), map);
		if (list == null) {
			return new ResponseEntity<Page<TblField>>(HttpStatus.NOT_FOUND);
		}
		String s = gson.toJson(list);
		System.out.println(list.getNumber());
		System.out.println(s);
		return new ResponseEntity<Page<TblField>>(list, HttpStatus.OK);
	}
	
    
    @PutMapping("/addField")
    public ResponseEntity<?> addField(@Valid @RequestBody FieldRequest fieldRequest) {
        try {
        //	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	//		UserDetailsImpl userToken = getUserInfo();
        	 //   field.setModifieldby(userToken.getUsername());
        	if (fieldService.existsByFieldName(fieldRequest.getFieldName())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Tên sân bóng đã tồn tại!"));
            }

            TblField field = new TblField();
            field.setFieldName(fieldRequest.getFieldName());
            field.setProvinceName(fieldRequest.getProvinceName());
            field.setDistrictName(fieldRequest.getDistrictName());
            field.setWardName(fieldRequest.getWardName());
            field.setProvinceid(fieldRequest.getProvinceid());
            field.setDistrictId(fieldRequest.getDistrictId());
            field.setWardId(fieldRequest.getWardId());
            field.setCreatedDate(new Date());
            field.setPhoneNumberField(fieldRequest.getPhoneNumberField());
            field.setDay(fieldRequest.getDay());
            field.setFieldType(fieldRequest.getFieldType());
            field.setSmallFieldCount(fieldRequest.getSmallFieldCount());
            field.setTimeStart(fieldRequest.getTimeStart());
            field.setTimeEnd(fieldRequest.getTimeEnd());
            field.setAddress(fieldRequest.getAddress());
            field.setImage(fieldRequest.getImage());
            field.setSupplierName(fieldRequest.getSupplierName());
            field.setSupplierId(fieldRequest.getSupplierId());
            field.setStatus(1L);
            TblField fieldSaved = fieldService.saveorUpdate(field);
            if (fieldSaved != null) {
                Long supplierId = fieldRequest.getSupplierId();
                String fieldId = String.valueOf(fieldSaved.getId());
                TblSupplier updatedSupplier = supplierService.saveFieldId(supplierId, fieldId);
                if (updatedSupplier != null) {
                    return ResponseEntity.ok(new MessageResponse(fieldSaved.getId(), "Thêm mới sân bóng thành công và cập nhật fieldId cho nhà cung cấp!"));
                } else {
                    return ResponseEntity.ok(new MessageResponse(fieldSaved.getId(), "Thêm mới sân bóng thành công, nhưng cập nhật fieldId cho nhà cung cấp thất bại!"));
                }
            } else {
                return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Thêm mới sân bóng thất bại!"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
        }
    }
    @PutMapping("/updateField")
    public ResponseEntity<?> updateField(@Valid @RequestBody FieldRequest fieldRequest) {
        try {
            // Retrieve the field ID from the request
            if (fieldRequest.getId() == null || fieldRequest.getId().isEmpty()) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: No field ID provided!"));
            }

            // Find the field by ID
            TblField field = fieldService.findById(Long.valueOf(fieldRequest.getId()));
            if (field == null) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Field not found!"));
            }

            // Check if the new field name is already in use by another field
            if (!field.getFieldName().equals(fieldRequest.getFieldName()) && fieldService.existsByFieldName(fieldRequest.getFieldName())) {
                return ResponseEntity.badRequest().body(new MessageResponse("Error: Field name already in use!"));
            }

            // Update field information
            field.setFieldName(fieldRequest.getFieldName());
            field.setProvinceName(fieldRequest.getProvinceName());
            field.setDistrictName(fieldRequest.getDistrictName());
            field.setWardName(fieldRequest.getWardName());
            field.setProvinceid(fieldRequest.getProvinceid());
            field.setDistrictId(fieldRequest.getDistrictId());
            field.setWardId(fieldRequest.getWardId());
            field.setModifiedDate(new Date());
            field.setPhoneNumberField(fieldRequest.getPhoneNumberField());
            field.setDay(fieldRequest.getDay());
            field.setFieldType(fieldRequest.getFieldType());
            field.setSmallFieldCount(fieldRequest.getSmallFieldCount());
            field.setTimeStart(fieldRequest.getTimeStart());
            field.setTimeEnd(fieldRequest.getTimeEnd());
            field.setAddress(fieldRequest.getAddress());
            field.setImage(fieldRequest.getImage());
            field.setSupplierName(fieldRequest.getSupplierName());
            field.setSupplierId(fieldRequest.getSupplierId());
            // Save the updated field
            TblField updatedField = fieldService.saveorUpdate(field);
            if (updatedField != null) {
                return ResponseEntity.ok(new MessageResponse("Field updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error: Unable to update the field due to an internal error."));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new MessageResponse("Error: Unable to update the field due to an internal error."));
        }
    }
    
    @GetMapping("/delete")
    public ResponseEntity<?> deleteField(@Valid @RequestParam Long id) {
        if ( !fieldService.existsById(id)) {
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Field không tồn tại!"));
        }
        try {
            fieldService.updateStatusField(id,2L);
            return ResponseEntity.ok(new MessageResponse("Xóa field thành công!"));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý!"));
        }
    }
    
    @GetMapping("/cities")
    public ResponseEntity<List<TblCity>> getListCity() {
    	   try {
               List<TblCity> city = cityService.getListCity(null);
               if (city == null || city.isEmpty()) {
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
               }
               return new ResponseEntity<>(city, HttpStatus.OK);
           } catch (Exception ex) {
               return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
           }
    	
    }
    
    @GetMapping("/city")
    public ResponseEntity<TblCity> getCityById(@Valid @RequestParam Long provinceid) {
        TblCity city = cityService.getCitybyId( provinceid);
        if (city != null) {
            return new ResponseEntity<>(city, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/districts")
    public ResponseEntity<List<TblDistrict>> getListDistrict(@Valid @RequestParam Long provinceid) {
        try {
            List<TblDistrict> districts = districtService.getListDistrict(provinceid);
            if (districts == null || districts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/wards")
    public ResponseEntity<List<TblWard>> getListWard(@Valid @RequestParam Long districtId) {
        try {
            List<TblWard> wards = wardService.getListWard(districtId);
            if ( wards == null ||  wards.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>( wards, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/suppliers")
    public ResponseEntity<List<TblSupplier>> getListSupplier() {
    	try {
            List<TblSupplier> supplier = supplierService.getListSupplier(null);
            if (supplier == null || supplier.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
 	
 }
    @GetMapping("/fieldsBySupplierId")
    public ResponseEntity<List<TblField>> getFieldsBySupplierId(@RequestParam Long supplierId) {
        try {
            List<TblField> fields = fieldService.findbySupplierId(supplierId);
            if (fields != null && !fields.isEmpty()) {
                return ResponseEntity.ok(fields);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/fieldTypes")
    public ResponseEntity<?> saveOrUpdateFieldType(@RequestBody FieldTypeRequest fieldTypeRequest) {
        try {
            TblFieldType fieldtype = new TblFieldType();
            fieldtype.setFieldId(fieldTypeRequest.getFieldId());
            fieldtype.setFieldTypeName(fieldTypeRequest.getFieldTypeName());
            fieldtype.setTotalNumberField(fieldTypeRequest.getTotalNumberField());
            TblFieldType savedFieldType = fieldTypeService.saveorUpdate(
                fieldtype.getFieldId(),
                fieldtype.getFieldTypeName(),
                fieldtype.getTotalNumberField()
            );
            
            if (savedFieldType != null) {
                createSmallFields(savedFieldType);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @GetMapping("/fieldTypeByFieldId")
    public ResponseEntity<List<TblFieldType>> getFieldTypeByFieldId(@Valid @RequestParam Long fieldId) {
        List<TblFieldType> fieldType = fieldTypeService.findbyFieldId(fieldId);
        if (fieldType != null && !fieldType.isEmpty()) {
            return ResponseEntity.ok(fieldType);
        } else {
        	 return ResponseEntity.noContent().build();
        }
    }
    
    @GetMapping("/lock")
    public ResponseEntity<?> lockField(@Valid @RequestParam Long id) {
    	try {
    		TblSmallField smallField = smallFieldService.updateStatusSmallField(id, 2L);
    		return ResponseEntity.ok(smallField != null ? new MessageResponse("Khóa sân bóng thành công !")
					: new MessageResponse("Khóa sân bóng thất bại !"));
    	}catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý !"));
		}
	}
    
    @GetMapping("/unlock")
    public ResponseEntity<?> unlockField(@Valid @RequestParam Long id) {
    	try {
    		TblSmallField smallField = smallFieldService.updateStatusSmallField(id, 1L);
    		return ResponseEntity.ok(smallField != null ? new MessageResponse("Mở khóa sân bóng thành công !")
					: new MessageResponse(" Mở khóa sân bóng thất bại !"));
    	}catch (Exception ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Có lỗi xảy ra trong quá trình xử lý !"));
		}
	}
    
    private void createSmallFields(TblFieldType fieldType) {
        Long fieldTypeId = fieldType.getFieldTypeId();
        Long fieldId = fieldType.getFieldId();
        Long totalNumberField = fieldType.getTotalNumberField();
        List<TblSmallField> existingSmallFields = smallFieldService.getSmallFieldsByFieldTypeId(fieldId, fieldTypeId);

        int currentNumberOfSmallFields = existingSmallFields.size();

        if (currentNumberOfSmallFields < totalNumberField) {
            for (int i = currentNumberOfSmallFields + 1; i <= totalNumberField; i++) {
                String smallFieldName = "Sân " + i + " (" + fieldType.getFieldTypeName() + ")"; // Tạo tên sân nhỏ mới theo thứ tự
                smallFieldService.createSmallField(
                    fieldId,
                    smallFieldName,
                    fieldTypeId,
                    fieldType.getFieldTypeName()
                );
            }
        }
    }



    @GetMapping("/smallFields")
    public ResponseEntity<List<TblSmallField>> getSmallFieldsByFieldId(@Valid @RequestParam Long fieldId) {
        try {
            List<TblSmallField> smallFields = smallFieldService.getSmallFieldsByFieldId(fieldId);
            if (smallFields != null && !smallFields.isEmpty()) {
                return ResponseEntity.ok(smallFields);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/countActiveFields")
    public ResponseEntity<?> countActiveFields() {
        try {
            long activeFieldCount = fieldService.countActiveFields();
            return ResponseEntity.ok(activeFieldCount);
        } catch (Exception e) {
            // Xử lý lỗi và trả về HTTP 500 nếu có lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }
    @GetMapping("/countInactiveFields")
    public ResponseEntity<?> countInactiveFields() {
        try {
            long inactiveFieldCount = fieldService.countInactiveFields();
            return ResponseEntity.ok(inactiveFieldCount);
        } catch (Exception e) {
            // Xử lý lỗi và trả về HTTP 500 nếu có lỗi
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }
    @GetMapping("/countActiveSmallFields")
    public ResponseEntity<Long> countActiveSmallFields(@RequestParam Long fieldId) {
        try {
            Long activeCount = fieldService.countActiveSmallFields(fieldId);
            return new ResponseEntity<>(activeCount, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/countMaintenanceSmallFields")
    public ResponseEntity<Long> countMaintenanceSmallFields(@RequestParam Long fieldId) {
        try {
            Long maintenanceCount = fieldService.countMaintenanceSmallFields(fieldId);
            return new ResponseEntity<>(maintenanceCount, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/smallFieldId")
    public ResponseEntity<TblSmallField> getSmallFieldById(@Valid @RequestParam Long id){
    	try {
    		TblSmallField smallField = smallFieldService.findSmallFieldById(id);
    		if(smallField != null ) {
    			return ResponseEntity.ok(smallField);
    		} else {
    				return ResponseEntity.noContent().build();
    				}
    		}
    		catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    	}

    
    private Map<String, String> taoMapTraCuu(FieldRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("fieldName", !StringUtils.isEmpty(request.getFieldName()) ? request.getFieldName() : null);
		map.put("provinceName", !StringUtils.isEmpty(request.getProvinceName()) ? request.getProvinceName() : null);
		map.put("districtName",
				!StringUtils.isEmpty(request.getDistrictName()) ? request.getDistrictName() : null);
		map.put("wardName",
				!StringUtils.isEmpty(request.getWardName()) ? request.getWardName() : null);
		map.put("fieldType", request.getFieldType() != null ? request.getFieldType().toString() : null);
		map.put("phoneNumberField", request.getPhoneNumberField() != null ? request.getPhoneNumberField().toString() : null);
		map.put("smallFieldCount", request.getSmallFieldCount() != null ? request.getSmallFieldCount().toString() : null);
		map.put("status", request.getStatus() != null ? request.getStatus().toString() : null);
		return map;
	}
}
