package com.ttisv.springbootwildfly.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ttisv.bean.system.TblGroupRole;
import com.ttisv.service.system.TblGroupRoleService;

@RestController
@RequestMapping("/api/groupRole")
public class GroupRoleController  extends BaseController  {
	@Autowired 
	TblGroupRoleService tblGroupRoleService;
	@GetMapping("/")
	public ResponseEntity<List<TblGroupRole>> getListGroupRole() {
        try {
            List<TblGroupRole> groupRoles = tblGroupRoleService.getListGroupRole(null);
            if (groupRoles == null || groupRoles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(groupRoles, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
