package com.company.hrm.dao.idao;

import com.company.hrm.dao.pojo.User;

public interface IUserDao {
	String regist(User user) throws Exception;
	User login(String username, String password) throws Exception;
	boolean isExist(String username) throws Exception;
}
