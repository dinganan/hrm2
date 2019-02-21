package com.company.hrm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.hrm.common.DaoConst;
import com.company.hrm.common.ResResult;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.service.iService.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/UserExistServlet")
public class UserExistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		IUserService userService = (IUserService) SpringIOC.getCtx().getBean("userService");
		boolean flag = userService.isExist(username);
		ResResult result = flag?ResResult.success():ResResult.error(404,"no such user");
		String resultJson = new ObjectMapper().writeValueAsString(result);
		PrintWriter out = response.getWriter();
		out.println(resultJson);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
