package com.company.hrm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.hrm.common.ErrMsg;
import com.company.hrm.common.ResResult;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.common.SpringIOC;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/EmpSaveServlet")
public class EmpSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		Date hiredate = null;
		try {
			hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		BigDecimal sal = new BigDecimal(request.getParameter("sal"));
		BigDecimal comm = new BigDecimal(request.getParameter("comm"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
		IEmpService empservice = (IEmpService) (IEmpService) SpringIOC.getCtx().getBean("empService");
		String msg = empservice.save(emp);
		boolean flag2 = msg.equals("success");
		ResResult result = flag2?ResResult.success():ResResult.error(500,"emp insert error");
		String resultJson = new ObjectMapper().writeValueAsString(result);
		PrintWriter out = response.getWriter();
		out.println(resultJson);
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empno = Integer.parseInt(request.getParameter("empno"));
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(request.getParameter("mgr"));
		
		Date hiredate = null;
		
		try {
			hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String sals = request.getParameter("sal");
		BigDecimal sal = null;
		if (!sals.isEmpty()) {
			sal = new BigDecimal(sals);
		}
		
		String comms = request.getParameter("comm");
		BigDecimal comm = null;
		if (!comms.isEmpty()) {
			comm = new BigDecimal(comms);
		}
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		IEmpService empservice = (IEmpService)SpringIOC.getCtx().getBean("empService");;
		Emp emp = new Emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
		String msg = empservice.save(emp);
		if (msg.indexOf(ServiceConst.SUCCESS) != -1) {
			response.sendRedirect(request.getContextPath()+"/EmpFindAllServlet");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errmsg", ErrMsg.empErr.SAVE_ERROR);
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}

}
