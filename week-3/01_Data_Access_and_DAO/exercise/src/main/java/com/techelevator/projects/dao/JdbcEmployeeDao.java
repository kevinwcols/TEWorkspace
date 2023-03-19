package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date FROM employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;
		/* return new ArrayList<>(); */
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();

		String sql = "SELECT * FROM employee " +
				"WHERE first_name ILIKE ? and last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%"+firstNameSearch+"%", "%"+lastNameSearch+"%");

		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;
		/* return List.of(new Employee()); */
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, e.birth_date, e.hire_date FROM employee e "+
				"JOIN project_employee pe ON e.employee_id = pe.employee_id "+
				"WHERE pe.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;
		/* return new ArrayList<>(); */
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {
		String updateEmployeeProjectSql = "INSERT INTO project_employee ( project_id, employee_id ) " +
				"VALUES ( ?, ? ) RETURNING project_id;";
		int project_id =
				jdbcTemplate.queryForObject(updateEmployeeProjectSql, Integer.class, projectId, employeeId);
	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		// Delete foreign key references to employeeId
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";
		jdbcTemplate.update(deleteProjectEmployeeSql, projectId, employeeId);
		// Now safe to delete the employee
		String deleteEmployeeSql = "DELETE FROM employee WHERE employee_id = ?;";
		jdbcTemplate.update(deleteEmployeeSql, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT e.employee_id, e.department_id, e.first_name, e.last_name, e.birth_date, e.hire_date FROM employee e " +
				"WHERE e.employee_id NOT IN " +
				"(SELECT pe.employee_id FROM project_employee pe)";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		return employees;
		/* return new ArrayList<>(); */
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getInt("employee_id"));
		employee.setDepartmentId(results.getInt("department_id"));
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDate(results.getDate("birth_date").toLocalDate());
		employee.setHireDate(results.getDate("hire_date").toLocalDate());

		return employee;
	}

}
