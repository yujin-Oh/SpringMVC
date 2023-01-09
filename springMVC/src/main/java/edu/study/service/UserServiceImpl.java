package edu.study.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.study.dao.UserDao;
import edu.study.vo.UserVO;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserVO> list(){
		List<UserVO> list = userDao.list();
		
		return list;
		
	}

	@Override
	public UserVO selectByUidx(int uidx) {
		// TODO Auto-generated method stub
		return userDao.selectByUidx(uidx);
	}

	@Override
	public int updateByUidx(UserVO vo) {
		// TODO Auto-generated method stub
		return userDao.updateByUidx(vo);
	} //--update, delete, insert 구문의 result값이 숫자기 때문에 int형을 받음

	@Override
	public UserVO login(UserVO vo) {
		// TODO Auto-generated method stub
		return userDao.login(vo);
	}

	@Override
	public int selectById(String id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}

	@Override
	public int join(UserVO vo) {
		// TODO Auto-generated method stub
		return userDao.join(vo);
	}





	


	
}