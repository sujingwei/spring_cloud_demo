package top.aoae.task;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

import top.aoae.task.tasks.DemoTask;

/**
 * 任务、定时任务、线程池
 * @author leyao
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class TaskApplication implements InitializingBean{
		
	@Autowired
	private DemoTask demoTask;
	
	/**
	 * IOC容器启动后执行
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		demoTask.task_mq();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	
}
