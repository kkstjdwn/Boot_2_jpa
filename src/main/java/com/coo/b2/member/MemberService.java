package com.coo.b2.member;

import java.io.File;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.coo.b2.util.FilePathGenerator;
import com.coo.b2.util.FileSaver;

@Service
public class MemberService {
	
	@Autowired
	private memberRepository repository;
	@Autowired
	private FilesRepository frepository;
	@Autowired
	private FileSaver saver;
	@Autowired
	private FilePathGenerator generator;
	
	
	public MemberVO memberSignIn(MemberVO memberVO) throws Exception{
		return repository.findByIdAndPw(memberVO.getId(), memberVO.getPw());
	}
	
	public MemberFilesVO getImg(MemberVO memberVO) throws Exception{
		return frepository.findById(memberVO.getId());
	}
	
	@Transactional
	public int memberSignUp(MemberVO memberVO, MultipartFile file) throws Exception{
		
		int check = 0;
		int result = 0;
		
		if (repository.existsById(memberVO.getId())) {
		}else {
			memberVO = repository.save(memberVO);
			if (memberVO.getName()!=null) {
				check = 1;
			}
		}
		
		if (check == 1) {
			File files = generator.useClassPathResource("imgs");
			MemberFilesVO filesVO = new MemberFilesVO();
			filesVO.setId(memberVO.getId());
			filesVO.setFname(saver.saver(files, file));
			filesVO.setOname(file.getOriginalFilename());
			
			filesVO = frepository.save(filesVO);
			
			if (filesVO.getFnum() > 0) {
				result = 1;
			}
		}
		
		return result;
	}
	
	public boolean signUpValidate(MemberVO memberVO, BindingResult br) throws Exception{
		return br.hasErrors();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
