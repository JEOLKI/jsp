package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

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
//		assertEquals("brown", memberVo.getUserId());
//		assertEquals("passBrown", memberVo.getPassword());

		assertEquals(answerMemberVo, memberVo);

	}
	
	@Test
	public void selectAllmemberTest() {
		
		/*** Given ***/
		MemberDao memberDao = new MemberDao();
		
		/*** When ***/
		List<MemberVo> memberList = memberDao.selectAllMember();
		
		/*** Then ***/
		assertEquals(5, memberList.size()); // 기존데이터를 삽입하거나 삭제하면 실패한다. // 테스트코드 실행시 DB데이터를 초기화하도록 설정(개인DB)
		//assertEquals("brown", memberList.get(0).getUserid()); // 순서가 정해지지 않아서 올바르지 않다.
		
	}

}
