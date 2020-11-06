package kr.or.ddit;

import kr.or.ddit.common.model.PageVo;

public class Test {
	public static void main(String[] args) {

		int a;
		PageVo pageVo = new PageVo();

		System.out.println(pageVo.getPage()); // 예상 : 0
		// 클래스에대한 필드에대해서 초기값을 해준다 설정해주지 않아도 기본값이 들어간다.
		// command 객체를 사용하게되면 기본값이 들어가 있기때문에 없어도 에러는 발생하지 않는다.

		// 지역변수는 초기화 되지않아 사용할수 없다.

	}
}
