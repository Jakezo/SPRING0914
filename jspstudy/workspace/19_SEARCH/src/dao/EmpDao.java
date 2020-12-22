package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.WhiteDto;
import mybatis.config.DBService;

public class EmpDao {

	// 필드
	private SqlSessionFactory factory;
	
	// 생성자(Singleton)
	private EmpDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static EmpDao empDao = new EmpDao();
	public static EmpDao getInstance() {
		return empDao;
	}
	
	// 메소드
	
}
