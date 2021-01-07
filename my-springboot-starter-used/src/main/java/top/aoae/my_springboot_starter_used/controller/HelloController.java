package top.aoae.my_springboot_starter_used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.aoae.my_springboot_start.DateUtil;

@RestController
public class HelloController {
	
	@Autowired
	private DateUtil dateUtil;
	
	@RequestMapping("/test")
	public String test(String str) {
		return dateUtil.getLocalTime();
	}

}
