package top.aoae.article.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* top.aoae.article.controller.*.*(..))")
	public void p1() {}
	
	@Before("p1()")
	public void beforeAdvice(JoinPoint joinPoint) 
	{
		System.out.println("LogAspect.beforeAdvice....");
	}

}
