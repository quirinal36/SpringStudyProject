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

import you.bacoder.kr.vo.UserVO;

@Controller
public class AdminController extends BacoderController {

	@RequestMapping(value= {"/admin/list","/admin"}, method=RequestMethod.GET)
	public ModelAndView getUserList(ModelAndView mv, 
			HttpServletRequest req,
			@RequestParam(value="username", required=false)String username) {
		
		if(req.isUserInRole("ROLE_ADMIN")) {
			List<UserVO> list;
			if(username!=null && username.length()>0) {
				UserVO user = new UserVO();
				user.setUsername(username);
				mv.addObject("user", user);
				list = userService.select(user);
			}else {
				list = userService.select();
			}
			
			mv.addObject("list", list);
			mv.setViewName("/admin/list");
		}else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@RequestMapping(value= {"/admin/update"}, method= {RequestMethod.GET, RequestMethod.POST})
	public void getUserList(HttpServletRequest req,
			HttpServletResponse resp,
			UserVO user) throws IOException {
		if(req.isUserInRole("ROLE_ADMIN")) {
			logger.info(user.toString());
			int result = userService.update(user);
			resp.getWriter().append("{\"result\":" + result +"}");
		}
	}
}
