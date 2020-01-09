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
		
//		MemberVO vo = new MemberVO();
//		vo.setId("co2");
//		vo.setPw("coco");
//		vo.setName("coco");
//		vo.setEmail("co@coco");
//		
//		MemberFilesVO fvo = new MemberFilesVO();
//		
//		
//		fvo.setFname("new 2");
//		fvo.setOname("new 2");
//		
//		vo = repository.save(vo);
//		vo = repository.findById(vo.getId()).get();
//		Thread.sleep(500);
//		
//		fvo.setFnum(vo.getFilesVO().getFnum());
//		fvo.setMemberVO(vo);
//		
//		frepository.save(fvo);
		
		MemberVO vo =repository.findById("99").get();
		System.out.println(vo.getFilesVO().getFnum() + " = fnum");
		
//		repository.deleteById("co1");
		
//		MemberVO vo = new MemberVO();
//		MemberFilesVO fvo = new MemberFilesVO();
//		
//		vo.setId("co1");
//		vo.setPw("co1");
//		vo.setName("co1");
//		vo.setEmail("co@1");
//		fvo.setMemberVO(vo);
//		fvo.setFname("00co1.JPG");
//		fvo.setOname("co1.JPG");
//		
//		vo = repository.save(vo);
//		fvo = frepository.save(fvo);
		
		
		
		
		
//		MemberFilesVO filesVO = frepository.findById(3).get();
//		System.out.println("FNAME = "+filesVO.getFname());
//		System.out.println("EMAIL = "+filesVO.getMemberVO().getEmail());
//		
//		
//		Optional<MemberVO> opt =repository.findById("co");
//		MemberVO vo = opt.get();
//		
//		System.out.println("NAME = "+vo.getName());
//		System.out.println("FNAME = "+vo.getFilesVO().getFname());
//		System.out.println("FILE ID = "+vo.getFilesVO().getMemberVO().getId());
		
//		MemberVO vo = repository.findByIdAndPw("co", "co");
//		System.out.println(vo.getEmail() + " = email");
	
//		MemberFilesVO fvo = frepository.findById("co");
//		System.out.println(fvo.getFname() + " = fname");
		
		
		
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
