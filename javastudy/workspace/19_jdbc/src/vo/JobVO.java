package vo;

public class JobVO {

	// JOB 테이블의 행(row)과 1:1 매칭할 객체를 생성할 클래스
	
	// 1. VO  : Value Object
	// 2. DTO : Data Transfer Object
	
	// field
	private String job_id;     // JOB테이블의 JOB_ID칼럼 (절대 다른 이름 주지 마세요.)
	private String job_title;  // JOB테이블의 JOB_TITLE칼럼
	private int min_salary;    // JOB테이블의 MIN_SALARY칼럼
	private int max_salary;    // JOB테이블의 MAX_SALARY칼럼
	
	// constructor
	public JobVO() { }
	public JobVO(String job_id, String job_title, int min_salary, int max_salary) {
		super();
		this.job_id = job_id;
		this.job_title = job_title;
		this.min_salary = min_salary;
		this.max_salary = max_salary;
	}
	
	// method
	public String getJob_id() {
		return job_id;
	}
	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public int getMin_salary() {
		return min_salary;
	}
	public void setMin_salary(int min_salary) {
		this.min_salary = min_salary;
	}
	public int getMax_salary() {
		return max_salary;
	}
	public void setMax_salary(int max_salary) {
		this.max_salary = max_salary;
	}
	
	@Override
	public String toString() {
		return job_id;  // System.out.println(vo); 에서 vo의 출력 형식이 된다.
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}