package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.DBConnect;
import dto.JobDTO;

// DAO : Database Access Object
// DB에 접근하는 객체
// CRUD를 처리하는 객체
// CREATE: INSERT
// READ  : SELECT
// UPDATE: UPDATE
// DELETE: DELETE

public class JobDAO {

	// FIELD
	private Connection con;  // 자동으로 null
	private PreparedStatement ps;
	private String sql;
	private int result;
	private ResultSet rs;
	
	// CONSTRUCTOR
	public JobDAO() {
		try {
			// 접속만 해 두자.
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// METHOD
	
	/***** 1. 삽입 메소드 *****/
	public int insert(JobDTO dto) {
		
		try {
			
			sql = "INSERT INTO JOB VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getJob_id());
			ps.setString(2, dto.getJob_title());
			ps.setInt(3, dto.getMin_salary());
			ps.setInt(4, dto.getMax_salary());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) { ps.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	/***** 2. 갱신 메소드 *****/
	public int update(JobDTO dto) {
		
		try {
			
			sql = "UPDATE JOB SET MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = UPPER(?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto.getMin_salary());
			ps.setInt(2, dto.getMax_salary());
			ps.setString(3, dto.getJob_id());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) { ps.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	/***** 3. 삭제 메소드 *****/
	public int delete(String job_id) {
		
		try {
			
			sql = "DELETE FROM JOB WHERE JOB_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, job_id);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) { ps.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	/***** 4. 검색 메소드 *****/
	public JobDTO select(String job_id) {
		
		JobDTO dto = null;
		
		try {
			sql = "SELECT * FROM JOB WHERE JOB_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, job_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new JobDTO();
				dto.setJob_id( rs.getString(1) );
				dto.setJob_title( rs.getString(2) );
				dto.setMin_salary( rs.getInt(3) );
				dto.setMax_salary( rs.getInt(4) );
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) { rs.close(); }
				if (ps != null) { ps.close(); }
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
		
	}
	
}
