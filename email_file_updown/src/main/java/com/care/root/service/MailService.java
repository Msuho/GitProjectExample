package com.care.root.service;

import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	JavaMailSender jms;
	public void sendMail(String to, String subject, String body) {
		MimeMessage message = jms.createMimeMessage();
		try {
			MimeMessageHelper helper = 
					new MimeMessageHelper(message,true, "UTF-8");
			helper.setSubject(subject);
			helper.setTo(to);
			helper.setText(body, true);
			
			jms.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void auth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String userid = "suho";
		String userkey = rand();
		
		session.setAttribute(userid, userkey);
		
		String body = "<p>�����ϱ�</p>";
		body += "<a href='http://localhost:8080/root/auth_check?userid=" + userid + "&userkey=" + userkey+"'>�����ϱ�</a>";
		
		sendMail("weft4520@naver.com", "���� ����", body);
		
	}
	
	public String rand() {
		Random ran = new Random();
		String str = "";
		int num;
		
		while(str.length() != 20) {
			num = ran.nextInt(75) + 48; // 0-75+48(����, �ҹ���, �빮��)
			if((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) { // 0~9 ���ڷε� ���� , �빮�� A~Z, �ҹ��� a~z
				str += (char)num;
			}
		}
		
		return str;
	}
	
}
