package com.company.hrm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.hrm.dao.dbutil.DbUtil;
import com.company.hrm.dao.idao.IDeptDao;
import com.company.hrm.dao.pojo.Dept;

@Repository("deptDao")
public class DeptDaoImpl implements IDeptDao {

	@Override
	public void save(Dept t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getDeptno());
		ps.setString(2, t.getDname());
		ps.setString(3, t.getLoc());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);

	}

	@Override
	public void delete(Dept t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "delete from dept where deptno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getDeptno());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);
	}

	@Override
	public void update(Dept t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "update dept set dname=?,loc=? where deptno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getDname());
		ps.setString(2, t.getLoc());
		ps.setInt(3, t.getDeptno());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);

	}

	@Override
	public Dept findById(Integer k) throws Exception {
		Connection con = DbUtil.getConnection();
		String spl = "select deptno,dname,loc from dept where deptno=?";
		PreparedStatement ps = con.prepareStatement(spl);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Dept dept = null;
		if (rs.next()) {
			dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		DbUtil.closeConnection(rs, ps, con);
		return dept;
	}

	@Override
	public List<Dept> findAll() throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select deptno,dname,loc from dept";
		PreparedStatement ps = con.prepareStatement(sql);
		List<Dept> depts = new ArrayList<Dept>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Dept dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			depts.add(dept);
		}
		DbUtil.closeConnection(rs, ps, con);
		return depts;
	}

	@Override
	public List<Dept> findByPage(int page, int size) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select deptno,dname,loc from dept limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page - 1) * size);
		ps.setInt(2, size);
		List<Dept> depts = new ArrayList<Dept>();
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Dept dept = new Dept(rs.getInt(1), rs.getString(2), rs.getString(3));
			depts.add(dept);
		}
		DbUtil.closeConnection(rs, ps, con);
		return depts;
	}

}
