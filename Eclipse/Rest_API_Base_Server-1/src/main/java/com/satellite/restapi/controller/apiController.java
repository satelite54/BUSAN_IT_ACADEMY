package com.satellite.restapi.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satellite.restapi.service.apiservice;

@RestController
public class apiController {
	@Autowired
	private apiservice service;
	
	@RequestMapping("/getEmpInfo")
	public List<Map<String, Object>> getEmpInfo(HttpServletRequest request, @RequestParam Map<String, String> param) {
		return service.getEmpInfo(param);
	}
}
