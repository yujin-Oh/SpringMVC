package edu.study.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;

@Repository //시스템 외부에 있는 곳에서 데이터 접근을 하기 때문에 레파지토리 사용.
public class BoardDao {
	
	@Autowired
	private SqlSession sqlSession;
	//구문객체를 root-context에 넣어둠, 그것을 불러와 사용

	public List<BoardVO> list(SearchVO vo){
		
		return sqlSession.selectList("edu.study.mapper.boardMapper.list", vo);
		//여기서는 selectone을 쓸 수 없음
	}
	
	
	public BoardVO selectByBidx(int bidx) {
		//statement(쿼리의 위치), parameter(넘길 값)
		return sqlSession.selectOne("edu.study.mapper.boardMapper.selectByBidx", bidx);
	}
	
	public int updateByBidx(BoardVO vo) {
		return sqlSession.update("edu.study.mapper.boardMapper.updateByBidx", vo);
	}
	//행의 count 값을 반환. 이때 이 결과는 sql이 아닌 mybatis에서 제공해주는 값이다.
	
	public int deleteByBidx(int bidx) {
		return sqlSession.delete("edu.study.mapper.boardMapper.deleteByBidx", bidx);
	}
	
	public int deleteFromReply(int bidx) {
		return sqlSession.delete("edu.study.mapper.boardMapper.deleteFromReply", bidx);
	}

	public int insert(BoardVO vo) {
		return sqlSession.insert("edu.study.mapper.boardMapper.insert", vo);
	}
	
	public int maxBidx() {
		return sqlSession.selectOne("edu.study.mapper.boardMapper.maxBidx");
	}

}


