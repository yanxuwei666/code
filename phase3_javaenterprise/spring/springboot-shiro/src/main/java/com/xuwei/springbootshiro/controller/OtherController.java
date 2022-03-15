package com.xuwei.springbootshiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/other")
public class OtherController {

	@GetMapping("/test")
	@RequiresPermissions(value = { "other:view" })
	public ResponseEntity<?> test(ModelMap model) {
		return ResponseEntity.ok().body("Welcome!");
	}
}
