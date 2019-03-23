package you.bacoder.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import you.bacoder.kr.dao.BookDAO;
import you.bacoder.kr.vo.BookVO;

@Component("bookService")
public class BookService implements DataService<BookVO> {
	@Autowired
	BookDAO dao;
	
	@Override
	public int insert(BookVO input) {
		return dao.insert(input);
	}

	@Override
	public int update(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BookVO input) {
		return dao.delete(input);
	}

	@Override
	public List<BookVO> select() {
		return dao.select();
	}

	@Override
	public List<BookVO> select(BookVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO selectOne(BookVO input) {
		return dao.selectOne(input);
	}

	@Override
	public int count(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
