package you.bacoder.kr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import you.bacoder.kr.vo.Board;

@Repository("BoardDAO")
public class BoardDAO implements DataAccess<Board> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private String namespace = "board_sql";
	
	@Override
	public int insert(Board input) {
		return sqlSession.insert(namespace +".insert", input);
	}

	@Override
	public int update(Board input) {
		return sqlSession.update(namespace + ".update", input);
	}

	@Override
	public int delete(Board input) {
		return sqlSession.delete(namespace+".delete", input);
	}

	@Override
	public List<Board> select() {
		return sqlSession.selectList(namespace +".select_all");
	}

	@Override
	public List<Board> select(Board input) {
		return sqlSession.selectList(namespace +".select", input);
	}

	@Override
	public Board selectOne(Board input) {
		return sqlSession.selectOne(namespace +".select_one", input);
	}

	@Override
	public int count(Board input) {
		return sqlSession.selectOne(namespace +".count", input);
	}

}
