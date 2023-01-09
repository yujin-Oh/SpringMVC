package edu.study.service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.study.dao.BoardDao;
import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;

@Service  //ico에게 구현객체라는 것을 알리기 위해 서비스 어노테이션을 준다. 
public class BoardServiceImpl implements BoardService {

	@Autowired 
	private BoardDao boardDao;
	
	@Override
	public List<BoardVO> list(SearchVO vo) {
		// TODO Auto-generated method stub
		
		List<BoardVO> list = boardDao.list(vo);
		
		return list;
	}

	@Override
	public BoardVO selectByBidx(int bidx) {
		// TODO Auto-generated method stub
		return boardDao.selectByBidx(bidx);
	}

	@Override
	public int updateByBidx(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDao.updateByBidx(vo);
	}

	@Override
	public int deleteByBidx(int bidx) {
		// TODO Auto-generated method stub
		return boardDao.deleteByBidx(bidx);
	}

	@Override
	public int insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDao.insert(vo);
	}

	@Override
	public int maxBidx() {
		return boardDao.maxBidx();
	}



}
