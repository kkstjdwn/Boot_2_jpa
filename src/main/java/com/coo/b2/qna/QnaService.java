package com.coo.b2.qna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coo.b2.util.FilePathGenerator;
import com.coo.b2.util.FileSaver;

@Service
@Transactional
public class QnaService {
	@Autowired
	private QnaRepository repository;
	
	@Autowired
	private FilePathGenerator generator;
	@Autowired
	private FileSaver saver;
	
	public boolean qnaWrite(QnaVO qnaVO, MultipartFile[] files) throws Exception{
		File save = generator.useClassPathResource("board");
		int count = files.length;
		System.out.println("@@@@@@@@@count의 크기 = "+count);
		if (count > 0) {
			List<QnaFilesVO> list = new ArrayList<QnaFilesVO>();
			for (MultipartFile multipartFile : files) {
				if (multipartFile.getSize() > 0 && count != files.length) {
					QnaFilesVO fvo = new QnaFilesVO();
					fvo.setQnaVO(qnaVO);
					fvo.setFname(saver.saver(save, multipartFile));
					fvo.setOname(multipartFile.getOriginalFilename());
					list.add(fvo);
				}else {
					count--;
				}
			}
		
			qnaVO.setFilesList(list);
		}
		
		qnaVO=repository.save(qnaVO);
		Thread.sleep(100);
		qnaVO.setRef(qnaVO.getNum());
		qnaVO=repository.save(qnaVO);
		Thread.sleep(100);
		qnaVO=repository.findById(qnaVO.getNum()).get();
		if (qnaVO.getTitle() == "" || qnaVO.getTitle() == null) {
			return false;
		}else {
			return true;
		}
	}
	
	
	public Page<QnaVO> qnaList(Pageable pageable) throws Exception{
		pageable = PageRequest.of(0, 10, Sort.by("ref").descending().and(Sort.by("step").ascending()));
		Page<QnaVO> list = repository.findByNumGreaterThan(0, pageable);
		for (QnaVO qnaVO : list) {
			qnaVO.getFilesList();
		}
		return list;
	}
	
	
	public void qnaUpdate(QnaVO qnaVO) throws Exception{
		repository.qnaUpdate("change", "chachange", 2);
		
	}
}
