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
		jms.setHost("smtp.gmail.com");//google smtp(����) ���� ����
		jms.setPort(587); // google smtp ���� ���� ��Ʈ
		jms.setUsername("weft107@gmail.com"); // google ID
		jms.setPassword("!Anstngh4520"); // google PWD
		
		// ���� ���� �������� ���� ����
		Properties prop = new Properties();
		// ���� �������� ����
		prop.setProperty("mail.transport.protocol", "smtp");
		// ����� ������ ���� ����
		prop.setProperty("mail.smtp.auth", "true");
		// tls ���� ó��. �Ͻ����� ssl �̴�.
		prop.setProperty("mail.smtp.starttls.enable", "true");
		// ��ȣȭ ���
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		// �����
		prop.setProperty("mail.debug", "true");
		
		
		jms.setJavaMailProperties(prop);

			
		return jms;
	}

}
