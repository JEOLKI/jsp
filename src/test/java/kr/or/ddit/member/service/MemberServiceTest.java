package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);
	
	MemberServiceI memberService;
	
	@Before
	public void setup() {
		memberService = new MemberService();
		String userid = "JEOLKI";
		memberService.deleteMember(userid);
		MemberVo memberVo = new MemberVo("brown","brownPass", "브라운", "곰", "",
				 "", "", "D:\\profile\\brown.png", "brown.png");
		memberService.updateMember(memberVo);
	}
	
	@Test
	public void getMemberTest() {

		/*** Given ***/
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/*** When ***/
		MemberVo memberVo = memberService.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());

		// assertEquals(answerMemberVo, memberVo);

	}

	@Test
	public void selectMemberPageListTest() {

		/*** Given ***/
		PageVo pageVo = new PageVo(1,5);

		/*** When ***/
		// memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVo> memberList = (List<MemberVo>) map.get("memberList");

		// 생성해야할 page 수
		int pages = (int) map.get("pages");

		/*** Then ***/
		assertEquals(pageVo.getPageSize(), memberList.size());
		assertEquals(3, pages);

	}

	@Test
	public void localListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for (Locale locale : locales){
			logger.debug("{}", locale);
			//logger.debug(locale.toString());
		}
	}
	
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("JEOLKI","pass1234", "홍정기", "JH", "대전 중구 중앙로 76",
				 "영민빌딩 4층 404호", "34940", "d:\\profile\\브루니.png", "브루니.png");

		/***When***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("brown","brownPass", "브라운", "곰", "대전 중구 중앙로 76",
				 "영민빌딩 4층 404호", "34940", "D:\\profile\\brown.png", "brown.png");

		/***When***/
		int updateCnt = memberService.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	

}
