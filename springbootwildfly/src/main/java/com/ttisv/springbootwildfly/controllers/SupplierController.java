package com.ttisv.springbootwildfly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblSupplier;
import com.ttisv.service.system.TblSupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController  extends BaseController {
	  @Autowired
	    TblSupplierService supplierService;
	  @GetMapping("/by-name-login")
	    public TblSupplier getSupplierBySupplierNameLogin(@RequestParam String supplierNameLogin) {
	        return supplierService.findBySupplierNameLogin(supplierNameLogin);
	    }
}
