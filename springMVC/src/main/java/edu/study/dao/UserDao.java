package edu.study.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

@Repository //외부 데이터에 접근해서 불러오기 위한 어노테이션
public class UserDao {
	
	@Autowired //자동 의존 주입 => SqlSession sqlsession = new SqlSession();
	private SqlSession sqlSession;
	
	public List<UserVO> list(){
		
		return sqlSession.selectList("edu.study.mapper.userMapper.list");
	}
	
	public UserVO selectByUidx(int uidx) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.selectByUidx", uidx);
	}

	public int updateByUidx(UserVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("edu.study.mapper.userMapper.updateByUidx", vo);
	}
	
	public UserVO login(UserVO vo) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.login", vo);
	}
	
	public int selectById(String id) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.selectById", id);
	}
	
	public int join(UserVO vo) {
		return sqlSession.insert("edu.study.mapper.userMapper.join", vo);
	}

	
}
