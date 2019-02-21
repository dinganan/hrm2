package com.company.hrm.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.hrm.common.ServiceConst;

@WebServlet("/RouterServlet")
public class RouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getParameter("path");
		String url = null;
		if (path.equals(ServiceConst.NEW_EMP)){
			url = "/WEB-INF/"+path;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
