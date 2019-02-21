package com.company.hrm.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.hrm.dao.dbutil.DbUtil;
import com.company.hrm.dao.idao.IEmpDao;
import com.company.hrm.dao.pojo.Emp;

@Repository("empDao")
public class EmpDaoImpl implements IEmpDao {
	
	@Override
	public void save(Emp t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.setString(2, t.getEname());
		ps.setString(3, t.getJob());
		ps.setInt(4, t.getMgr());
		ps.setDate(5, new Date(t.getHiredate().getTime()));
		ps.setBigDecimal(6, t.getSal());
		ps.setBigDecimal(7, t.getComm());
		ps.setInt(8, t.getDeptno());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);
	}

	@Override
	public void delete(Emp t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "delete from emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);
	}

	@Override
	public void update(Emp t) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getEname());
		ps.setString(2, t.getJob());
		ps.setInt(3, t.getMgr());
		ps.setDate(4, new Date(t.getHiredate().getTime()));
		ps.setBigDecimal(5, t.getSal());
		ps.setBigDecimal(6, t.getComm());
		ps.setInt(7, t.getDeptno());
		ps.setInt(8, t.getEmpno());
		ps.executeUpdate();
		DbUtil.closeConnection(null, ps, con);

	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		if (rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
			emp.setComm(rs.getBigDecimal(7));
			emp.setDeptno(rs.getInt(8));
		}
		DbUtil.closeConnection(rs, ps, con);
		return emp;
	}

	@Override
	public List<Emp> findAll() throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
			emp.setComm(rs.getBigDecimal(7));
			emp.setDeptno(rs.getInt(8));
			emps.add(emp);
		}
		DbUtil.closeConnection(rs, ps, con);
		return emps;
	}

	@Override
	public List<Emp> findByPage(int page, int size) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page - 1) * size);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
			emp.setComm(rs.getBigDecimal(7));
			emp.setDeptno(rs.getInt(8));
			emps.add(emp);
		}
		DbUtil.closeConnection(rs, ps, con);
		return emps;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Connection con = DbUtil.getConnection();
		String sql = "select empno,ename,job,mgr,hiredate,sal,comm,deptno from emp where ename like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + ename + "%");
		ResultSet rs = ps.executeQuery();
		List<Emp> emps = new ArrayList<Emp>();
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setJob(rs.getString(3));
			emp.setMgr(rs.getInt(4));
			emp.setHiredate(rs.getDate(5));
			emp.setSal(rs.getBigDecimal(6));
			emp.setComm(rs.getBigDecimal(7));
			emp.setDeptno(rs.getInt(8));
			emps.add(emp);
		}
		DbUtil.closeConnection(rs, ps, con);
		return emps;
	}

}
