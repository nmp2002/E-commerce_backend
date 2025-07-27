package com.ttisv.springbootwildfly.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblShiftField;
import com.ttisv.service.system.TblShiftFieldService;
import com.ttisv.springbootwildfly.payload.request.ShiftFieldRequest;
import com.ttisv.springbootwildfly.payload.response.MessageResponse;

@RestController
@RequestMapping("/api/shiftfield")
public class ShiftFieldController extends BaseController {
    
    @Autowired
    TblShiftFieldService tblShiftFieldService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Page<TblShiftField>> findAllShiftFields(@RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int sizeRecord = 10;
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(sizeRecord);
        Page<TblShiftField> shiftFieldPage = tblShiftFieldService.getListPageShiftField(PageRequest.of(currentPage - 1, pageSize), null);
        if (shiftFieldPage == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shiftFieldPage, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteShiftField(@RequestParam("id") Long shiftFieldId) {
        boolean result = tblShiftFieldService.deleteShiftField(shiftFieldId);
        if (result) {
            return new ResponseEntity<>("Shift field deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete shift field", HttpStatus.NOT_FOUND);
        }
    }
 
    @PutMapping("/addShiftField")
    public ResponseEntity<?> saveOrUpdateShiftField(@Valid @RequestBody ShiftFieldRequest shiftFieldRequest) {
        try {
        	if (tblShiftFieldService.existingByShiftFieldName(shiftFieldRequest.getShiftFieldName(),shiftFieldRequest.getFieldId())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Ca sân số này đã tồn tại !"));
			}
            TblShiftField shiftField = new TblShiftField();
            shiftField.setId(shiftFieldRequest.getId());
            shiftField.setFieldId(shiftFieldRequest.getFieldId());
            shiftField.setShiftFieldName(shiftFieldRequest.getShiftFieldName());
            shiftField.setTimeStart(shiftFieldRequest.getTimeStart());
            shiftField.setTimeEnd(shiftFieldRequest.getTimeEnd());
            shiftField.setAmountWeekday(shiftFieldRequest.getAmountWeekday());
            shiftField.setAmountWeekend(shiftFieldRequest.getAmountWeekend());
            shiftField.setDayOfWeek(shiftFieldRequest.getDayOfWeek());
            shiftField.setDay(shiftFieldRequest.getDay());
            shiftField.setFieldType(shiftFieldRequest.getFieldType());
            TblShiftField savedShiftField = tblShiftFieldService.saveorUpdate(shiftField);
            if (savedShiftField != null) {
                return new ResponseEntity<>(savedShiftField, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/updateShiftField")
    public ResponseEntity<?> updateShiftField(@Valid @RequestBody ShiftFieldRequest shiftFieldRequest) {
        try {
            // Check if the shift field ID is provided
            if (shiftFieldRequest.getId() == null) {
                return ResponseEntity.badRequest().body("Error: No shift field ID provided!");
            }

            // Find the shift field by ID
            TblShiftField shiftField = tblShiftFieldService.findById(shiftFieldRequest.getId());
            if (shiftField == null) {
                return ResponseEntity.badRequest().body("Error: Shift field not found!");
            }

            // Update shift field information
            shiftField.setFieldId(shiftFieldRequest.getFieldId());
            shiftField.setShiftFieldName(shiftFieldRequest.getShiftFieldName());
            shiftField.setTimeStart(shiftFieldRequest.getTimeStart());
            shiftField.setTimeEnd(shiftFieldRequest.getTimeEnd());
            shiftField.setAmountWeekday(shiftFieldRequest.getAmountWeekday());
            shiftField.setAmountWeekend(shiftFieldRequest.getAmountWeekend());
            shiftField.setDayOfWeek(shiftFieldRequest.getDayOfWeek());
            shiftField.setDay(shiftFieldRequest.getDay());
            shiftField.setFieldType(shiftFieldRequest.getFieldType());
            // Save the updated shift field
            TblShiftField updatedShiftField = tblShiftFieldService.saveorUpdate(shiftField);
            if (updatedShiftField != null) {
            	  return ResponseEntity.ok(new MessageResponse("Shift Field updated successfully!"));
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Unable to update the shift field due to an internal error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: Unable to update the shift field due to an internal error.");
        }
    }
    @GetMapping("/getshiftfield")
    public ResponseEntity<List<TblShiftField>> getShiftFieldsByFieldId(@RequestParam Long fieldId) {
        try {
            List<TblShiftField> shiftFields = tblShiftFieldService.getShiftFieldsByFieldId(fieldId);
            if (shiftFields != null && !shiftFields.isEmpty()) {
                return new ResponseEntity<>(shiftFields, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getshiftfieldsbytype")
    public ResponseEntity<List<TblShiftField>> getShiftFieldsByFieldType(@RequestParam Long fieldId,
            @RequestParam String fieldType) {
        try {
            List<TblShiftField> shiftFields = tblShiftFieldService.getShiftFieldsByFieldType(fieldId, fieldType);
            if (shiftFields != null && !shiftFields.isEmpty()) {
                return new ResponseEntity<>(shiftFields, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
