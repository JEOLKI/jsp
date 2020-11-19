package kr.or.ddit.batch.basic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BasicReader implements ItemReader<String>{
	
	private static final Logger logger = LoggerFactory.getLogger(BasicReader.class);
	
	private List<String> list; // 다른곳에서 객체를 사용하기 위함
	private int index = 0; // 어디까지 읽었는지 관리를 하기 위해서
	
	public BasicReader() {
		list = new ArrayList<String>();

		// list 객체에 5개의 임의 값을 생성
		list.add("brown");
		list.add("cony");
		list.add("sally");
		list.add("moon");
		list.add("james");
	}
	
	// 읽어들인 데이터를 프로세스로 전달
	// return 값이 Processor에게 전달된다.
	// 더이상 읽을 데이터가 없을 대 null을 리터 ==> spring batch 모듈에서 읽을 데이터가 없다고 인식
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		logger.debug("=====read=====");
		
		if(index < list.size()) { // 5번 호출되면 에러가 발생하는것을 방지
			String item = list.get(index++); 
			logger.debug("item : {}" , item);
			return item;
		}
		else {
			index = 0;
			return null;
		}
	}

	
}
