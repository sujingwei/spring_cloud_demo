package top.aoae.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.aoae.task.tasks.DemoTask;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private DemoTask demoTask;

	/**
	 * 调用异步任务
	 * @return
	 */
	@GetMapping("/async")
	public String async() {
		demoTask.task1();
		demoTask.task2();
		demoTask.task3();
		return "Async Task | 异步任务";
	}

}
