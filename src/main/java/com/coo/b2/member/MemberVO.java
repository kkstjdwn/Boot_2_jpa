package com.coo.b2.member;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "members")
public class MemberVO {
	
	/** */
	
	@Id
	@NotEmpty
	private String id;
	//@Column(name = "pw") 변수명과 컬럼명이 다르다면 네임 속성을 주면 된다
	private String pw;
	@Transient
	private String pw2;
	private String name;
	private String email;
	@OneToOne(mappedBy = "memberVO", cascade = CascadeType.ALL) // join 하는 Entity에 선언된 자기 자신의 Entity명(멤버변수명)
	private MemberFilesVO filesVO;
	
}
