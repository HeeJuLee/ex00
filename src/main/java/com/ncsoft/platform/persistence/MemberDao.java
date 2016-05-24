package com.ncsoft.platform.persistence;

import com.ncsoft.platform.domain.Member;

public interface MemberDao {
	
	public String getTime();
	public void insertMember(Member member);
	
}
