package top.aoae.user.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user")
public class UserController {

	@GetMapping("/hello")
	public String hello(String word) {
		int r = new Random().nextInt(3500);
		try {
			Thread.sleep(new Long(r));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "[" + r + "]hello " + word;
	}
}
