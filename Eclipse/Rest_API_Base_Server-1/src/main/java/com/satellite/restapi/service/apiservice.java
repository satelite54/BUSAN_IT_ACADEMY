package com.satellite.restapi.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.satellite.restapi.mapper.apiMapper;

@Service
public class apiservice {
	@Autowired
	private apiMapper mapper;
	
	public List<Map<String, Object>> getEmpInfo(Map<String, String> param) {
		return mapper.getEmpInfo(param);
	}
}
