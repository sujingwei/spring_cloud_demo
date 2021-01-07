package top.aoae.article;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ArticleApplication implements InitializingBean {
	
	/**
	 * Bean:restTemplate
	 * @return
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	/**
	 * 线程池
	 * destroyMethod = "shutdown" 服务在关闭的时候，会执行没有执行的任务
	 * @return
	 */
	@Bean(name="threadPoolExecutor", destroyMethod = "shutdown")
	public ThreadPoolExecutor runnable() {
		return new ThreadPoolExecutor(3, 5, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(50));
	}
	
	/**
	 * InitializingBean 容器加载完后执行
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		new Thread() {
			public void run() {
				System.out.println("+----------------------------------------+");
				System.out.println("| 初始化时加载 ....");
				System.out.println("+----------------------------------------+");
			}
		}.start();
	}

	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}

}
