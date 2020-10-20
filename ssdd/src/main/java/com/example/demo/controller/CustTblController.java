package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.CustTblMapper;
import com.example.demo.vo.CustTblVO;

@RestController
public class CustTblController {

	@Resource
	private CustTblMapper ctMapper;
	@GetMapping("/custs")
	public List<CustTblVO> getCustTblList(){
		return ctMapper.selectCustTblList(null);
	}
}
