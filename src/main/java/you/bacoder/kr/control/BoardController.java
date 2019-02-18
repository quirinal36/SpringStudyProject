package you.bacoder.kr.control;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.Board;
import you.bacoder.kr.vo.UserVO;

@Controller
public class BoardController extends BacoderController {
	/**
	 * 게시판 리스트뷰
	 * @param mv
	 * @param writer
	 * @return
	 */
	@RequestMapping(value= {"/board/list","/board"}, method=RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, 
			@RequestParam(value="search", required=false)String search,
			@RequestParam(value="page", required=false)Optional<Integer> pageNum,
			@RequestParam(value="orderById", required=false)Optional<Integer> orderById ) {
		List<Board> list;
		
		Board board;
		if(pageNum.isPresent()) {
			board = new Board(0, pageNum.get());	
		}else {
			board = new Board(0, 1);
		}
		if(orderById.isPresent()) {
			board.setOrderById(orderById.get());
		}
		
		board.setSearch(search);
		mv.addObject("pageNum", board.getPageNo());
		
		board.setTotalCount(boardService.count(board));
		
		logger.info(board.toString());
		
		list = boardService.select(board);
		mv.addObject("board", board);
		mv.addObject("list", list);
		mv.setViewName("/board/list");
		return mv;
	}
	
	/**
	 * 게시판 글 입력 뷰
	 * 
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public ModelAndView getWriteView(ModelAndView mv) {
		UserVO user = getUser();
		mv.addObject("user", user);
		mv.setViewName("/board/write");
		return mv;
	}
	
	/**
	 * 게시판 글 입력 프로시져
	 * 
	 * @param board : form 에 있는 정보를 맵핑해 전달한다
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="/board/insertBoard", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView writeBoard (ModelAndView mv, 
			Board board, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		logger.info(board.toString());
		
		int result = boardService.insert(board);
		
		if(result == 1) {
			// 글 작성에 성공
			mv.setViewName("redirect:/board");
		}else {
			// 글 작성에 실패
			mv.setViewName("redirect:/board/write");
		}
		
		return mv;
	}
	/**
	 * 게시판 글 수정하기 
	 * 
	 * @param board
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="/board/updateBoard", method=RequestMethod.GET)
	public void updateBoard(Board board, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		int result = boardService.update(board);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		response.getWriter().append(json.toString());
	}
	@RequestMapping(value="/board/deleteBoard", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteBoard(ModelAndView mv, Board board, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		int result = boardService.delete(board);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		response.getWriter().append(json.toString());
		
		mv.setViewName("redirect:/board");
		return mv;
	}
	
	/**
	 * 상세보기 화면 
	 * 
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv, @RequestParam(value="id")Integer id,
			HttpServletRequest request) {
		UserVO user = getUser();
		if(user.getId() > 0) {
			mv.addObject("user", user);
		}
		
		Board board = boardService.selectOne(new Board(id));
		
		final String deleteDir = new StringBuilder()
				.append(getWebappDir(request))
				.append("/")
				.append("board")
				.append("/")
				.append("deleteBoard")
				.toString();
		final String updateDir = new StringBuilder()
				.append(getWebappDir(request))
				.append("/")
				.append("board")
				.append("/")
				.append("update")
				.toString(); 
		
		mv.addObject("deleteDir", deleteDir);
		mv.addObject("updateDir", updateDir);
		mv.addObject("board", board);
		mv.setViewName("/board/detail");
		return mv;
	}
	@RequestMapping(value="/board/update", method=RequestMethod.GET)
	public ModelAndView getUpdateView(ModelAndView mv, @RequestParam(value="id")Integer id) {
		Board board = boardService.selectOne(new Board(id));
		mv.addObject("board", board);
		mv.setViewName("/board/update");
		return mv;
	}
}
