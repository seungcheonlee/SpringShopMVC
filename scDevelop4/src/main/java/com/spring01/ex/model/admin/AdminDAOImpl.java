package com.spring01.ex.model.admin;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring01.ex.model.member.MemberDTO;

@Repository  // 데이터 저장소 
public class AdminDAOImpl implements AdminDAO {
	
	@Inject
	SqlSession sqlSession;
	
	@Override
	public String login(MemberDTO dto) {
		return sqlSession.selectOne("admin.login", dto);
	}

}
