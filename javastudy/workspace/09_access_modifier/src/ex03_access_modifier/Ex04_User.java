package ex03_access_modifier;

import java.util.Date;

class User {
	
	// field
	private String id;
	private String pw;
	private Date date;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String id, String pw, Date date) {
		super();  // Object 클래스의 생성자를 의미한다.
		this.id = id;
		this.pw = pw;
		this.date = date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	// constructor
	// 이클립스가 자동으로 만들어 준다.
	
	// getters and setters
	// 이클립스가 자동으로 만들어 준다.
	
	// 메뉴 : Source 메뉴에 있다.
	
}


public class Ex04_User {

	public static void main(String[] args) {
		

	}

}
