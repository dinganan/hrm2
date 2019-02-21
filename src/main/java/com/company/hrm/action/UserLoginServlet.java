package com.company.hrm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.hrm.common.ResResult;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.User;
import com.company.hrm.service.iService.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpassword = request.getParameter("password");
		
		IUserService userService = (IUserService) SpringIOC.getCtx().getBean("userService");
		User user = userService.login(username, userpassword);
		
		ResResult<User> result = null;		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());
			result = ResResult.success("login success", user);
		}else{
			result = ResResult.error(500, "password error");
		}
		
		PrintWriter out = response.getWriter();
		String jsonResult = new ObjectMapper().writeValueAsString(result);
		out.println(jsonResult);
		out.flush();
		out.close();		
	}

}
