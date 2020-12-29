package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.config.DBService;

public class BBSDao {

	// 필드
	private SqlSessionFactory factory;
	
	// 생성자(Singleton)
	private BBSDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static BBSDao bbsDao = new BBSDao();
	public static BBSDao getInstance() {
		return bbsDao;
	}
	
	// 메소드
	public int getTotalRecord() {
		SqlSession ss = factory.openSession();
		int totalRecord = ss.selectOne("mybatis.mapper.bbs.getTotalRecord");
		ss.close();
		return totalRecord;
	}
	
	
	
	
	
	
	
}