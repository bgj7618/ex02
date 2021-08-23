package org.zerock.mapper;
import java.util.ArrayList;

//	DAO
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.controller.HomeController;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	private static final Logger logger = LoggerFactory.getLogger(BoardMapperTests.class);
	
	@Autowired
	private BoardMapper mapper;
	
//	@Test	// 글 리스트
//	public void testGetList() {
//		mapper.getList().forEach(board->logger.info(""+board));
//	}
	@Test	// 글쓰기
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		//mapper.insert(board);		// 글쓰기 1
		mapper.insertSelectKey(board);	// insert문 실행, 글쓰기2
		
		logger.info(""+board);
	}
	
	@Test	// 글 상세페이지
	public void testRead() {
		BoardVO board = mapper.read(4);	// 해당 번호 게시물
		logger.info(""+board);
	}
	
	@Test	// 글 삭제
	public void testDelete() {
		//logger.info("DELETE COUNT: "+ mapper.delete(3));	// 3번글 선택
		mapper.delete(7);
	}
	
	@Test	// 글 수정
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(8);	// 8번글 수정
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		//board.setWriter("user1");
		boolean count = mapper.update(board);
		logger.info("UPDATE COUNT: "+ count);
	}
	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		ArrayList<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}

