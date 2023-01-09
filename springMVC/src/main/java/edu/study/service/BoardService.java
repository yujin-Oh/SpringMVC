package edu.study.service;
import java.util.List;
import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;

public interface BoardService {
	
	List<BoardVO> list(SearchVO vo); 
	
	BoardVO selectByBidx(int bidx);
	
	int updateByBidx(BoardVO vo);
	
	int deleteByBidx(int bidx);
	
	int insert(BoardVO vo);
	
	int maxBidx();
}
