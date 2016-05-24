package com.ncsoft.platform.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncsoft.platform.domain.Member;
import com.ncsoft.platform.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoTest {

	@Inject
	private MemberDao dao;
	
	@Test
	public void testTime() throws Exception {
		System.out.println(dao.getTime());
	}
	
	@Test
	public void insertMemberTest() throws Exception {
		Member member = new Member();
		member.setUserid("1");
		member.setUsername("user00");
		member.setUserpw("user-passwd");
		member.setEmail("user00@test.com");
				
		dao.insertMember(member);
	}
}
