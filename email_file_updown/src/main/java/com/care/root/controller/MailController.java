package com.care.root.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.root.service.MailService;

@Controller
public class MailController {
	
	@Autowired MailService ms;
	@GetMapping("sendmail")
	public void sendSimpleMail(HttpServletRequest request,
							HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		 
		// 계속해서 연산을 함 String 보단 속도가 빠름
		StringBuffer sb = new StringBuffer();
		sb.append("<html><body>");
		sb.append("<h1>제품소개</h1>");
		sb.append("<a href='https://naver.com'>");
		sb.append("<img src='https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAxOTAzMDlfMjIg%2FMDAxNTUyMTQwNTY1NzEy.i4iHoDjIrlfFz1nZB-fkQw1EidF5KCd7Cuj2lxFbHw8g.zpCIMhZ5E9yq9t1cFwb31tmCDJeNCmkLzRfkefSj7fog.PNG.d7751%2F1.PNG&type=sc960_832'/>");
		sb.append("</a></body></html>");
		String str = sb.toString();
		
		ms.sendMail("weft4520@naver.com","테스트 메일(제목)",str);
		
		out.print("메일을 보냈습니다");
	}

	@GetMapping("auth_form")
	public String authForm() {
		return "authentication";
	}
	
	@GetMapping("auth")
	public String auth(HttpServletRequest request) {
		ms.auth(request);
		return "redirect:http://www.naver.com";
	}
	
	@GetMapping("auth_check")
	public String auth_check(@RequestParam String userid, @RequestParam String userkey, HttpSession session) {
		
		String sessionkey = (String)session.getAttribute(userid);
		if(sessionkey != null) {
			if(sessionkey.equals(userkey)) {
				session.setAttribute("userid", userid);
			}
		}
		return "redirect:auth_form";
		
	}
	
}
