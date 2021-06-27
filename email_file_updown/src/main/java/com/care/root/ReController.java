package com.care.root;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReController {
	
	@GetMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String get() {
		
		return "{\"execute\":\"get ������ ��û�� ���\"}";
				
	}
	
	@PostMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String post() {
		
		return "{\"execute\":\"post ������ �߰�\"}";
				
	}
	
	@PutMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String put() {
		
		return "{\"execute\":\"put ������ ����\"}";
				
	}
	
	@DeleteMapping(value = "rest", produces = "application/json; charset=utf-8")
	public String delete() {
		
		return "{\"execute\":\"delete ������ ����\"}";
				
	}
	
	static int cnt = 0;
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();
	
	@GetMapping(value = "users", produces = "application/json; charset=utf-8")
	public ArrayList<InfoDTO> users(){
		
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt; i<cnt+10; i++) {
			InfoDTO info = new InfoDTO();
			info.setName("ȫ�浿"+i);
			info.setAge(10+i);
			list.add(info);
			DBMap.put("ȫ�浿"+i, info);
		}
		cnt+=10;
		return list;
	}
	
	@GetMapping(value = "user", produces = "application/json; charset=utf-8")
	public InfoDTO user(@RequestParam("id") String id) {
		//select * from table where id = #{id}
		
		
		return DBMap.get(id);
	}
	
	// user/ȫ�浿 14
	@GetMapping(value = "user/{userId}", produces = "application/json; charset=utf-8")
	public InfoDTO user1(@PathVariable("userId") String id) {
		//select * from table where id = #{id}
		
		return DBMap.get(id);
	}
	
	@PutMapping(value = "modify", produces = "application/json; charset=utf-8")
	public InfoDTO modify(@RequestBody InfoDTO dto) {
		System.out.println("name : " + dto.getName());
		System.out.println("age : " + dto.getAge());
		
		//update table age=#{age} where name=#{name}
		DBMap.replace(dto.getName(), dto);
		
		return DBMap.get(dto.getName());
	}
	
	@PostMapping(value = "membership", produces = "application/json; charset=utf-8")
	public String membership(@RequestBody Map<String, Object> map) {
		
		System.out.println("id : " + map.get("uId"));
		System.out.println("name : " + map.get("uName"));
		System.out.println("phone : " + map.get("uPhone"));
		System.out.println("addr : " + map.get("uAddr"));
		System.out.println("age : " + map.get("uAge"));
		
		return "{\"result\" : true}";
		
	}
	
}
