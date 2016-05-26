package com.ncsoft.platform.persistence;

import com.ncsoft.platform.domain.Member;

public interface MemberDao {
	
	public String getTime();
	public void insertMember(Member member);
	public Member readMember(String userid) throws Exception;
	public Member readWithPassword(String userid, String userpw) throws Exception;
	
}
