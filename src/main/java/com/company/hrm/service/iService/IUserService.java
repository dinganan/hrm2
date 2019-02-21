package com.company.hrm.service.iService;

import com.company.hrm.dao.pojo.User;

public interface IUserService {
	String regist(User user);
	User login(String username, String password);
	boolean isExist(String username);
}
