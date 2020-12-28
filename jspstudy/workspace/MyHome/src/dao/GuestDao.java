package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.GuestDto;
import dto.MemberDto;
import mybatis.config.DBService;

public class GuestDao {

	// 필드
	private SqlSessionFactory factory;
	
	// 생성자(Singleton)
	private GuestDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static GuestDao guestDao = new GuestDao();
	public static GuestDao getInstance() {
		return guestDao;
	}
	
	// 메소드
	public List<GuestDto> selectGuestList() {
		SqlSession ss = factory.openSession();
		List<GuestDto> list = ss.selectList("mybatis.mapper.guest.selectGuestList");
		ss.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
}