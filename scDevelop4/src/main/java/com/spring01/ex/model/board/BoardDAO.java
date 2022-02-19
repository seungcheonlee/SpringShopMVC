package com.spring01.ex.model.board;

import java.util.List;

public interface BoardDAO {
	void delete_attach(String file_name);  // 첨부파일 삭제 
	List<String> list_attach(int idx);  // 첨부파일 리스트 
	void insert_attach(String file_name);  // 첨부파일 추가 
	void update_attach(String file_name, int idx);
	void insert(BoardDTO dto);  //글쓰기 
	void upadate(BoardDTO dto);
	BoardDTO detail(int idx);
	void delete(int idx);
	List<BoardDTO> list(int start, int end, String search_option, String keyword);// 글 목록, 페이지 나누기, 검색 모두 들어감 
	void increase_hit(int idx); // 조회수 증가 처리 
	int count(String search_option, String keyword); // 글갯수 
	

}
