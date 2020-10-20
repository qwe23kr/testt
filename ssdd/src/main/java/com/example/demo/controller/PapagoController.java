package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.PapagoService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PapagoController {
	
	@Resource
	private PapagoService ps;

	@GetMapping("/papago")
	public String doTranslate(@RequestParam Map<String, String> param) {
	
	
		return  ps.doTranslate(param);
	}
}
