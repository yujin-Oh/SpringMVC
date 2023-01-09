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

//1. dispatcherServlet���� ��û��
@RequestMapping(value="/board") //2. value���� ������ ���� ã�� �޼ҵ带 ȣ����
//3. ��ȯ�� ���� dispatcherServlet���� �Ѿ
//4. viewResolver�� ���ϰ��� �Ѿ 
//5. prefix(���)�� suffix(Ȯ����)�� �ٿ��� �ѱ�
@Controller
public class BoardController
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/list.do") //�޼ҵ� �κ� ������ �������
	public String list(Model model, SearchVO vo) {
		//DB list ��ȸ
		
		List<BoardVO> list = boardService.list(vo);
		model.addAttribute("datalist", list);
		
		
//		List<BoardVO> list = new ArrayList<BoardVO>(); //list�� �������̽�. ��ü�� �� ���� ����.
//		
//		BoardVO vo1 = new BoardVO();
//		vo1.setTitle("ù��° �Խñ�");
//		vo1.setWriter("ù��° �ۼ���");
//		vo1.setContent("ù��° ����");
//		
//		list.add(vo1);
//		
//		BoardVO vo2 = new BoardVO();
//		vo2.setTitle("�ι�° �Խñ�");
//		vo2.setWriter("�ι�° �ۼ���");
//		vo2.setContent("�ι�° ����");
//		
//		list.add(vo2);
//		
//		
//		BoardVO vo3 = new BoardVO();
//		vo3.setTitle("����° �Խñ�");
//		vo3.setWriter("����° �ۼ���");
//		vo3.setContent("����° ����");
//		
//		list.add(vo3);
//		
//		model.addAttribute("datalist",list);
//		//�����̸��� �����Ӱ� �����ؼ� Ű���� ���� �𵨿� ��´�.
//		
		return "board/l";
	}
	
	@RequestMapping(value="/view.do", method= RequestMethod.GET)
	public String view(int bidx, Model model) {
		//DB �󼼵����� ��ȸ
		
		BoardVO vo = boardService.selectByBidx(bidx);
		
		model.addAttribute("vo", vo);
		
		
		return "board/v";
	}
	
	@RequestMapping(value="/write.do", method= RequestMethod.GET)
	public String write() {
		return "board/w";
	}
	
	//�޼ҵ尡 �޶����� �ϳ��� url�� �� �� �� �� �ִ�!
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	//�ش� �޼ҵ带 ȣ���ϴ� ������ -> projectpath/board/write.do
	public String write(BoardVO vo, HttpSession session) { //�޼ҵ� �����ε�
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		vo.setUidx(login.getUidx());
		
		int result = boardService.insert(vo);
			
//		if(title != null && !title.equals("")) {
//			
//		}

//		System.out.println("param title:" + vo.getTitle());
//		System.out.println("param writer:" + vo.getWriter());
//		System.out.println("param content:" + vo.getContent());

//		insert�� �Խñ��� pk ���� ������ view.do�� �̵��ϼ���.		
		
		//DB�۾�(insert)
		return "redirect:view.do?bidx="+vo.getBidx(); //redirect�Ǵ� ������ -> projectpath/board/list.do
		//redirect: <= viewResolver�� ������ �ʰ� �ٽ� controller���� �Ѱ��ֵ��� �ϴ� Ű����(�ڿ��� �ݵ�� url�� �;ߵ�. ��� X)
		
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
	
	//���� method�� ȣ���ϴ� ����: ���ÿ� GET��ĵ� �Բ� ȣ���� �� �ֱ� ������
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String delete(int bidx, HttpSession session) {
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		int uidx = login.getUidx();
		//getter�� ���� uidx�� ���� �����´�.
		
		int result = boardService.deleteByBidx(bidx);
		
		if(result>0) {
			return "redirect:list.do";
		}else {
			return "redirect:/";
		}	
	}
	
	
}
	

