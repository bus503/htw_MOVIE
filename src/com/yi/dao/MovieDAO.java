package com.yi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;

public class MovieDAO {
	private static MovieDAO dao = new MovieDAO();
	
	public static MovieDAO getInstance() {
		return dao;
	}
	private MovieDAO() {
		
	}
	
	
	public void insert(Connection conn, Movie movie) throws SQLException {
		PreparedStatement pstmt = null;
		
		try {
			String sql = "insert into movie values(null,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getDetail());
			pstmt.setString(3, movie.getTime());
			pstmt.setString(4, movie.getFile());
			pstmt.executeUpdate();
		}finally {
			JDBCUtil.close(pstmt);
		}
	}
	public List<Movie> listMovie(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select* from movie";
			pstmt = conn.prepareStatement(sql);
			rs =pstmt.executeQuery();
			
			ArrayList<Movie> list = new ArrayList<>();
			
			while(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				list.add(movie);
			}
			return list;
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
	}
	
	public Movie selectMovieByNo(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select* from movie where m_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Movie movie = new Movie(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
						return movie;
			}
			return null;
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
	}
}
