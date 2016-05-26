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
		member.setUserid("3");
		member.setUsername("user00");
		member.setUserpw("user-passwd");
		member.setEmail("user00@test.com");
				
		dao.insertMember(member);
	}
	
	@Test
	public void readMemberTest() throws Exception {
		
		Member member = dao.readMember("1");
		System.out.println("member: " + member.getUserid() + ", " + member.getUsername());
	}
	
	@Test
	public void readMemberWithPasswordTest() throws Exception {
		
		Member member = dao.readWithPassword("2", "user-passwd");
		System.out.println("member: " + member.getUserid() + ", " + member.getUsername());
	}
}
