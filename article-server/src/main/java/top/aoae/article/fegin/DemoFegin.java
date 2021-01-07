package top.aoae.article.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import top.aoae.article.fegin.impl.DemoFeginImpl;

@FeignClient(name = "USER-SERVER", fallback = DemoFeginImpl.class)
public interface DemoFegin {
	
	@RequestMapping(value = "/user/hello", method = RequestMethod.GET)
	public String hello(@RequestParam(name = "word", required = false)String word);

}
