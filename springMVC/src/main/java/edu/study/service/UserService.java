package edu.study.service;

import java.util.List;

import edu.study.vo.UserVO;

public interface UserService {

	List<UserVO> list();
	UserVO selectByUidx(int uidx);
	
	int updateByUidx(UserVO vo);
	
	UserVO login(UserVO vo);
	
	int selectById(String id);
	
	int join(UserVO vo);
	
}
