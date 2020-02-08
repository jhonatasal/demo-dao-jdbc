package model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.DAO.DepartmentDAO;
import model.entites.Department;

public class DepartmentDAOJdbc implements DepartmentDAO {
	private Connection conn;

	public DepartmentDAOJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("INSERT INTO department VALUES (?,?)");
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			throw new DbException("Departamento não inserido");
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("Update department set name = ? where id = ?");
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement("Delete from department where id = ?");
			st.setInt(1, id);
			st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		Department dep = null;
		try {
			st = conn.prepareStatement("Select id,name from department where id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				dep = instantiateDepartament(rs);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return dep;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<Department>();
		try {
			st = conn.prepareStatement("Select * from department ");
			rs = st.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Department dep = instantiateDepartament(rs);
					list.add(dep);
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		return list;
	}

	private Department instantiateDepartament(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("id"));
		dep.setName(rs.getString("name"));
		return dep;
	}
}
