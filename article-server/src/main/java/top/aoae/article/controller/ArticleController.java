package top.aoae.article.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import top.aoae.article.entity.Article;
import top.aoae.article.fegin.DemoFegin;

@RestController()
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private DemoFegin demoFegin;

	@Autowired
	private ThreadPoolExecutor threadPoolExecutor;

	@GetMapping("/get")
	public String get(String txt) {
		List<org.springframework.cloud.client.ServiceInstance> list = discoveryClient.getInstances("USER-SERVER");
		String url = "http://" + list.get(0).getHost() + ":" + list.get(0).getPort() + "/user/hello?word=" + txt;
		System.out.println(url);
		String resultString = restTemplate.getForObject(url, String.class);
		return resultString;
	}

	@GetMapping("/get2")
	public String get2(String txt) {
		String result = demoFegin.hello(txt);
		return result;
	}
	
	@GetMapping("thread-pool")
	public String threadPool() {
		threadPoolExecutor.execute(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("我的任务[" + i + "] " + new Date());
				}
			}
		});
		return "thread-pool";
	}

	public void findArticle() {
		new Article(1, (byte) 2, "aa", "bb");
	}

}
