package top.aoae.article.fegin.impl;

import org.springframework.stereotype.Component;

import top.aoae.article.fegin.DemoFegin;

@Component
public class DemoFeginImpl implements DemoFegin {

	@Override
	public String hello(String word) {
		return "调用 user-server 服务失败，触发熔断";
	}

}
