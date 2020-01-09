package com.coo.b2;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coo.b2.notice.NoticeFilesVO;
import com.coo.b2.notice.NoticeRepository;
import com.coo.b2.notice.NoticeVO;
@SpringBootTest
class BoardTest {
	@Autowired
	private NoticeRepository repository;
	
	@Test
	@Transactional
	void test() {
		NoticeVO vo = repository.findById(8).get();
		if (vo.getFilesList().size() != 0 ) {			
			for (NoticeFilesVO filesVO : vo.getFilesList()) {
				System.out.println("FNAME = " + filesVO.getFname());
			}
		}
	}

}
