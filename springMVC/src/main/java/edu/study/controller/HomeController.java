package edu.study.controller;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import edu.study.vo.BoardVO;
import edu.study.vo.OperVO;

/**
 * Handles requests for the application home page.
 */
@Controller /* @Component의 하위에 존재 */
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate); 

		return "home"; /* view로 forward하는 부분 */
	}

	@RequestMapping(value = "/test.do", method = RequestMethod.GET) /* 링크는 무조건 GET 방식 */
	public String test(Locale locale, Model model) {

		return "sample/Sample"; /* view로 forward하는 부분 */

	}

	@RequestMapping(value = "oper/calc.do", method = RequestMethod.GET) /* 링크는 무조건 GET 방식 */
	public String calc() {

		return "oper/calculator"; /* view로 forward하는 부분 */

	}
	
	@RequestMapping(value = "oper/calc.do", method = RequestMethod.POST) 
	public String calc(OperVO vo, Model model) { /*메소드  이름도 중복 사용 가능*/
		
		System.out.println(vo.getNum1());
		System.out.println(vo.getNum2());
		System.out.println(vo.getOper());
		
		int result = 0;
		
		if(vo.getOper().equals("plus")) {
			result = vo.getNum1()+vo.getNum2();
		}
		
		else if(vo.getOper().equals("minus")) {
			result = vo.getNum1()-vo.getNum2();
		}
		
		else if(vo.getOper().equals("multi")) {
			result = vo.getNum1()*vo.getNum2();
		}
		
		else if(vo.getOper().equals("div")) {
			result = vo.getNum1()/vo.getNum2();
		}
		
		System.out.println(result);
		
		if(vo.getOper()!= null && vo.getOper().equals("")) {
		model.addAttribute("result",result);
		}
		else {
			model.addAttribute("result", "유효하지 않은 연산자입니다.");
		}
		
		model.addAttribute("vo",vo);
		
		//model -> 데이터를 담아서 화면에 넘겨주는 역할
		//setAttribute와 같음
		
		return "oper/result";

	}
	
	@RequestMapping(value="fileupload.do", method=RequestMethod.GET)
	public String file() {
		return "file/upload";
	}
	
	@RequestMapping(value="/fileupload.do",method=RequestMethod.POST)
	public String fileupload(MultipartFile uploadF1,MultipartFile uploadF2,HttpServletRequest req, BoardVO vo) throws IllegalStateException, IOException {
		System.out.println("title=>"+vo.getTitle());
		
		//String path ="D:\\springDev\\springMVC\\src\\main\\webapp\\resources\\upload";
		
		//시스템에서 사용하는 resources/upload 의 절대 경로가 어디인지 알아오는 소스코드
		String path  = req.getSession().getServletContext().getRealPath("/resources/upload");
		
		System.out.println(path);
		
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		if(!uploadF1.getOriginalFilename().isEmpty()) {
			int pos = uploadF1.getOriginalFilename().lastIndexOf(".");
	        String ext = uploadF1.getOriginalFilename().substring(pos + 1);
	        
	        
	        Date now = new Date();
	        String today = new SimpleDateFormat("yyyyMMddHHmmss").format(now);

	        int random = (int) ((Math.random() * 100) + 1);
	        String result = today + random;
	        
			uploadF1.transferTo(new File(path,result+"."+ext));
			
		}
		
		if(!uploadF2.getOriginalFilename().isEmpty()) {
			int pos = uploadF2.getOriginalFilename().lastIndexOf(".");
	        String ext = uploadF2.getOriginalFilename().substring(pos + 1);
	        
	        
	        Date now = new Date();
	        String today = new SimpleDateFormat("yyyyMMddHHmmss").format(now);

	        int random = (int) ((Math.random() * 100) + 1);
	        String result = today + random;
	        
			uploadF2.transferTo(new File(path,result+"."+ext));
			
		}
		
		return "redirect:/";
	}
	

}
