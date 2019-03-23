package you.bacoder.kr.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.Board;
import you.bacoder.kr.vo.BookVO;
import you.bacoder.kr.vo.UserVO;

@Controller
public class BookController extends BacoderController {
	
	@RequestMapping(value="/book/list", method=RequestMethod.GET)
	public ModelAndView getListView(ModelAndView mv) {
		List<BookVO> list = bookService.select();
		mv.addObject("list", list);
		mv.setViewName("/book/list");
		return mv;
	}
	
	@RequestMapping(value="/book/detail", method=RequestMethod.GET)
	public ModelAndView getDetailView(ModelAndView mv,
			@RequestParam(value="id")int id,
			HttpServletRequest request) {
		UserVO user = getUser();
		if(user.getId() > 0) {
			mv.addObject("user", user);
		}
		final String deleteDir = new StringBuilder()
				.append(getWebappDir(request))
				.append("/")
				.append("book")
				.append("/")
				.append("deleteBoard")
				.toString();
		final String updateDir = new StringBuilder()
				.append(getWebappDir(request))
				.append("/")
				.append("book")
				.append("/")
				.append("update")
				.toString(); 
		
		mv.addObject("deleteDir", deleteDir);
		mv.addObject("updateDir", updateDir);
		
		BookVO input = new BookVO();
		input.setId(id);
		
		BookVO book = bookService.selectOne(input);
		mv.addObject("book", book);
		mv.setViewName("/book/detail");
		return mv;
	}
	
	@RequestMapping(value="/book/update", method=RequestMethod.GET)
	public ModelAndView getUpdateView(ModelAndView mv,
			@RequestParam(value="id")int id) {
		UserVO user = getUser();
		if(user.getId() > 0) {
			mv.addObject("user", user);
		}
		
		BookVO input = new BookVO();
		input.setId(id);
		
		BookVO book = bookService.selectOne(input);
		mv.addObject("book", book);
		
		mv.setViewName("/book/update");
		return mv;
	}
	
	@RequestMapping(value="/book/deleteBoard", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView deleteBook(ModelAndView mv, BookVO book, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		int result = bookService.delete(book);
		
		mv.setViewName("redirect:/book/list");
		return mv;
	}
	@RequestMapping(value="/book/insertBook", method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView writeBoard (ModelAndView mv, 
			BookVO book, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		logger.info(book.toString());
		
		int result = bookService.insert(book);
		
		if(result == 1) {
			// 글 작성에 성공
			mv.setViewName("redirect:/book/list");
		}else {
			// 글 작성에 실패
			mv.setViewName("redirect:/book/write");
		}
		
		return mv;
	}
	@RequestMapping(value="/book/write", method=RequestMethod.GET)
	public ModelAndView getWriteView(ModelAndView mv) {
		
		mv.setViewName("/book/write");
		return mv;
	}
}
