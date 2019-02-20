package you.bacoder.kr.control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.BookVO;

@Controller
public class BookController extends BacoderController {
	
	@RequestMapping(value="/book/list")
	public ModelAndView getListView(ModelAndView mv) {
		List<BookVO> list = bookService.select();
		mv.addObject("list", list);
		mv.setViewName("/book/list");
		return mv;
	}
	
	@RequestMapping(value="/book/detail")
	public ModelAndView getDetailView(ModelAndView mv,
			@RequestParam(value="id")int id) {
		BookVO input = new BookVO();
		input.setId(id);
		
		BookVO book = bookService.selectOne(input);
		mv.addObject("book", book);
		return mv;
	}
}
