package edu.study.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.study.service.BoardService;
import edu.study.service.UserService;
import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;
import edu.study.vo.UserVO;

//1. dispatcherServlet에서 요청함
@RequestMapping(value="/board") //2. value값이 동일한 것을 찾고 메소드를 호출함
//3. 반환된 값은 dispatcherServlet으로 넘어감
//4. viewResolver로 리턴값이 넘어감 
//5. prefix(경로)와 suffix(확장자)를 붙여서 넘김
@Controller
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list.do") //메소드 부분 지워도 관계없음
	public String list(Model model, SearchVO vo) {
		//DB list 조회
		
		List<BoardVO> list = boardService.list(vo);
		model.addAttribute("datalist", list);
		
		
//		List<BoardVO> list = new ArrayList<BoardVO>(); //list는 인터페이스. 객체가 될 수는 없음.
//		
//		BoardVO vo1 = new BoardVO();
//		vo1.setTitle("첫번째 게시글");
//		vo1.setWriter("첫번째 작성자");
//		vo1.setContent("첫번째 내용");
//		
//		list.add(vo1);
//		
//		BoardVO vo2 = new BoardVO();
//		vo2.setTitle("두번째 게시글");
//		vo2.setWriter("두번째 작성자");
//		vo2.setContent("두번째 내용");
//		
//		list.add(vo2);
//		
//		
//		BoardVO vo3 = new BoardVO();
//		vo3.setTitle("세번째 게시글");
//		vo3.setWriter("세번째 작성자");
//		vo3.setContent("세번째 내용");
//		
//		list.add(vo3);
//		
//		model.addAttribute("datalist",list);
//		//변수이름을 자유롭게 지정해서 키값을 꺼내 모델에 담는다.
//		
		return "board/l";
	}
	
	@RequestMapping(value="/view.do", method= RequestMethod.GET)
	public String view(int bidx, Model model) {
		//DB 상세데이터 조회
		
		BoardVO vo = boardService.selectByBidx(bidx);
		
		model.addAttribute("vo", vo);
		
		
		return "board/v";
	}
	
	@RequestMapping(value="/write.do", method= RequestMethod.GET)
	public String write() {
		return "board/w";
	}
	
	//메소드가 달라지면 하나의 url을 두 번 쓸 수 있다!
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	//해당 메소드를 호출하는 가상경로 -> projectpath/board/write.do
	public String write(BoardVO vo, HttpSession session) { //메소드 오버로딩
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		vo.setUidx(login.getUidx());
		
		int result = boardService.insert(vo);
			
//		if(title != null && !title.equals("")) {
//			
//		}

//		System.out.println("param title:" + vo.getTitle());
//		System.out.println("param writer:" + vo.getWriter());
//		System.out.println("param content:" + vo.getContent());

//		insert된 게시글의 pk 값을 가져와 view.do로 이동하세요.		
		
		//DB작업(insert)
		return "redirect:view.do?bidx="+vo.getBidx(); //redirect되는 가상경로 -> projectpath/board/list.do
		//redirect: <= viewResolver에 보내지 않고 다시 controller에게 넘겨주도록 하는 키워드(뒤에는 반드시 url이 와야됨. 경로 X)
		
	}
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="user.do")
	public String user(Model model) {
		
		List<UserVO> list = userService.list();
		model.addAttribute("datalist", list);
		
		return "board/u";
	} 
	
	@RequestMapping(value="/modify.do", method= RequestMethod.GET)
	public String modify(int bidx, Model model) {
		
		BoardVO vo = boardService.selectByBidx(bidx);
		model.addAttribute("vo", vo);
		
		return "board/m";
	}
	
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify(BoardVO vo) {
		
		int result = boardService.updateByBidx(vo);
		
		if(result>0) {
			return "redirect:view.do?bidx="+vo.getBidx();
		}else {
			return "redirect:/";
		}	
	}
	
	@RequestMapping(value="/mypage.do", method=RequestMethod.GET)
	public String mypage(int uidx, Model model) {
		
		UserVO vo = userService.selectByUidx(uidx);
		model.addAttribute("vo", vo);
		return "board/mp";
	}
	
	
	@RequestMapping(value="/userModify.do", method=RequestMethod.GET)
	public String userModify(int uidx, Model model) {
		
		UserVO vo = userService.selectByUidx(uidx);
		model.addAttribute("vo", vo);
		return "board/um";
		
	}
	
	
	@RequestMapping(value="/userModify.do", method=RequestMethod.POST)
	public String userModify(UserVO vo) {
		
		int result = userService.updateByUidx(vo);
		
		if(result>0) {
			return "redirect:mypage.do?uidx="+vo.getUidx();
		}else {
			return "redirect:/";
		}	
		
	}
	
	//굳이 method를 호출하는 이유: 동시에 GET방식도 함께 호출할 수 있기 때문에
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String delete(int bidx, HttpSession session) {
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		int uidx = login.getUidx();
		//getter를 통해 uidx의 값을 꺼내온다.
		
		int result = boardService.deleteByBidx(bidx);
		
		if(result>0) {
			return "redirect:list.do";
		}else {
			return "redirect:/";
		}	
	}
	
	
}
	

