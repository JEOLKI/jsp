package kr.or.ddit.member.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import kr.or.ddit.WebTestConfig;
import kr.or.ddit.member.repository.MemberRepositoryI;

public class MemberControllerTest extends WebTestConfig{

	@Resource(name="memberRepository")
	private MemberRepositoryI memberRepository;
	
	@After
	public void tearDown() {
		memberRepository.deleteMember("rgtest");
	}
	
	@Test
	public void getViewTest() throws Exception {
		mockMvc.perform(get("/member/list"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/memberList"));
	}
	
	@Test
	public void getMemberTest() throws Exception {
		mockMvc.perform(get("/member/member")
						.param("userid", "brown"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/member"));
	}
	
	@Test
	public void registGetTest() throws Exception {
		mockMvc.perform(get("/member/regist"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/memberRegist"));
	}
	
	
	@Test
	public void registPostTest() throws Exception {
		
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/brown.png");
		MockMultipartFile file = new MockMultipartFile("file", "brown.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/member/regist")
						.file(file)
						.param("userid", "rgtest")
						.param("usernm", "test")
						.param("alias", "test")
						.param("pass", "test")
						.param("addr1", "test")
						.param("addr2", "test")
						.param("zipcode", "test"))
				.andDo(print())
				.andExpect(view().name("redirect:/member/list"));
	}
	
	@Test
	public void updateGetTest() throws Exception {
		mockMvc.perform(get("/member/update")
						.param("userid", "brown"))
				.andExpect(status().isOk())
				.andExpect(view().name("member/memberUpdate"));
	}
	
	@Test
	public void updatePostTest() throws Exception {
		InputStream is = getClass().getResourceAsStream("/kr/or/ddit/upload/brown.png");
		MockMultipartFile file = new MockMultipartFile("file", "brown.png", "image/png", is);
		
		mockMvc.perform(fileUpload("/member/update")
						.file(file)
						.param("userid", "test")
						.param("usernm", "updatetest")
						.param("alias", "test")
						.param("pass", "test")
						.param("addr1", "test")
						.param("addr2", "test")
						.param("zipcode", "test"))
				.andExpect(status().is(302))
				.andExpect(view().name("redirect:/member/member"));
	}
	

}
