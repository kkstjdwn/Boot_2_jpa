package com.coo.b2.qna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.coo.b2.util.SqlPager;

@Controller
@RequestMapping("qna/**")
public class QnaController {
	
	@ModelAttribute(name = "board")
	public String getBoard() throws Exception {
		return "Qna";
	}
	
	@Autowired
	private QnaService service;
	
	@GetMapping("QnaWrite")
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardVO", qnaVO);
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("QnaWrite")
	public ModelAndView qnaWrite(QnaVO qnaVO,MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		String msg = "실패";
		String path = "/";
		if (service.qnaWrite(qnaVO, files)) {
			msg = "성공";
		}
		
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/msg");
		return mv;
	}
	
	@GetMapping("QnaList")
	public ModelAndView qnaList(@PageableDefault(size = 10,page = 0)Pageable pageable, SqlPager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		Page<QnaVO> list;
		//if (pager.getKind() == "" || pager.getKind() == null) {
			list = service.qnaList(pageable);
		//}
		pager.makePager(list);
		mv.addObject("pager", pager);
		mv.addObject("list", list.getContent());
		mv.setViewName("board/boardList");
		
		return mv;
	}
}
