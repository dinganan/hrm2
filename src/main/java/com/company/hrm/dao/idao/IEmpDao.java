package com.company.hrm.dao.idao;

import java.util.List;

import com.company.hrm.dao.pojo.Emp;

public interface IEmpDao extends IBaseDao<Emp, Integer> {
	List<Emp> findByName(String ename) throws Exception;
}
