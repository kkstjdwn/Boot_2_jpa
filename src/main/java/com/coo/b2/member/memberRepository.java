package com.coo.b2.member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface memberRepository extends JpaRepository<MemberVO, String>{
	
	public MemberVO findByIdAndPw(String id, String pw) throws Exception;

}
