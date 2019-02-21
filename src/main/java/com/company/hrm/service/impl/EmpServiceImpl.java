package com.company.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.idao.IEmpDao;
import com.company.hrm.dao.pojo.Emp;
import com.company.hrm.service.iService.IEmpService;

@Service("empService")
public class EmpServiceImpl implements IEmpService{
	@Autowired
	IEmpDao empDao;


	@Override
	public String save(Emp t) {
		try {
			empDao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String delete(Emp t) {
		try {
			empDao.delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String update(Emp t) {
		try {
			empDao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public Emp findById(Integer k) {
		Emp emp = null;
		try {
			emp = empDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
			return emp;
		}
		return emp;
	}

	@Override
	public List<Emp> findAll() {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			emps = empDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return emps;
		}
		return emps;
	}

	@Override
	public List<Emp> findByPage(int page, int size) {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			emps = empDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
			return emps;
		}
		return emps;
	}

	@Override
	public List<Emp> findByName(String ename) {
		List<Emp> emps = new ArrayList<Emp>();
		try {
			emps = empDao.findByName(ename);
		} catch (Exception e) {
			e.printStackTrace();
			return emps;
		}
		return emps;
	}
}
