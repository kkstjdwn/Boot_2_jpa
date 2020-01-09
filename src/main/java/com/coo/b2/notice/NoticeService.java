package com.coo.b2.notice;



import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.coo.b2.util.FilePathGenerator;
import com.coo.b2.util.FileSaver;
@Service
@Transactional
public class NoticeService {
	
	@Autowired
	private NoticeRepository repository;
	
	@Autowired
	private NoticeFilesRepository frepository;
	
	@Autowired
	private FilePathGenerator generator;
	
	@Autowired
	private FileSaver saver;
	
	public NoticeVO noticeSelect(NoticeVO noticeVO) throws Exception{ // (@RequestParam(defaultValue = 1) Integer num)
		noticeVO = repository.findById(noticeVO.getNum()).get();
		noticeVO.getFilesList();
		return noticeVO;
	}
	
	public Page<NoticeVO> noticeList(Pageable pageable) throws Exception{
		Page<NoticeVO> ar = repository.findByNumGreaterThanOrderByNumDesc(0, pageable);
		for (NoticeVO noticeVO : ar) {
			noticeVO.getFilesList();
		}
		return ar;
	}
	
	public boolean noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		File file = generator.useClassPathResource("board");
		int count = files.length;
		
		if (files.length > 0) {
			List<NoticeFilesVO> flist = new ArrayList<NoticeFilesVO>();
			for (MultipartFile multipartFile : files) {
				if (count != files.length) {					
					NoticeFilesVO fvo = new NoticeFilesVO();
					fvo.setNoticeVO(noticeVO);
					if (multipartFile.getSize() > 0 ) {						
						fvo.setFname(saver.saver(file, multipartFile));
						fvo.setOname(multipartFile.getOriginalFilename());
						flist.add(fvo);
					}
					count--;
				}else {
					count--;
				}
			}
			noticeVO.setFilesList(flist);
		}
		noticeVO.setHit(0);
		noticeVO = repository.save(noticeVO);
		Thread.sleep(100);
		noticeVO = repository.findById(noticeVO.getNum()).get();
		if (noticeVO.getTitle() != null) {
			return true;
		}else {
			return false;
		}
//		File file = generator.useClassPathResource("board");
//		int count = files.length;
//		noticeVO = repository.save(noticeVO);
//		Thread.sleep(100);
//		noticeVO = repository.findById(noticeVO.getNum()).get();
//		List<NoticeFilesVO> flist = new ArrayList<NoticeFilesVO>();
//		
//		if (files.length > 0) {
//			for (MultipartFile multipartFile : files) {
//				if (count != files.length) {					
//					NoticeFilesVO fvo = new NoticeFilesVO();
//					fvo.setNoticeVO(noticeVO);
//					fvo.setFname(saver.saver(file, multipartFile));
//					fvo.setOname(multipartFile.getOriginalFilename());
//					flist.add(fvo);
//					count--;
//				}else {
//					count--;
//				}
//			}
//			
//			noticeVO.setFilesList(frepository.saveAll(flist));
//			if (noticeVO.getFilesList().size() != 0) {
//				return true;
//			}else {
//				return false;
//			}
//		}else {
//			if (noticeVO.getTitle() != null) {
//				return true;
//			}else {
//				return false;
//			}
//		}
	}
	
}
