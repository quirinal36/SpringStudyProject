package you.bacoder.kr.control;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import you.bacoder.kr.service.BoardService;
import you.bacoder.kr.service.UserService;

public class BacoderController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="boardService")
	protected BoardService boardService;
	
	@Resource(name="userService")
	protected UserService userService;
}
