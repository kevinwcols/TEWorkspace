package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public Department getDepartment(int id) {

		Department department = new Department();

		department = null;

		String getDepartmentSql =
				"SELECT department_id, name FROM department " +
					"WHERE department_id = ?;";

		SqlRowSet getDepartmentResults =
				jdbcTemplate.queryForRowSet(getDepartmentSql, id);
		while (getDepartmentResults.next()){
			department = mapRowToDepartment(getDepartmentResults);
		}

		/* return new Department(0, "Not Implemented Yet"); */
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		String sql = "SELECT department_id, name FROM department;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			departments.add(mapRowToDepartment(results));
		}
		return departments;
		/* return new ArrayList<>(); */

	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String updateDepartmentSql = "UPDATE department SET name = ? " +
					 "WHERE department_id = ?;";
		Integer numberOfRows =
				jdbcTemplate.update(updateDepartmentSql, updatedDepartment.getName(), updatedDepartment.getId());

		/* return numberOfRows == 1; */
	}

	private Department mapRowToDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getInt("department_id"));
		department.setName(results.getString("name"));

		return department;
	}

}
