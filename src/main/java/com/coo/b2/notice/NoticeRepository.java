package com.coo.b2.notice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<NoticeVO, Integer>{
	
	Page<NoticeVO> findByNumGreaterThanOrderByNumDesc(Integer num, Pageable pageable) throws Exception;
	
}
