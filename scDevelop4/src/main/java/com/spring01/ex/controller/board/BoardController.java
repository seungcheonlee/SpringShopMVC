//package com.spring01.ex.controller.board;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.spring01.ex.model.board.BoardDTO;
//import com.spring01.ex.model.board.ReplyDAO;
//import com.spring01.ex.service.board.BoardService;
//import com.spring01.ex.service.board.PageUtil;
//
//@Controller
//@RequestMapping("/board/*")
//public class BoardController {
//	@Inject
//	BoardService boardService;
//	
//	@Inject  // 댓글 처리위해 의존주입 추가함 
//	ReplyDAO replyDao;
//	
//	@RequestMapping("write")
//	public String write() {
//		return "board/write";
//	}
//	
//	@RequestMapping("insert")
//	public String insert(BoardDTO dto, HttpSession session) {
//		String writer = (String)session.getAttribute("userid"); // 로그인 안했으면 로그인 먼저 하게끔 session 검사하기
//		dto.setWriter(writer); // 셋팅 
//		boardService.insert(dto);  // 저장 
//		return "redirect:/board/list";// 셋팅 저장하고 목록으로 
//	}
//	
//	@RequestMapping("list")
//	public ModelAndView list(
//			@RequestParam(defaultValue = "1") int curPage,  // 현재 페이지 기본값은 1 
//			@RequestParam(defaultValue = "all") String search_option,  // 검색 옵션 기본값은 전체 검색 
//			@RequestParam(defaultValue="") String keyword) { // 키워드는 빈값으로 디폴트 설정 
//		int count = boardService.count(search_option, keyword); // 글 갯수 계산 
//		PageUtil page_info = new PageUtil(count, curPage); // 원하는 페이지의 글 갯수를 던지면 정보가 나옴 PageUtil 메소드를 짜놔서 그럼 
//		int start = page_info.getPageBegin(); // 레코드 시작 번호 
//		int end = page_info.getPageEnd();  // 레코드 끝 번호 
//		List<BoardDTO> list = boardService.list(start, end, search_option, keyword);  // 그에 맞는 리스트 출력 
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("board/list");
//		Map<String, Object> map = new HashMap<>();  // Map으로 정보 저장 (ModelAndView의 데이터로 저장하기 위해) 
//		map.put("list", list);
//		map.put("count", count);
//		map.put("search_option", search_option);
//		map.put("keyword", keyword);
//		map.put("page_info", page_info);
//		mav.addObject("map", map);
//		return mav;
//	}
//	
//	@RequestMapping("detail")
//	public ModelAndView detail(int idx, int cur_page, String search_option, String keyword) {
//		boardService.increase_hit(idx); // 조회수 증가 처리 (상세보기 들어가면 일단 조회수 증가 처리 해줘야지) 
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("board/view");
//		mav.addObject("dto", boardService.detail(idx));  // 상세내용 
//		mav.addObject("count", replyDao.count(idx));  // 댓글 갯수 ( 댓글 몇개인지) 
//		mav.addObject("cur_page", cur_page);  // 페이지 번호 
//		mav.addObject("search_option", search_option);  // 검색 옵션 
//		mav.addObject("keyword", keyword);  // 키워드 
//		return mav;
//	}
//	
//	@RequestMapping("update")
//	public String update(BoardDTO dto) {
//		boardService.update(dto);
//		return "redirect:/board/list";
//	}
//	
//	@RequestMapping("delete")
//	public String delete(int idx) {
//		boardService.delete(idx);
//		return "redirect:/board/list";
//	}
//	
//	@RequestMapping("list_attach/{idx}")  // 첨부파일 리스트임. 주소에  idx가 들어감. 주소에 포함되는 변수임
//	@ResponseBody // 데이터를 json 으로 리턴함 
//	public List<String> list_attach(@PathVariable("idx") int idx){
//		return boardService.list_attach(idx);
//	}
//	
//}
