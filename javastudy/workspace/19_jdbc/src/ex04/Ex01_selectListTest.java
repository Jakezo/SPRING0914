package ex04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnect;
import vo.JobVO;

public class Ex01_selectListTest {

	public static void main(String[] args) {
		
		// Oracle DB는 결과를 ResultSet 에 담아서 Java에게 준다.
		// Java는 받은 결과를 VO(DTO) 에 담는다.
		// 받은 결과가 2개 이상이면 VO(DTO)를 저장할 List를 준비해서 저장한다.
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		
		List<JobVO> jobs = new ArrayList<JobVO>();
		
		try {
			
			conn = DBConnect.getConnection();
			sql = "SELECT * FROM JOB";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				// rs -> JobVO
				JobVO vo = new JobVO();
				vo.setJob_id( rs.getString(1) );
				vo.setJob_title( rs.getString(2) );
				vo.setMin_salary( rs.getInt(3) );
				vo.setMax_salary( rs.getInt(4) );
				// JobVO -> ArrayList에 add
				jobs.add(vo);
			}
			
			System.out.println(jobs.size());
			for (JobVO vo : jobs) {
				System.out.println( vo );
			}
			
			/*
			 * 	rs 의 상태
			 * 	
			 * 	job_id + job_title + min_salary + max_salary
			 * 	job_id + job_title + min_salary + max_salary
			 *  ...
			 *  
			 *  rs.next() 한 번 호출마다 한 row 검색 -> JobVO 객체 -> ArrayList 에 add
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (ps != null) { ps.close(); }
				if (conn != null) { conn.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}








