package ex02_inheritance_quiz;

// 슈퍼클래스
class Staff {
	
	// field
	String name;  // 이름
	String depart;  // 부서
	
	// constructor
	Staff(String name, String depart) {
		this.name = name;
		this.depart = depart;
	}
	
	// method
	int pay() {
		// 생각해보면, 급여가 얼마일까?
		// Staff 클래스는 급여가 없다. 따라서, pay() 메소드가 없어야 한다.
		// 실제로는 pay() 메소드가 존재해야 한다. (모든 Staff 의 서브클래스는 pay() 메소드를 사용하므로)
		return 0;  // Staff 클래스의 pay()는 절대 호출되어선 안 된다. (앞으로 호출을 막을 예정)
	}
	
}

// 서브클래스
class SalaryMan extends Staff {
	
	// field
	int salary;  // 기본급 (정해진 급여)
	
	// constructor
	SalaryMan(String name, String depart, int salary) {
		super(name, depart);
		this.salary = salary;
	}
	
	// method
	@Override
	int pay() {
		return salary;
	}
	
}

// 서브클래스
class SalesMan extends SalaryMan {
	
	// field
	int salesVolume;  // 판매량
	double incentive;  // 인센티브(판매량이 100 이상이면 20%, 아니면 5%)
	
	// constructor
	SalesMan(String name, String depart, int salary) {
		super(name, depart, salary);
	}
	
	// method
	void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
		this.incentive = salesVolume >= 100 ? 0.2 : 0.05;
	}
	int salesPay() {
		return (int)(salesVolume * incentive);
	}
	@Override
	int pay() {
		
		// 기본급 + 판매수당
		// return salary + (int)(salesVolume * incentive);
		
		// 아래와 같이 작업하길 추천합니다.
		// 1. salary 는 pay() 메소드로 바꾼다.
		// 2. (int)(salesVolume * incentive) 는 별도의 메소드로 만든다.
		return super.pay() + salesPay();
		
	}
	
}

// 서브클래스
class Alba extends Staff {
	
	// field
	int times;  // 일한 시간
	int payPerHour;  // 시급
	
	// constructor
	Alba(String name, String depart, int payPerHour) {
		super(name, depart);
		this.times = 0;  // 생략 가능
		this.payPerHour = payPerHour;
	}
	
	// method
	void setTimes(int times) {
		this.times = times;
	}
	@Override
	int pay() {
		return times * payPerHour;
	}
	
}

public class Quiz05 {

	public static void main(String[] args) {
		
		SalaryMan s1 = new SalaryMan("제임스", "총무부", 300);  // 이름, 부서, 기본급
		System.out.println("s1의 급여: " + s1.pay() + "만원");  // s1의 급여: 300만원
		
		SalesMan s2 = new SalesMan("에밀리", "판매부", 100);  // 이름, 부서, 기본급
		s2.setSalesVolume(200);  // 판매량 설정
		System.out.println("s2의 급여: " + s2.pay() + "만원");  // s2의 급여: 140만원
		
		Alba s3 = new Alba("데이빗", "홍보부", 1);  // 이름, 부서, 시급
		s3.setTimes(100);  // 일한 시간 설정
		System.out.println("s3의 급여: " + s3.pay() + "만원");  // s3의 급여: 100만원

	}

}