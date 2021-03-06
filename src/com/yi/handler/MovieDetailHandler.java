package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.dao.MovieDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;
import com.yi.mvc.CommandHandler;

public class MovieDetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			Connection conn = null;
			String sNo = req.getParameter("no");
			int no = Integer.parseInt(sNo);
			try {
				conn = JDBCUtil.getConnection();
				MovieDAO dao = MovieDAO.getInstance();
				
				Movie movie = dao.selectMovieByNo(conn, no);
				
				req.setAttribute("movie", movie);
				
				
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			
			
			return "/WEB-INF/view/section/detail.jsp";
		}
		
		return null;
	}

}
