package com.coo.b2.notice;

import java.util.List;

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
@RequestMapping("/notice/**")
public class NoticeController {
	
	@ModelAttribute(name = "board")
	public String getBoard() throws Exception{
		return "notice";
	}
	
	@Autowired
	private NoticeService service;
	
	@GetMapping("NoticeSelect")
	public ModelAndView noticeSelect(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		noticeVO = service.noticeSelect(noticeVO);
		mv.addObject("notice", noticeVO);
		mv.setViewName("board/boardSelect");
		return mv;
	}
	
	@GetMapping("NoticeList")
	public ModelAndView noticeList(@PageableDefault(size = 10,page = 0)Pageable pageable, SqlPager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		Page<NoticeVO> list;
		if (pager.getKind() == "" || pager.getKind() == null) {			
			list = service.noticeList(pageable);
		}else {
			list = service.searchList(pager, pageable);
		}
		pager.makePager(list);
		mv.addObject("pager", pager);
		mv.addObject("list", list.getContent());
		mv.setViewName("board/boardList");
		
		return mv; 
	}
	
	@GetMapping("NoticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardVO", noticeVO);
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	@PostMapping("NoticeWrite")
	public ModelAndView noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		ModelAndView mv = new ModelAndView();
		String msg = "실패";
		String path = "notice/NoticeList";
		if (service.noticeWrite(noticeVO, files)) {
			msg = "성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/msg");
		
		return mv;
	}
}
