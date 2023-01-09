package edu.study.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

@Repository //�ܺ� �����Ϳ� �����ؼ� �ҷ����� ���� ������̼�
public class UserDao {
	
	@Autowired //�ڵ� ���� ���� => SqlSession sqlsession = new SqlSession();
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
