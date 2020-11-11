package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAdvice.class);
	
	// pointCut 설정을 위한 의미 없는 메소드
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
	}
	
	@Before("dummy()") // pointCut 메소드 문자열로 기입
	public void beforeMethod(JoinPoint joinPoint) {
		logger.debug("beforeMethod : {}", joinPoint.getSignature().getName());
	}
	
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		
		// 메소드 실행전 공통 관심사항
		long start = System.currentTimeMillis();
		
		// 메소드 실행
		Object ret = joinPoint.proceed(joinPoint.getArgs()); // 우리가 작성한 원래 로직을 object로 리턴
		
		// 메소드 실행후 공통 관심사항
		long end = System.currentTimeMillis();
		
		logger.debug("profiling : {} {} - {}", 
					  joinPoint.getSignature().getDeclaringTypeName(),
					  joinPoint.getSignature().getName(), // joinpoint 메소드 이름
					  end-start +"ms");

		return ret;
	}
}
