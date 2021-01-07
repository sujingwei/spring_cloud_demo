package top.aoae.my_springboot_start;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO 这个配置类就是返回 DateUtil Bean 的重点
 * @author leyao
 *
 */
// 当成配置类
@Configuration
@EnableConfigurationProperties(UtilProperties.class)
public class DateConfig {
	
	/**
	 * 
	 * @return
	 */
	@Bean
	public DateUtil getDateUtil() {
		return new DateUtil();
	}
}
