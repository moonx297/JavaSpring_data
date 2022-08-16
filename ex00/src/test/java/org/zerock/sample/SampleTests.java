package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test   //여기서 에러가 발생하면 pom.xml에 springframework test 라이브러리를 추가해줘야 한다.	
	
	//더블 클릭해서 run JUnit 하면 실행.
	public void test1() {	
		log.info(restaurant);
		log.info("-------------------");
		log.info(restaurant.getChef());
	}
}