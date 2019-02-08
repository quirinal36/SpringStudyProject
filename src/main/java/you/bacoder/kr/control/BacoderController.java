package you.bacoder.kr.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import you.bacoder.kr.security.AuthenticationFacade;
import you.bacoder.kr.service.BoardService;
import you.bacoder.kr.service.UserService;
import you.bacoder.kr.vo.UserVO;

public class BacoderController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
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
}
