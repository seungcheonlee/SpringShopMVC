package com.spring01.ex.model.admin;

import com.spring01.ex.model.member.MemberDTO;

public interface AdminDAO {
	public String login(MemberDTO dto);
}
