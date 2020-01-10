package com.coo.b2.notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{
	
	Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(Integer num, Pageable pageable) throws Exception;
	
	Page<NoticeVO> findByTitleContainingAndNumGreaterThanOrderByNumDesc(String title, Integer num, Pageable pageable) throws Exception;
	
	Page<NoticeVO> findByWriterContainingAndNumGreaterThanOrderByNumDesc(String writer, Integer num, Pageable pageable) throws Exception;
	
	Page<NoticeVO> findByContentsContainingAndNumGreaterThanOrderByNumDesc(String contents, Integer num, Pageable pageable) throws Exception;
	
}
