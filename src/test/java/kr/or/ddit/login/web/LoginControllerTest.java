package kr.or.ddit.login.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class LoginControllerTest extends WebTestConfig{
	
	@Test
	public void getViewTest() throws Exception {
		mockMvc.perform(get("/login/view")) //url 정보를 요청한다.
			.andExpect(status().isOk()) // assert와 비슷 // OK는 status code 200을 리턴
			.andExpect(view().name("login/view")); // 기대가되는 뷰의 이름이 일치하는지
	}
	
	// 로그인 요청 테스트 (정상적인 경우)
	@Test
	public void processSuccessTest() throws Exception {
		mockMvc.perform(post("/login/process").contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("userid", "brown")
						.param("pass", "brownPass"))
				.andExpect(status().is(200))
				.andExpect(view().name("main"))
				.andExpect(model().attributeExists("to_day"));
	}

	// 로그인 요청 테스트 ( 실패 )
	@Test
	public void processFailTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/login/process")
											.param("userid", "brown")
											.param("pass", "brownPassFail")).andReturn();
		
		ModelAndView mav = result.getModelAndView();
		
		assertEquals("fail", mav.getModel().get("msg")); 
		assertEquals("login/view", mav.getViewName()); 
	}
	
	
}







