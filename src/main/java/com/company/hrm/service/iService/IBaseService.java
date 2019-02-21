package com.company.hrm.service.iService;

import java.util.List;

public interface IBaseService <T,K>{
	String save(T t);
	String delete(T t);
	String update(T t);
	T findById(K k);
	List<T> findAll();
	List<T> findByPage(int page, int size);
}
