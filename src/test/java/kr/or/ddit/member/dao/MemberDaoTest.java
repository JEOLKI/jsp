package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {

		/*** Given ***/
		MemberDao memberDao = new MemberDao();
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
		MemberDao memberDao = new MemberDao();
		
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/*** Then ***/
		assertEquals(15, memberList.size()); // 기존데이터를 삽입하거나 삭제하면 실패한다. // 테스트코드 실행시 DB데이터를 초기화하도록 설정(개인DB)
		//assertEquals("brown", memberList.get(0).getUserid()); // 순서가 정해지지 않아서 올바르지 않다.
		
	}

	@Test
	public void selectMemberPageListTest() {
		
		/*** Given ***/
		MemberDao memberDao = new MemberDao();
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
		MemberDao memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
		
	}
	
}
