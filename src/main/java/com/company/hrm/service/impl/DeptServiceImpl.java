package com.company.hrm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.idao.IDeptDao;
import com.company.hrm.dao.pojo.Dept;
import com.company.hrm.service.iService.IDeptService;

@Service("deptService")
public class DeptServiceImpl implements IDeptService {
	
	@Autowired
	IDeptDao deptDao;

	@Override
	public String save(Dept t) {
		try {
			deptDao.save(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String delete(Dept t) {
		try {
			deptDao.delete(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public String update(Dept t) {
		try {
			deptDao.update(t);
		} catch (Exception e) {
			e.printStackTrace();
			return ServiceConst.ERROR;
		}
		return ServiceConst.SUCCESS;
	}

	@Override
	public Dept findById(Integer k) {
		Dept dept = null;
		try {
			dept = deptDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
			return dept;
		}
		return dept;
	}

	@Override
	public List<Dept> findAll() {
		List<Dept> depts = new ArrayList<Dept>();
		try {
			depts = deptDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return depts;
		}
		return depts;
	}

	@Override
	public List<Dept> findByPage(int page, int size) {
		List<Dept> depts = new ArrayList<Dept>();
		try {
			depts = deptDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
			return depts;
		}
		return depts;
	}

}
