package you.bacoder.kr.control;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import you.bacoder.kr.vo.UserVO;

@Controller
public class UserController extends BacoderController {
	/**
	 * 회원가입 - 정보입력
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/sign/signup", method=RequestMethod.GET)
	public ModelAndView getJoinStep2View(ModelAndView mv, UserVO user) {
		mv.addObject("user", user);
		mv.setViewName("/sign/signup");
		return mv;
	}
	
	@RequestMapping(value="/sign/insert", method=RequestMethod.POST)
	public ModelAndView memberInsert(ModelAndView mv, UserVO user, HttpServletResponse resp) throws IOException {
		logger.info(user.toString());
		
		int result = userService.insert(user);
		
		mv.addObject("user", user);
		if(result > 0) {
			mv.setViewName("redirect:/sign/join_complete");	
		}else {
			mv.setViewName("redirect:/sign/signup");
		}
		
		return mv;
	}
	/**
	 * 회원가입 - 정보입력
	 * @param mv
	 * @return
	 */
	@RequestMapping(value="/sign/join_complete", method=RequestMethod.GET)
	public ModelAndView getJoinCompleteView(ModelAndView mv) {
		mv.setViewName("/sign/join_complete");
		return mv;
	}
	
	/**
	 * 로그인
	 * @param mv
	 * @return
	 */
	@RequestMapping(value= {"/sign/login", "login"}, method= {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getLoginView(ModelAndView mv,
			@RequestParam(value = "loginid", required = false) String loginId,
			@RequestParam(value = "loginRedirect", required = false) String redirectUrl) {
		if (loginId != null) {
			mv.addObject("loginid", loginId);
		}
		if (redirectUrl != null) {
			mv.addObject("loginRedirect", redirectUrl);
		}
		mv.setViewName("/sign/login");
		return mv;
	}
	
	@RequestMapping(value= {"/sign/update"}, method= {RequestMethod.GET})
	public ModelAndView getUpdateView(ModelAndView mv) {
		return mv;
	}
}
