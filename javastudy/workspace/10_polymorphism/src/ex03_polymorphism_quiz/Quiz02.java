package ex03_polymorphism_quiz;

class Staff {
	// field
	private String name;
	private String depart;
	// constructor
	public Staff(String name, String depart) {
		super();
		this.name = name;
		this.depart = depart;
	}
	// method
	public void info() {
		System.out.println("직원이름: " + name);
		System.out.println("소속부서: " + depart);
	}
	public int pay() {
		return 0;  // 사용되는 반환 값은 아니다.
	}
}

class SalaryMan extends Staff {
	// field
	private int salary;
	// constructor
	public SalaryMan(String name, String depart, int salary) {
		super(name, depart);
		this.salary = salary;
	}
	// method
	@Override
	public void info() {
		super.info();  // 이름, 부서를 출력하는 Staff의 info메소드
		System.out.println("기본급: " + salary);
	}
	@Override
	public int pay() {
		return salary;
	}
}

class SalesMan extends SalaryMan {
	// field
	private int salesVolume;
	private double incentive;
	// constructor
	public SalesMan(String name, String depart, int salary) {
		super(name, depart, salary);
	}
	// method
	public void setSalesVolume(int salesVolume) {
		if (salesVolume < 0) {
			return;
		}
		this.salesVolume = salesVolume;
		if (this.salesVolume < 1000) {
			setIncentive(0.05);  // 1000 미만은 5%
		} else if (this.salesVolume < 2000) {
			setIncentive(0.1);  // 2000 미만은 10%
		} else {
			setIncentive(0.2);  // 나머지는 20%
		}
	}
	// 외부에서는 incentive를 수정할 수 없도록 private 처리
	private void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	public int salesPay() {
		return (int)(salesVolume * incentive);
	}
	@Override
	public void info() {
		super.info();  // 이름, 부서, 기본급을 출력하는 SalaryMan의 info메소드
		System.out.println("판매수당: " + salesPay());
		System.out.println("총 급여: " + pay());
	}
	@Override
	public int pay() {
		return super.pay() + salesPay();  // super.pay() : SalaryMan의 pay()는 기본급을 의미한다.
	}
}

class Alba extends Staff {
	// field
	private int times;
	private double payPerHour;
	// constructor
	public Alba(String name, String depart, double payPerHour) {
		super(name, depart);
		this.payPerHour = payPerHour;
	}
	// method
	public void setTimes(int times) {
		this.times = times;
	}
	@Override
	public void info() {
		super.info();  // 이름, 부서
		System.out.println("총 급여: " + pay());
	}
	@Override
	public int pay() {
		return (int)(times * payPerHour);
	}
}

class Company {
	// field
	private Staff[] staffList;
	private int idx;
	private int staffCount;
	// constructor
	public Company(int staffCount) {  // staffCount: 전체직원수
		staffList = new Staff[staffCount];
		this.staffCount = staffCount;
	}
	// method
	public void addStaff(Staff staff) {
		if (idx == staffCount) {
			System.out.println("직원을 더 이상 뽑을 수 없습니다.");
			return;
		}
		if (staff instanceof Alba) {  // staff이 Alba타입이면
			((Alba) staff).setTimes(100);  // Staff staff -> Alba staff : downcasting
		} else if (staff instanceof SalesMan) {
			((SalesMan) staff).setSalesVolume(1000);
		}
		staffList[idx++] = staff;
	}
	public void staffListInfo() {
		for (Staff staff : staffList) {
			if (staff != null) {
				staff.info();
			}
		}
		System.out.println("==================");
		System.out.println("현재 직원 수: " + idx + "명");
	}
	
}

public class Quiz02 {

	public static void main(String[] args) {
		
		Company samsung = new Company(5);
		samsung.addStaff(new SalaryMan("앨리스", "총무부", 250));
		samsung.addStaff(new SalesMan("아만다", "판매부", 100));
		samsung.addStaff(new Alba("제시카", "홍보부", 0.9));
		samsung.staffListInfo();
		
	}

}
