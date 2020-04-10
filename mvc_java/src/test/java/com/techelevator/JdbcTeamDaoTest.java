package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import com.techelevator.model.TeamModel.JDBCTeamDAO;
import com.techelevator.model.TeamModel.Team;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class JdbcTeamDaoTest {

	private static SingleConnectionDataSource dataSource;
	
	private JDBCTeamDAO teamDAO;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/capstone");
		dataSource.setUsername("capstone_appuser");
		dataSource.setPassword("capstone_appuser1");
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
		String sqlInsertTeam = "Insert into team (team_id, team_name, captain_id) values ('54321', 'Fake Team', '654321')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertTeam);
		teamDAO = new JDBCTeamDAO(dataSource);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	protected DataSource getDataSource() {
		return dataSource;
	}

	@Test
	public void testCreateTeam() {
		
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllTeams() {
		List<Team> teamList = teamDAO.getAllTeams();
		assertEquals(teamList.size(), teamDAO.getTeamCount());
	}

	@Test
	public void testGetTeamById() {

		fail("Not yet implemented");
	}

	@Test
	public void testGetTeamByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateTeam() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteTeam() {
		fail("Not yet implemented");
	}

}
