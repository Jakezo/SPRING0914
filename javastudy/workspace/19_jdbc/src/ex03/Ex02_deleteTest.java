package ex03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnect;
import vo.JobVO;

public class Ex02_deleteTest {

	public static void main(String[] args) {
		
		// 차장을 삭제하시오.
		
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		JobVO jobVO = new JobVO();
		jobVO.setJob_id("CJ");
		
		try {
			
			conn = DBConnect.getConnection();
			sql = "DELETE FROM JOB WHERE JOB_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, jobVO.getJob_id());
			result = ps.executeUpdate();
			if (result > 0) {
				System.out.println(jobVO.getJob_id() + "이(가) 삭제되었습니다.");
			} else {
				System.out.println(jobVO.getJob_id() + "이(가) 삭제되지 않았습니다.");
			}
			// result (삭제된 데이터의 개수가 반환된다.)
			// 1) 0 : 삭제된 ROW가 0개이다.
			// 2) 1 : 삭제된 ROW가 1개이다.
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) { ps.close(); }
				if (conn != null) { conn.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}