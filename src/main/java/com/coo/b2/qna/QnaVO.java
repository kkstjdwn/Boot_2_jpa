package com.coo.b2.qna;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coo.b2.board.BoardVO;

import lombok.Data;

@Entity
@Table(name = "qna")
@Data
public class QnaVO extends BoardVO{
	private int ref;
	private int step;
	private int depth;
	
	@OneToMany(mappedBy = "qnaVO", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<QnaFilesVO> filesList;
}
