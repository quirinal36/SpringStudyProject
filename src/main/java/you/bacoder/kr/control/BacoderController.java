package you.bacoder.kr.control;

import javax.annotation.Resource;

import you.bacoder.kr.dao.BoardDAO;
import you.bacoder.kr.service.BoardService;

public class BacoderController {
	
	@Resource(name="boardService")
	protected BoardService boardService;
}
