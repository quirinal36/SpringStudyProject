package you.bacoder.kr.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController extends BacoderController {

	@RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
	public ModelAndView getIndexView(ModelAndView mv) {
		
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value= "/inc/head", method=RequestMethod.GET)
	public ModelAndView getHeadView(ModelAndView mv) {
		
		mv.setViewName("/inc/head");
		return mv;
	}
	
	@RequestMapping(value= "/inc/header", method=RequestMethod.GET)
	public ModelAndView getHeaderView(ModelAndView mv) {
		
		mv.setViewName("/inc/header");
		return mv;
	}
}
