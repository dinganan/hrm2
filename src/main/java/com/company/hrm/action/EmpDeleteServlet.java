package com.company.hrm.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.hrm.common.DaoConst;
import com.company.hrm.common.ErrMsg;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;

@WebServlet("/EmpDeleteServlet")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		IEmpService empservice = (IEmpService) SpringIOC.getCtx().getBean("empService");
		Emp emp = (Emp) SpringIOC.getCtx().getBean("emp");
		emp.setEmpno(empno);
		empservice.delete(emp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		Emp emp = new Emp();
		emp.setEmpno(empno);
		IEmpService empservice = (IEmpService) SpringIOC.getCtx().getBean("empService");
		String msg = empservice.delete(emp);
		if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
			response.sendRedirect(request.getContextPath()+"/EmpFindAllServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errmsg", ErrMsg.empErr.DELETE_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

}
