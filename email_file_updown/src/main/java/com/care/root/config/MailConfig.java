package com.care.root.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	@Bean
	public JavaMailSender mailSender() {
		JavaMailSenderImpl jms = new JavaMailSenderImpl();
		jms.setHost("smtp.gmail.com");//google smtp(메일) 서버 설정
		jms.setPort(587); // google smtp 메일 서버 포트
		jms.setUsername("weft107@gmail.com"); // google ID
		jms.setPassword("!Anstngh4520"); // google PWD
		
		// 메일 전달 프로토콜 세부 설정
		Properties prop = new Properties();
		// 메일 프로토콜 지정
		prop.setProperty("mail.transport.protocol", "smtp");
		// 사용자 인증을 통한 전송
		prop.setProperty("mail.smtp.auth", "true");
		// tls 보안 처리. 암시적은 ssl 이다.
		prop.setProperty("mail.smtp.starttls.enable", "true");
		// 암호화 방식
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// 디버그
		prop.setProperty("mail.debug", "true");
		
		
		jms.setJavaMailProperties(prop);

			
		return jms;
	}

}
