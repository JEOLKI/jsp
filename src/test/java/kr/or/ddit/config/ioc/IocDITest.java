package kr.or.ddit.config.ioc;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.person.model.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/ioc/ioc.xml"})
public class IocDITest {

	// ioc.xml을 바탕으로 스프링 빈이 잘 생성되었는지 확인
	// setter - boardService , constructor - boardServiceC 주입 확인

	// DI
	// 스프링 빈중에 호환되는 타입의 빈이 있을 때 주입
	@Autowired // 주입을 받음
	ApplicationContext context;
	
	@Resource(name = "boardService") // 주입을 받음 BoardServiceI에 호환되는 스프링 빈이 있으면 주입을 시켜준다.
	BoardService boardService;
	
	@Resource(name = "boardServiceC") // 스프링 빈의 이름을 통해서 주입을 받는다. 같은 타입이 여러개가 있으니 
	BoardService boardServiceC;

	
	@Resource(name = "person")
	Person person;
	
	// person 스프링빈의 age(value), boardRepository(ref) 두 속성에 주입이 잘 되었는지 확인
	@Test
	public void valueRefTest() {
		/***Given***/

		/***When***/
		
		/***Then***/
		assertEquals(30, person.getAge());
		assertEquals("내용", person.getBoardRepository().getBoard(1).getContent());
	}
	
	
	
	// boardService, boardServiceC 스프링빈에 주입한 boardRepository 스프링빈은
	// 동일한 빈이르모 두 객체의 getter 메소드를 통해 업어온 boardRepository 객체는 동일해야 한다.
	@Test
	public void repositorySameTest() {
		/***Given***/

		/***When***/

		/***Then***/
		assertEquals(boardService.getBoardRepository(), boardServiceC.getBoardRepository());
	}
	
	@Test
	public void DIAutowiredTest() {
		/***Given***/

		/***When***/
		
		/***Then***/
		assertNotNull(boardService);
	
	}
	
	
	// 스프링 컨테이너를 주입받아 DL을 통해서 boardService 스프링 빈이 제대로 생성되었는지 확인
	@Test
	public void DITest() {
		/***Given***/

		/***When***/
		BoardServiceI boardService = context.getBean("boardService", BoardServiceI.class);
		BoardVo boardVo =  boardService.getBoard(1);
		
		/***Then***/
		assertEquals("첫번째 글", boardVo.getTitle());
		
	}

}
