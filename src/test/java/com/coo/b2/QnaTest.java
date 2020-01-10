package com.coo.b2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coo.b2.qna.QnaFilesVO;
import com.coo.b2.qna.QnaRepository;
import com.coo.b2.qna.QnaService;
import com.coo.b2.qna.QnaVO;

@SpringBootTest
@Transactional
class QnaTest {

	@Autowired
	private QnaRepository repository;
	@Autowired
	private QnaService service;
	@Test
	void test() throws Exception {
		QnaVO vo = new QnaVO();
		
		List<Object[]> list =repository.qnaSelect(2);
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println("@@@@ = "+object);
			}
		}
		
		//repository.qnaUpdate("change", "chachange", 2);
		//service.qnaUpdate(vo);
		
		
//		List<QnaVO> list = repository.findList();
//		
//		for (QnaVO qnaVO : list) {
//			System.out.println("title = "+qnaVO.getTitle());
//			for (QnaFilesVO filesVO: qnaVO.getFilesList()) {
//				System.out.println("fname = "+filesVO.getFname());
//			}
//		}
		
//		vo.setNum(2);
//		
//		vo = repository.findOne(vo.getNum(),"co");
//		System.out.println("fname = "+ vo.getFilesList().get(0).getFname());
	}

}
