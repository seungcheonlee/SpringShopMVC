package com.spring01.ex.model.board;

import java.util.List;

public interface ReplyDAO {
	List<ReplyDTO> list(int board_idx, int start, int end); // 댓글 리슽 
	int count(int board_idx); // 댓글 갯수 
	void insert(ReplyDTO dto);
	void update(ReplyDTO dto);
	void delete(int idx);
	ReplyDTO detail(int idx);  // 댓글 상세보기 
}
