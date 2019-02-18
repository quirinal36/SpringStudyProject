package you.bacoder.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import you.bacoder.kr.dao.DataAccess;
import you.bacoder.kr.dao.UserDAO;
import you.bacoder.kr.vo.UserVO;

@Component("userService")
public class UserService implements DataService<UserVO> {
	@Autowired
	private UserDAO dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public int insert(UserVO input) {
		input.setUser_role(2); // ROLE_USER 부여함
		input.setPassword(passwordEncoder.encode(input.getPassword()));
		return dao.insert(input);
	}

	@Override
	public int update(UserVO input) {
		return dao.update(input);
	}

	@Override
	public int delete(UserVO input) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserVO> select() {
		return dao.select();
	}

	@Override
	public List<UserVO> select(UserVO input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO selectOne(UserVO input) {
		return dao.selectOne(input);
	}

	@Override
	public int count(UserVO input) {
		return 0;
	}
	
}
