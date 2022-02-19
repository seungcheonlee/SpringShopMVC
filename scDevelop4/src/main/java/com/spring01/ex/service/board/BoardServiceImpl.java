package com.spring01.ex.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring01.ex.model.board.BoardDAO;
import com.spring01.ex.model.board.BoardDTO;
@Service
public class BoardServiceImpl implements BoardService {
	@Inject
	BoardDAO boardDao;
	
	@Override
	public void delete_attach(String file_name) {
		boardDao.delete_attach(file_name);
	}

	@Override
	public List<String> list_attach(int bno) {
		return boardDao.list_attach(bno);
	}
	
	@Transactional
	@Override
	public void insert(BoardDTO dto) {
		boardDao.insert(dto); // 글쓰기 함수인데 글쓰기도하고 테이블에 첨부파일 추가도 할거임. 
		String[] files = dto.getFiles(); // 첨부파일이 여러개일 수 있어서 배열로 처리 
		if(files == null) 
			return;  // 첨부파일 없으면 글쓰기도 리턴시킴 
		for(String name : files) {  // 첨부파일까지 있을 때 for문 돌아서 넣음 
			boardDao.insert_attach(name);  // attach 테이블에 첨부파일 정보 저장 
		}
	}

	@Override
	public BoardDTO detail(int bno) {
		return boardDao.detail(bno);
	}
	
	@Transactional
	@Override
	public void update(BoardDTO dto) {
		boardDao.upadate(dto); // 수정도 글을 먼저 수정하고 첨부파일 수정함 @Transactional 처리 
		String[] files = dto.getFiles();
		if(files == null) {
			return;
		}
		for(String name : files) {
			boardDao.update_attach(name, dto.getIdx());
		}
	}

	@Override
	public void delete(int bno) {
		boardDao.delete(bno);
	}

	@Override
	public List<BoardDTO> list(int start, int end, String search_option, String keyword) {
		return boardDao.list(start, end, search_option, keyword);
	}

	@Override
	public void increase_hit(int bno) {
		boardDao.increase_hit(bno);
	}

	@Override
	public int count(String search_option, String keyword) {
		return boardDao.count(search_option, keyword);
	}

}
