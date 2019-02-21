package com.company.hrm.service.iService;

import java.util.List;

import com.company.hrm.dao.pojo.Emp;

public interface IEmpService extends IBaseService<Emp, Integer>{
	List<Emp> findByName(String ename);
}
