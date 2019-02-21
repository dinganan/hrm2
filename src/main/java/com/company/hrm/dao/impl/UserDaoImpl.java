package com.company.hrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.dbutil.DbUtil;
import com.company.hrm.dao.idao.IUserDao;
import com.company.hrm.dao.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements IUserDao {
	
	@Override
	public String regist(User user) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "insert into user(username,userpassword,priority) values(?,md5(?),?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getUserpassword() + ServiceConst.MD5_SALT);
		ps.setInt(3, user.getPriority());
		String msg = ServiceConst.ERROR;
		if (ps.executeUpdate() != 0) {
			msg = ServiceConst.SUCCESS;
		}
		DbUtil.closeConnection(null, ps, con);
		return msg;
	}

	@Override
	public User login(String username, String password) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select userid,username,priority from user where username=? and userpassword=md5(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password + ServiceConst.MD5_SALT);
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setUserid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPriority(rs.getInt(3));
		}
		DbUtil.closeConnection(rs, ps, con);
		return user;
	}

	@Override
	public boolean isExist(String username) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select count(1) from user where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		boolean isExist = false;
		if (rs.next()) {
			if (rs.getInt(1) != 0) {
				isExist = true;
			}
		}
		DbUtil.closeConnection(rs, ps, con);
		return isExist;
	}

}
