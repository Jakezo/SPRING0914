package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.config.DBService;

public class WhiteDao {

	// 필드
	private SqlSessionFactory factory;
	
	// 생성자(Singleton)
	private WhiteDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static WhiteDao whiteDao = new WhiteDao();
	public static WhiteDao getInstance() {
		return whiteDao;
	}
	
	// 메소드
	

}
