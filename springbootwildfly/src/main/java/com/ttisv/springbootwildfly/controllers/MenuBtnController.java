package com.ttisv.springbootwildfly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblMenuBtn;
import com.ttisv.service.system.TblMenuBtnService;

@RestController
@RequestMapping("/api/menu/btn/")
public class MenuBtnController extends BaseController {
	@Autowired 
	TblMenuBtnService tblMenuBtnService;
	 @PutMapping("/updateMenuBtn")
	    public ResponseEntity<TblMenuBtn> updateMenuBtn(@RequestBody TblMenuBtn menuBtn) {
	        TblMenuBtn updatedMenuBtn = tblMenuBtnService.saveorUpdate(menuBtn);
	        return ResponseEntity.ok(updatedMenuBtn);
	    }

	    @PutMapping("/createMenuBtn")
	    public ResponseEntity<TblMenuBtn> createMenuBtn(@RequestBody TblMenuBtn menuBtn) {
	        TblMenuBtn newMenuBtn = tblMenuBtnService.saveorUpdate(menuBtn);
	        return ResponseEntity.ok(newMenuBtn);
	    }
}
