package you.bacoder.kr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import you.bacoder.kr.vo.BookVO;

@Repository("BookDAO")
public class BookDAO implements DataAccess<BookVO>{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "book_sql";
	
	@Override
	public int insert(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BookVO> select() {
		return sqlSession.selectList(namespace + ".select_all");
	}

	@Override
	public List<BookVO> select(BookVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO selectOne(BookVO input) {
		return sqlSession.selectOne(namespace +".select_one", input);
	}

	@Override
	public int count(BookVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

}
