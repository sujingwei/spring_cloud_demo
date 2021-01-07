package top.aoae.my_springboot_starter_used;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import top.aoae.my_springboot_start.EnableUtil;

@SpringBootApplication
@EnableUtil
public class UsedStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsedStarterApplication.class, args);
	}

}
