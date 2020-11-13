package kr.or.ddit.config.spring;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(basePackages = {"kr.or.ddit"}, useDefaultFilters = false, 
			   includeFilters = {@Filter(type=FilterType.ANNOTATION, classes = {Aspect.class})})
@EnableAspectJAutoProxy  //<aop:aspectj-autoproxy/>
public class AopContext {
	
}
