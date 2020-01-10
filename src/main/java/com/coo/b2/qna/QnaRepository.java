package com.coo.b2.qna;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QnaRepository extends JpaRepository<QnaVO, Integer> {
	Page<QnaVO> findByNumGreaterThan(Integer num,Pageable pageable) throws Exception;
	
	@Query("select q from QnaVO q order by q.ref desc, q.step asc")
	List<QnaVO> findList() throws Exception;
	
//	@Query("select q from QnaVO q where num = ?1")
//	QnaVO findOne(int num) throws Exception;
	
	@Query("select q from QnaVO q where num = :num and writer= :w ")
	QnaVO findOne(@Param("num")int num, @Param("w")String writer) throws Exception;
	
	@Modifying(clearAutomatically = true)
	@Query("update QnaVO q set q.title=:tt , q.contents=:ct where num=:num")
	void qnaUpdate(@Param("tt")String title, @Param("ct")String contents, @Param("num")int num) throws Exception;
	
//	@Modifying(clearAutomatically = true)
//	@Query(value = "update QnaVO q set q.title=?1 , q.contents=?2 where num=?3",nativeQuery = true)
//	void qnaUpdatwo(String title, String contents, int num) throws Exception;
	
	@Query("select q.writer, q.contents from QnaVO q where num=?1")
	List<Object[]> qnaSelect(int num) throws Exception;
}
