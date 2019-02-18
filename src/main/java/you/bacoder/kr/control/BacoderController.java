package you.bacoder.kr.control;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import you.bacoder.kr.security.AuthenticationFacade;
import you.bacoder.kr.service.BoardService;
import you.bacoder.kr.service.UserService;
import you.bacoder.kr.vo.UserVO;

public class BacoderController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected ApplicationContext appContext;
	
	@Resource(name="boardService")
	protected BoardService boardService;
	
	@Resource(name="userService")
	protected UserService userService;
	
	@Autowired
	protected AuthenticationFacade authenticationFacade;
	
	public UserVO getUser() {
		String authUser = authenticationFacade.getAuthentication().getName();
		logger.info("authUser: " + authUser);
		UserVO searchUser = new UserVO();
		searchUser.setLogin(authUser);
		UserVO user = userService.selectOne(searchUser);
		return user;
	}
	public String getWebappDir(HttpServletRequest request) {
		return request.getContextPath();
		
	}
}
