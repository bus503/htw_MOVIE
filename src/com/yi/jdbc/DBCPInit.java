package com.yi.jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

@SuppressWarnings("serial")
public class DBCPInit extends HttpServlet {
	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}
	
	private void loadJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			throw new RuntimeException("fail to load JDBC Driver", e);
		}
	}
	
	private void initConnectionPool() {
		try {
		String url = "jdbc:mysql://localhost:3306/htw_MOVIE?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String pass = "rootroot";
		
		ConnectionFactory connFactory = new DriverManagerConnectionFactory(url,user,pass); 
		PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
		
		//커넥션중에 사용할수있는놈인지 아닌놈인지 검사하는 태그
		//커넥션 검사시 사용하는 쿼리
		//종료된 커넥션을 dbcp의 connection pool에선 여전히 가지고있을때
		//db 관련 프로그램이 호출되면 커넥션 관련 에러가 발생하게 된다
		//java에서 db를 사용하기 전에 해당 커넥션이 정상적인지 검사를 하도록 하는것.
		//select 1 이라는 이름은 sql서버에서 권장하는방법이다.
		poolableConnFactory.setValidationQuery("select 1"); 
		
		
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		//검사 주기: 일반적으로는 10~30분마다 하는데 우리는 저기 적힌게 5분임 계속 돌려놓으면 서버 맛이감
		poolConfig.setTimeBetweenEvictionRunsMillis(1000L*60L*5L);
		//유휴 커넥션 검사할 것인가?
		//유효하지 않은 커넥션은 검사해서 연결을 끊어줘야한다(제거)
		poolConfig.setTestWhileIdle(true);
		//최소한 유휴커넥션 개수
		poolConfig.setMinIdle(4);
		//커넥션의 전체 갯수 50개를 넘지않는다  위아래태그의 뜻이 최대 50개 중에서 최소한 4개의 사용가능한 커넥션은 보장해라 라는 뜻임
		poolConfig.setMaxTotal(50);
		
		GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,poolConfig);
		poolableConnFactory.setPool(connectionPool);
		
		Class.forName("org.apache.commons.dbcp2.PoolingDriver");
		
		PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");//커넥션풀이름지정(괄호안이)
		
		//jdbc:apache:commons:dbcp:chap14 가 된다  저기 끝부분이 DB명이 됨
		driver.registerPool("htw_MOVIE", connectionPool);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
