package com.ncsoft.platform.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ncsoft.platform.domain.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.ncsoft.platform.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		
		return sqlSession.selectOne(namespace + ".getTime");
	}

	@Override
	public void insertMember(Member member) {
		
		sqlSession.insert(namespace + ".insertMember", member);
	}

	@Override
	public Member readMember(String userid) throws Exception {
		
		return (Member) sqlSession.selectOne(namespace + ".readMember", userid);
	}

	@Override
	public Member readWithPassword(String userid, String userpw) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		
		return (Member) sqlSession.selectOne(namespace + ".readWithPassword", paramMap);
	}

	
}
