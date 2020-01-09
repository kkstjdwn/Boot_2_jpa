package com.coo.b2.util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class SqlPager {
	
	private Integer curPage;
	private Integer perPage=8;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer perBlock;
	private Integer totalBlock;
	private Integer totalPage;

//	public void makeRow(Page<NoticeVO> list) throws Exception{
//		this.perPage = list.getSize();
//		this.startRow = list.getNumber()*this.perPage;
//	}
//	
//	public void makePager(Page<NoticeVO> list) throws Exception{
//		
//		this.perBlock = 10;
//		
//		this.totalPage = list.getTotalPages() / this.perPage;
//		
//		if (list.getTotalPages()%this.perPage !=0) {
//			this.totalPage++;
//		}
//		
//		totalBlock = totalPage/this.perBlock;
//		if (totalPage%perBlock!=0) {
//			totalBlock++;
//		}
//
//		//4.curPage 이용햇 현재 블록curBlock 표시
//
//		curBlock = list.getNumber()/this.perBlock;
//		if (list.getNumber()%perBlock != 0) {
//			curBlock++;
//		}
//		
//		//5.curBlock 이용해서 startNum, lastNum 구하기
//		this.startNum = (curBlock-1)*this.perBlock + 1; 
//		this.lastNum = curBlock*this.perBlock;
//		
//		if (curBlock==totalBlock) {
//			lastNum = totalPage;
//		}
//		if (totalPage ==0) {
//			lastNum = 1;
//		}
//	}
	
	public void makePager(Page<? extends Object> list)throws Exception{
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(list.getNumber()+"= getNumber");
		System.out.println(list.getNumberOfElements()+"= getNumberOfElements");
		System.out.println(list.getTotalElements()+"= getTotalElements");
		
		
		
		this.curPage = list.getNumber()+1;
		this.perBlock = 5;
		
		this.totalPage = (int)(list.getTotalElements() / list.getSize());
		
		if (list.getTotalElements() % list.getSize() != 0) {
			this.totalPage++;
		}
		
		this.totalBlock = this.totalPage / this.perBlock;
		if (this.totalPage%this.perBlock!=0) {
			this.totalBlock++;
		}
		
		this.curBlock = list.getNumber() / this.perBlock;
//		if (list.getNumber() % this.perBlock !=0) {
//			this.curBlock++;
//		}
		//5.curBlock 이용해서 startNum, lastNum 구하기
		this.startNum = (this.curBlock)*this.perBlock + 1; 
		this.lastNum = this.curBlock+1*this.perBlock;
		System.out.println(this.totalPage+" = totalPage");
		System.out.println(this.startNum+" = startNum");
		System.out.println(this.lastNum + " = lastNum");
		System.out.println(this.curBlock + " = curBlock");
		System.out.println(this.totalBlock+ " = totalBlock");
		
		if (this.curBlock==this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		if (this.totalPage ==0) {
			this.lastNum = 1;
		}
		
	}
	
 	
	
}
