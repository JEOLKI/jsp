package kr.or.ddit.db;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionPoolServlet extends HttpServlet {
	
	private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolServlet.class);
	
	@Override
	public void init() throws ServletException {

		logger.debug("ConnectionPoolServlet init()");
		
		// ConnectionPoolServlet 초기화 될때 컨넥션 풀을 생성해서 
		// application 영역에 저장
		// 다른 jsp, servlet에서는 application 영역을 통해 컨넥션 풀을 접근
		
		// 컨넥션 pool 생성
		BasicDataSource bd = new BasicDataSource();
		bd.setDriverClassName("oracle.jdbc.driver.OracleDriver"); // 오라클 드라이버 클래스 네임
		bd.setUrl("jdbc:oracle:thin:@localhost:1521/xe"); // 오라클 서버의 주소
		bd.setUsername("HJG"); // 오라클 서버의 계정명
		bd.setPassword("java"); // 오라클서버의 비밀번호
		bd.setInitialSize(20); // 생성할 컨넥션풀의 갯수
		
		// application 영역에 저장
		ServletContext sc = getServletContext(); // application 객체
		sc.setAttribute("bd", bd);
		
	}
	
	
}
