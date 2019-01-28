package you.bacoder.kr.control;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.Board;

@Controller
public class BoardController extends BacoderController {
	
	/**
	 * 게시판 리스트뷰
	 * @param mv
	 * @param writer
	 * @return
	 */
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView getBoardList(ModelAndView mv, 
			@RequestParam(value="writer", required=false)String writer) {
		
		List<Board> list = boardService.select();
		if(writer!=null && writer.length()>0) {
			Board board = new Board();
			board.setWriter(writer);
			mv.addObject("board", board);
			list = boardService.select(board);
		}else {
			
			list = boardService.select();
		}
		mv.addObject("list", list);
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
	@RequestMapping(value="/board/insertBoard", method=RequestMethod.GET)
	public void writeBoard (Board board, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		int result = boardService.insert(board);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		response.getWriter().append(json.toString());
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
	@RequestMapping(value="/board/deleteBoard", method=RequestMethod.GET)
	public void deleteBoard(Board board, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		int result = boardService.delete(board);
		
		JSONObject json = new JSONObject();
		json.put("result", result);
		response.getWriter().append(json.toString());
	}
	
	/**
	 * 상세보기 화면 
	 * 
	 * @param mv
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/board/detail", method=RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv, @RequestParam(value="id")Integer id) {
		Board board = boardService.selectOne(new Board(id));
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
