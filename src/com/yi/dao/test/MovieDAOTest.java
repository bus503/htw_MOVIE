package com.yi.dao.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yi.dao.MovieDAO;
import com.yi.jdbc.DBCPInit;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;

public class MovieDAOTest {
	Connection conn = null;
	MovieDAO dao =null;
	
	@Before
	public void before() {
		try {
			DBCPInit dbcpInit = new DBCPInit();
			dbcpInit.init();
			conn = JDBCUtil.getConnection();
			dao = MovieDAO.getInstance();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@After
	public void After() {
		JDBCUtil.close(conn);
	}
	
	@Test
	public void testInsert() throws SQLException {
		Movie movie = new Movie(1, "test" , "test", "10:00", "내용");
		dao.insert(conn, movie);
	}
	
	@Test 	
	public void testList() throws SQLException {
		List<Movie> list = dao.listMovie(conn);
		for(Movie movie : list) {
			System.out.println(movie);
		}
	}
	
	@Test
	public void testSelectByNo() throws SQLException {
		dao.selectMovieByNo(conn, 1);
	}
}
