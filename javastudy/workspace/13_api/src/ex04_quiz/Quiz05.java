package ex04_quiz;

class User {
	// field
	private String userId;
	private String userPw;
	// constructor
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	// method
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("아이디: ").append(userId.substring(0, 2));
		for (int i = 0; i < userId.length() - 2; i++) {
			sb.append("*");
		}
		sb.append(", 비밀번호: ");
		for (int i = 0; i < userPw.length(); i++) {
			sb.append("*");
		}
		return sb.toString();
	}
}

public class Quiz05 {

	public static void main(String[] args) {
		
		User user = new User("admin", "123456");
		
		// toString()
		System.out.println(user);  // 아이디: ad***, 비밀번호: ******  (글자 수 맞춤)
		
	}

}




