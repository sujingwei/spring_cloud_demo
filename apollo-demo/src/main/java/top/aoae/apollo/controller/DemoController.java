package top.aoae.apollo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	
	@Value("${zhangsan_conf:default}")
	private String zhangsanConfig;
	
	@GetMapping("/config")
	public String config() {
		return zhangsanConfig;
	}

}
