package com.coo.b2.member;


import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<MemberFilesVO, Integer>{
	
	public MemberFilesVO findById(String id) throws Exception; 
	
	
	
}
