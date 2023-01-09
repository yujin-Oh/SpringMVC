package edu.study.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.UserService;
import edu.study.vo.UserVO;
@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	
	//로그인 버튼 클릭 시 사용자가 입력한 아이디 패스워드 정보와 일치하는 USERTB 데이터 CONTROLLER까지 조회해오기
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		
	
		UserVO loginVO = userService.login(vo);
		
		if(loginVO != null) {
			session.setAttribute("login", loginVO);
			System.out.println(loginVO.toString());
		}	
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		
	    if (session != null) {
	        session.invalidate();
	    }
	    
		return "redirect:/";
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(UserVO vo, Model model) {
		
		int result = userService.join(vo);
		
		if (result>0) {
			return "redirect:/";
		}else {
			return "redirect:/";
		}
		
	}

	
	
	
}
