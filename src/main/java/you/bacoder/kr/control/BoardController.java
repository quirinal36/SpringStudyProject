package you.bacoder.kr.control;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.Board;

@Controller
public class BoardController extends BacoderController {
	
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
	
}
