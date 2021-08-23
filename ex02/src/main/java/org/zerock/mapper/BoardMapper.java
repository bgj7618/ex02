package org.zerock.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	public ArrayList<BoardVO> getList();	// 글 목록
	public ArrayList<BoardVO> getListWithPaging(Criteria cri);	// 글 목록+페이징처리
	public int getTotalCount(Criteria cri);
	public void insert(BoardVO board);
	public void insertSelectKey(BoardVO board);	// 글쓰기
	public BoardVO read(int bno);	// 글 상세페이지
	public boolean delete(int bno);	
	public boolean update(BoardVO board); //각각 매개변수 넣어도되지만, 클래스가 용량이 더욱 낮아서 씀.(클=4or8)
	// 댓글 건수 update
	public void updateReplycnt(@Param("bno")int bno, @Param("amount")int amount);
}

// BoardMapper.xml에서 sql문 받아서 정보를 jsp로 리턴