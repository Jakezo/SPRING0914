package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.LimeDto;
import mybatis.config.DBService;

public class LimeDao {

	// 필드: factory를 선언한다.
	private SqlSessionFactory factory;
	
	// 생성자: Singleton (factory를 생성한다.)
	private LimeDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static LimeDao limeDao = new LimeDao();
	public static LimeDao getInstance() {
		return limeDao;
	}
	
	// 메소드: factory를 이용한다.
	// SELECT문: factory.openSession();
	// 나머지문: factory.openSession(false);  수동커밋을 하겠다.
	
	// 기존의 close() 메소드는 구현할 필요가 없다. (구현되어 있다.)
	
	/***** 1. 전체목록 가져오기 *****/
	public List<LimeDto> list() {

		// 1) factory에서 제품(SqlSession)을 생산한다.
		SqlSession sqlSession = factory.openSession();
		
		// sqlSession: mapper.xml에서 SQL을 찾아 실행하는 역할
		// 2) sqlSession이 SQL을 실행한다.
		List<LimeDto> list = sqlSession.selectList("mybatis.mapper.mapper.list");
		
		// 3) sqlSession을 닫는다.
		sqlSession.close();
		
		// 4) 결과를 반환한다.
		return list;
		
	}
	
	/***** 2. 삽입하기 *****/
	public int insert(LimeDto limeDto) {
		
		// 1) factory에서 session 만들기
		SqlSession session = factory.openSession(false);
		
		// 2) session이 SQL 실행
		int result = session.insert("mybatis.mapper.mapper.insert", limeDto);
		
		// 3) 성공하면 commit
		if (result > 0) {
			session.commit();
		}
		
		// 4) 닫기
		session.close();
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
}
