package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.DBConnect;

// DAO : Data Access Object
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
	// select 용
	
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
	
	
	
	
}













