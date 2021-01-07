package top.aoae.task.tasks;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步任务
 * @author leyao
 *
 */
@Component
public class DemoTask {
	
	@Async
	public void task_mq() {
		while (true) {
			try {
				Thread.sleep(5000);
				System.out.println("长注内存的任务");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Async
	public void task1() {
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task 1 : " + (System.currentTimeMillis() - start));
	}
	
	@Async
	public void task2() {
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task 2 : " + (System.currentTimeMillis() - start));
	}
	
	@Async
	public void task3() {
		long start = System.currentTimeMillis();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task 3 : " + (System.currentTimeMillis() - start));
	}

}
