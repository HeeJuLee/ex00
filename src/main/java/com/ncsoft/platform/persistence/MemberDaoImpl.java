package com.ncsoft.platform.persistence;

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

}
