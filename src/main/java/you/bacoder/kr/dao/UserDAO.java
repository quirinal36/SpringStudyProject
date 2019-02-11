package you.bacoder.kr.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import you.bacoder.kr.vo.UserVO;

@Repository("UserDAO")
public class UserDAO implements DataAccess<UserVO> {
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String namespace = "user_sql";
	
	@Override
	public int insert(UserVO input) {
		return sqlSession.insert(namespace+".insert", input);
	}

	@Override
	public int update(UserVO input) {
		return sqlSession.update(namespace +".update", input);
	}

	@Override
	public int delete(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> select() {
		return sqlSession.selectList(namespace +".select_all");
	}

	@Override
	public List<UserVO> select(UserVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectOne(UserVO input) {
		return sqlSession.selectOne(namespace+".selectOne", input);
	}
	
	public UserVO login(UserVO input) {
		if(input.getLogin()!=null && input.getLogin().length()>0) {
			return sqlSession.selectOne(namespace +".login", input);
		}else {
			return null;
		}
	}
}
