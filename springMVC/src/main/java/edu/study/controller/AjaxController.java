package edu.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.study.service.BoardService;
import edu.study.service.UserService;
import edu.study.vo.BoardVO;
import edu.study.vo.SearchVO;

@RequestMapping(value="/ajax")
@Controller
public class AjaxController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET )
	public String main(){
		return "ajax/main";
	}
	
	@ResponseBody
	@RequestMapping(value="/callString.do",method=RequestMethod.GET)
	public String callStr() {
		return "ajax test data!!";
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxTest1.do", method=RequestMethod.GET)
	public String ajaxTest1(String test1, String test2) {
		return test1+"_"+test2+"_ajax!!";  //data1_data2_ajax!!
	}
	
	@ResponseBody
	@RequestMapping(value="findBidx.do", method=RequestMethod.GET)
	public BoardVO findBidx(int bidx) {
		
		BoardVO vo = boardService.selectByBidx(bidx);
		
		return vo;
		
	}
	
	@ResponseBody
	@RequestMapping(value="ajaxSearchBoard.do",method=RequestMethod.GET)
	public List<BoardVO> searchBoard(SearchVO vo){

		return boardService.list(vo);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/checkId.do", method=RequestMethod.POST)
	public String checkId(String id) {
		
		int result = userService.selectById(id);
		
		if(result >0) {
			return "1";
		}else {
			return "0";
		}
	}
}












