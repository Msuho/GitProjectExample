package com.care.root;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@GetMapping("non_ajax")
	public String test() {
		System.out.println("non ajax ����");
		return "non_ajax";
	}


	@GetMapping("ajax")
	public String ajax() {
		System.out.println("ajax ����");
		return "ajax";
	}
	
	
	static int cnt = 0;
	@GetMapping("ajax_result")
	@ResponseBody
	public String ajaxResult() {
		return ++cnt + "";
	}
	
	@GetMapping("ajax01")
	public String ajax01() {
		return "ajax01";
	}
	
	@RequestMapping(value="ajax_result01", produces = "application/json; charset=utf-8")
	@ResponseBody
	public InfoDTO ajax_result01(@RequestBody InfoDTO dto) {
		
		System.out.println("����ڰ� �Ѱ��� �� : " + dto.getName() );
		System.out.println("����ڰ� �Ѱ��� �� : " + dto.getAge() );
		
		dto.setName("�������� ������ ��");
		dto.setAge(30);
		
		return dto;
		
	}
	
	@RequestMapping(value="ajax_result02", produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map ajax_result02(@RequestBody Map info) {
		
		System.out.println("����ڰ� �Ѱ��� �� : " + info.get("name") );
		System.out.println("����ڰ� �Ѱ��� �� : " + info.get("age") );
		System.out.println("����ڰ� �Ѱ��� �� : " + info.get("addr") );
		
		
		return info;
		
	}
	
	@GetMapping("rest01")
	public String rest01() {
		return "rest01";
	}
	
	@RequestMapping("getuser")
	public String getuser() {
		return "getuser";
	}
	
}


	