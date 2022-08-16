package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")	//sample 로 시작하는 모든 것을 이쪽 클래스와 메서드로 들어와서 사용한다.
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		
		log.info("basic........................");
	}
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	//requestMappping 을 쓰려면 정확히 requestMethod.get RequestMethod.POST을 입력해야 한다.
	public void basicGet() {
		
		log.info("basic get........................");
	}
	@GetMapping("/basicOnlyGet") //getMapping만 가능
	public void basicGet2() {
		
		log.info("basic get only get........................");
	}

@GetMapping("/ex01") //getMapping만 가능
public String ex01(SampleDTO dto) {
	
	log.info(" " + dto);
	return "ex01";
}
@GetMapping("/ex02") 
public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
	
	log.info("name: " + name);
	log.info("age: " + age);
	return "ex02";
}
@GetMapping("/ex02List") 
public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
	
	log.info("ids: " + ids);
	return "ex02List";
}
@GetMapping("/ex02Array") 
public String ex02Array(@RequestParam("ids") String[] ids) {
	
	log.info("array ids: " + Arrays.toString(ids));
	return "ex02Array";
}

}
