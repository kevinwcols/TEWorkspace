package com.techelevator.projects.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {

		Project project = new Project();

		project = null;

		String getProjectSql =
				"SELECT project_id, name, from_date, to_date FROM project " +
						"WHERE project_id = ?;";

		SqlRowSet getDepartmentResults =
				jdbcTemplate.queryForRowSet(getProjectSql, projectId);
		while (getDepartmentResults.next()){
			project = mapRowToProject(getDepartmentResults);
		}

		/* return new Project(0, "Not Implemented Yet", null, null); */
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT project_id, name, from_date, to_date FROM project;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			projects.add(mapRowToProject(results));
		}
		return projects;

		/* return new ArrayList<>(); */
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) " +
				"VALUES (?, ?, ?) RETURNING project_id";
		Integer project_id =
				jdbcTemplate.queryForObject(sql, Integer.class,
						newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		Project tempProject = getProject(project_id);

		return tempProject;
		/* return null; */
	}

	@Override
	public void deleteProject(int projectId) {
		// Delete foreign key references to projectId
		String deleteProjectEmployeeSql = "DELETE FROM project_employee WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectEmployeeSql, projectId);
		// Now safe to delete the project
		String deleteProjectSql = "DELETE FROM project WHERE project_id = ?;";
		jdbcTemplate.update(deleteProjectSql, projectId);
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getInt("project_id"));
		project.setName(results.getString("name"));
		if ( results.getDate("from_date") != null ) {
			project.setFromDate(results.getDate("from_date").toLocalDate()); }
		if ( results.getDate("to_date") != null ) {
			project.setToDate(results.getDate("to_date").toLocalDate()); }

		return project;
	}
}
