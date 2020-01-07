package com.coo.b2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coo.b2.member.FilesRepository;
import com.coo.b2.member.MemberFilesVO;
import com.coo.b2.member.MemberVO;
import com.coo.b2.member.memberRepository;

@SpringBootTest
class MemberTest {
	
	@Autowired
	private memberRepository repository;
	@Autowired
	private FilesRepository frepository;
	
	@Test
	void test() throws Exception{
		
//		MemberVO vo = repository.findByIdAndPw("co", "co");
//		System.out.println(vo.getEmail() + " = email");
	
		MemberFilesVO fvo = frepository.findById("co");
		System.out.println(fvo.getFname() + " = fname");
		
		
		
//		List<MemberFilesVO> list = repository.findAll();
//		
//		for (MemberFilesVO memberFilesVO : list) {
//			System.out.println("fname = " + memberFilesVO.getFname());
//		}
		
//		repository.deleteById(4);
//		
//		List<MemberFilesVO> list = repository.findById("admin");
//		System.out.println(list.get(0).getFnum() + " = fnum");
		
		
		
		
		
//		long count =  repository.count();
//		System.out.println(count);
		
		
//		System.out.println(repository.existsById("co")); 
//		List<MemberVO> ar =repository.findAll();
//		
//		for (MemberVO memberVO : ar) {
//			System.out.println("id = " + memberVO.getId());
//		}
		
//		Optional<MemberVO> opt = repository.findById("ㅎㅎ");
//		
//		
//		if (opt.isPresent()) {
//			MemberVO vo = opt.get();
//			System.out.println("email = "+vo.getEmail());			
//		}else {
//			System.out.println("없음");
//		}
		
		//crud creat, read, update, delete
		
//		MemberVO vo = new MemberVO();
//		vo.setId("hm");
//		vo.setPw("save");
//		vo.setName("save");
//		vo.setEmail("sa@ve");
//		
//		repository.save(vo);
	}

}
