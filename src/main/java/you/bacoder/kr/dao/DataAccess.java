package you.bacoder.kr.dao;

import java.util.List;

public interface DataAccess<T> {
	// 입력
	public int insert(T input);
	// 수정
	public int update(T input);
	// 삭제
	public int delete(T input);
	// 전체조회
	public List<T> select();
	// 조건 조회
	public List<T> select(T input);
	// 특정 1건 조회
	public T selectOne(T input);
}
