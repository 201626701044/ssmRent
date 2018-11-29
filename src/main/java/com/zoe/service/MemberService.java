package com.zoe.service;



import com.zoe.pojo.Member;
import com.zoe.util.Page;

import java.util.List;


public interface MemberService {

	List<Member> list();
	int total();
	List<Member> list(Page page);
	void add(Member c);
	void update(Member c);
	void delete(Member c);
	Member get(int member_ID);
}
