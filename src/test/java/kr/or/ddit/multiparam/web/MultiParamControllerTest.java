package kr.or.ddit.multiparam.web;

import static org.junit.Assert.*; // static 임포트를 통해서 static method를 불러준다.
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.WebTestConfig;

public class MultiParamControllerTest extends WebTestConfig{

	@Test
	public void multiParamViewTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/multi/view")).andReturn();
		ModelAndView mav = result.getModelAndView();
		assertEquals("multi/view", mav.getViewName());
	}

	@Test
	public void multiParamSubmitTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/multi/view")
											.param("userid", "brown", "sally", "cony")) // 2번째부터는 가변인자...
									.andDo(print())
									.andReturn();
		
		ModelAndView mav = result.getModelAndView();
		assertEquals("multi/view", mav.getViewName());
	}
	
}
