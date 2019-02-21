package com.company.hrm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.hrm.service.iService.IDeptService;
import com.company.hrm.service.iService.IEmpService;
import com.company.hrm.service.iService.IUserService;

public class Main {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");	
		IDeptService deptService = (IDeptService) ctx.getBean("deptService");
		System.out.println(deptService);
		IUserService userService = (IUserService) ctx.getBean("userService");
		System.out.println(userService);
		IEmpService empService = (IEmpService) ctx.getBean("empService");
		System.out.println(empService);
		
//		User user = (User) ctx.getBean("user");
//		System.out.println(user);
//		IUserDao userDao = (IUserDao) ctx.getBean("userDao");
//		System.out.println(userDao);
//		System.out.println(userDao.isExist("root"));
//		IDeptDao deptDao = (IDeptDao) ctx.getBean("deptDao");
//		IEmpDao empDao = (IEmpDao) ctx.getBean("empDao");
//		System.out.println(deptDao);
//		System.out.println(empDao);
	}
}
