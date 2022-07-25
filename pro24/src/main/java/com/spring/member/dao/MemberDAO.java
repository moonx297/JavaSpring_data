package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import com.spring.member.vo.MemberVO;

//DAO 능력은 무엇인가? 검색 , 삽입, 삭제가 있음을 확인할 수 있음 
public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException;
	 public int insertMember(MemberVO memberVO) throws DataAccessException ;
	 public int deleteMember(String id) throws DataAccessException;
	 

}
