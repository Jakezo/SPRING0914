package ex01_oop;

class BankAccount {
	// field
	String accNo;  // 계좌번호
	long balance;  // 잔액
	// constructor
	BankAccount(String accNo, long balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	// method
	void deposit(long money) {
		if (money <= 0) {
			return;
		}
		balance += money;
	}
	// 출금
	// 1) 결과타입 : long  (실제로 출금된 금액)
	// 2) 메소드명 : withdraw
	// 3) 매개변수 : long money  (출금해야 될 금액)
	long withdraw(long money) {
		if (money <= 0 || money > balance) {
			return 0;  // 실제로 출금된 금액
		}
		balance -= money;
		return money;
	}
	void transfer(BankAccount to, long money) {
		// 이체
		// 1. 내 계좌 출금 : withdraw(money)
		// 2. to 계좌 입금 : to.deposit(money)
		// long withDrawMoney = withdraw(money);
		// to.deposit(withDrawMoney);
		to.deposit(withdraw(money));
		//to.deposit(0);
		//to.deposit(money);
	}
	void inquiry() {
		System.out.println("계좌번호: " + accNo + ", 잔액: " + balance + "원");
	}
}

public class Ex09_BankAccount {

	public static void main(String[] args) {
		
		BankAccount me = new BankAccount("1234", 10_000);
		BankAccount mom = new BankAccount("4321", 100_000);
		
		me.deposit(10_000);  // 내 계좌에 10_000원 입금
		me.deposit(-100);    // 내 계좌에 마이너스 입금 (불가)
		
		me.withdraw(20_000);  // 내 계좌에서 20_000 출금
		me.withdraw(100);     // 내 계좌에서 잔액보다 큰 금액 출금 (불가)
		
		me.inquiry();  // 계좌번호: 1234, 잔액: 0원
		
		// 여기까지 1단계
		
		mom.transfer(me, 50_000);  // 엄마가 나에게 50_000 이체
		mom.transfer(me, -100);        // 실패
		mom.transfer(me, 100_000_000); // 실패
		
		mom.inquiry();
		me.inquiry();
		
		// 여기까지 2단계
		
	}

}
