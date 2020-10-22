package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	/*
	 	테스트 메소드 : @Test
		junit의 라이프사이클
		@BeforeClass (static)
			@Before ⇒ @Test ⇒ @After
			@Before ⇒ @Test ⇒ @After
			@Before ⇒ @Test ⇒ @After
		@AfterClass (static)
	*/
	
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "JEOLKI";
		memberDao.deleteMember(userid);
		MemberVo memberVo = new MemberVo("brown","brownPass", "브라운", "곰", "",
				 "", "", "D:\\profile\\brown.png", "brown.png");
		memberDao.updateMember(memberVo);
	}
	
	
	@Test
	public void getMemberTest() {

		/*** Given ***/
		String userId = "brown";

		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/*** When ***/
		MemberVo memberVo = memberDao.getMember(userId);

		/*** Then ***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());

		//assertEquals(answerMemberVo, memberVo);

	}
	
	@Test
	public void selectAllmemberTest() {
		
		/*** Given ***/
		
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/*** Then ***/
		assertEquals(15, memberList.size()); // 기존데이터를 삽입하거나 삭제하면 실패한다. // 테스트코드 실행시 DB데이터를 초기화하도록 설정(개인DB)
		//assertEquals("brown", memberList.get(0).getUserid()); // 순서가 정해지지 않아서 올바르지 않다.
		
	}

	@Test
	public void selectMemberPageListTest() {
		
		/*** Given ***/
		PageVo pageVo = new PageVo(1,5);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		//int page = 1;
		
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);
		
		/*** Then ***/
		assertEquals(pageVo.getPageSize(), memberList.size()); 
		
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
		
	}

	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("JEOLKI","pass1234", "홍정기", "JH", "대전 중구 중앙로 76",
										 "영민빌딩 4층 404호", "34940", "d:\\profile\\브루니.png", "브루니.png");
		
		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVo memberVo = new MemberVo("brown","brownPass", "브라운", "곰", "대전 중구 중앙로 76",
				 "영민빌딩 4층 404호", "34940", "D:\\profile\\brown.png", "brown.png");

		/***When***/
		int updateCnt = memberDao.updateMember(memberVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
