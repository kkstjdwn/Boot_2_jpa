package com.coo.b2.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coo.b2.board.BoardVO;

import lombok.Data;



@Entity
@Table(name = "notice")
@Data
public class NoticeVO extends BoardVO{
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "noticeVO",fetch = FetchType.LAZY)
	private List<NoticeFilesVO> filesList;
}
	
