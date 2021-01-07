package top.aoae.task.tasks;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SaticScheduleTask {
	
	@Scheduled(fixedRate = 5000)
	public void saticTask() {
		System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
	}

}
