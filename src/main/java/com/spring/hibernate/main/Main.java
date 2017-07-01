package com.spring.hibernate.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.hibernate.configration.AppConfig;
import com.spring.hibernate.entity.User;
import com.spring.hibernate.service.CommonService;
import com.spring.hibernate.service.UserService;
import com.spring.hibernate.service.UserServiceImp;

public class Main {
	
	public static void main(String[] args) {
		
		try {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//		UserService service = (UserService)context.getBean("userService");
//		System.out.println("Insert record");
//		User user = new User();
//		user.setId(3);
//		user.setUserName("Rana");
//		
//		service.createUser(user);
//		
//		System.out.println("record saved!");
		
		System.out.println("Building index on User");
		
		CommonService commonService = (CommonService)context.getBean("commonService");
		
		//commonService.rebuildIndex();
		
		System.out.println("Search for 'rana': ");
		List<User> result = commonService.search("too");
		
		for(User user: result) {
			System.out.print(user.getId()+" ");
			System.out.println(user.getUserName());
		}
		
		} catch(Exception ex) {
			System.out.println("Error occured while processing the request: "+ex.getMessage());
		}
	
	}

}
