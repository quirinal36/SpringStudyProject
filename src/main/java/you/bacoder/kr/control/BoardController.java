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
			@RequestParam(value="search", required=false)Optional<String> search) {
		List<Board> list = boardService.select();
		if(search!=null && search.isPresent()) {
			mv.addObject("search", search.get());
		}
		mv.addObject("list", list);
		return mv;
	}
	
}
