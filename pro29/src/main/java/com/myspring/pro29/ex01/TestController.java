package com.myspring.pro29.ex01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //라이브러리가 설치 돼 있으면 인식한다.
@RequestMapping("/test/*")	//Controller 다음에는 RequestMapping 을 쓰는게 추세이다.
public class TestController {
  static Logger logger = LoggerFactory.getLogger(TestController.class);
   
  @RequestMapping("/hello")	//localhost test 안에 hello를 검색하면 된다.
  public String hello() {
   return "Hello REST!!";	//프론트인 jsp 파일이 없는데 출력 가능. 이게 responseBody의 기능이었다. 
  } 
  
  @RequestMapping("/member")		//localhost:8090/test/member  : JSON 형태의 출력값 -> 키 값 키 값 키 값
  public MemberVO member() {
    MemberVO vo = new MemberVO();
    vo.setId("hong");
    vo.setPwd("1234");
    vo.setName("홍길동");
    vo.setEmail("hong@test.com");
    return vo;
  }    
  
  @RequestMapping("/membersList")
  public List<MemberVO> listMembers () {
    List<MemberVO> list = new ArrayList<MemberVO>();
   for (int i = 0; i < 10; i++) {
     MemberVO vo = new MemberVO();
     vo.setId("hong"+i);
     vo.setPwd("123"+i);
     vo.setName("홍길동"+i);
     vo.setEmail("hong"+i+"@test.com");
     list.add(vo);
   }
    return list; 
  }   
  
  @RequestMapping("/membersMap")	//Map 형태 -> HashMap (JSON 형태이므로 데이터 처리를 더 빨리 가능)
  public Map<Integer, MemberVO> membersMap() {
    Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();
    for (int i = 0; i < 10; i++) {
      MemberVO vo = new MemberVO();
      vo.setId("hong" + i);
      vo.setPwd("123"+i);
      vo.setName("홍길동" + i);
      vo.setEmail("hong"+i+"@test.com");
      map.put(i, vo); 
    }
    return map; 
  }    
  
  @RequestMapping(value= "/notice/{num}" , method = RequestMethod.GET)
  public int notice(@PathVariable("num") int num ) throws Exception {
     return num;
  }   

  @RequestMapping(value= "/info", method = RequestMethod.POST)
  public void modify(@RequestBody MemberVO vo ){
    logger.info(vo.toString());
  }
  
  @RequestMapping("/membersList2")
  public  ResponseEntity<List<MemberVO>> listMembers2() {
   List<MemberVO> list = new ArrayList<MemberVO>();
   for (int i = 0; i < 10; i++) {
     MemberVO vo = new MemberVO();
     vo.setId("lee" + i);
     vo.setPwd("123"+i);
     vo.setName("이순신" + i);
      vo.setEmail("lee"+i+"@test.com");
     list.add(vo);
   }
    return new ResponseEntity(list,HttpStatus.INTERNAL_SERVER_ERROR);
  }   
  
  
   @RequestMapping(value = "/res3")
   public ResponseEntity res3() {
      HttpHeaders responseHeaders = new HttpHeaders();
       responseHeaders.add("Content-Type", "text/html; charset=utf-8");
       String message = "<script>";
      message += " alert('새 회원을 등록합니다.');";
      message += " location.href='/pro29/test/membersList2'; ";
      message += " </script>";
      return  new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
   }
   
}