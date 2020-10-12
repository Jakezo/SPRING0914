package ex03_exception_quiz;

// 1. 입금 예외
// 1) 마이너스 입금 시 예외 발생
class DepositException extends Exception {
	
}

// 2. 출금 예외
// 1) 마이너스 출금 시 예외 발생
// 2) 통장잔고보다 큰 금액 출금 시 예외 발생
class WithdrawException extends Exception {
	
}

// 은행계좌
class BankAccount {
	// field
	private String accNo;  // 계좌번호
	private long balance;  // 통장잔고
	// constructor
	
	// method
	// 1. 입금: deposit
	public void deposit(long money) {
		
	}
	// 2. 출금: withdraw
	// 1) 결과: 실제로 출금된 금액
	// 2) 매개변수: 출금 요청 금액
	public long withdraw(long money) {
		
	}
	// 3. 조회: inquiry
	public void inquiry() {
		
	}
	// 4. 이체: transfer
	public void transfer(BankAccount you, long money) {
		// you에게 money를 보낸다.
	}
}

public class Quiz03 {

	public static void main(String[] args) {
		
		BankAccount me = new BankAccount("123-456", 50000);
		BankAccount you = new BankAccount("654-321", 50000);
		
		try {
			me.transfer(you, 50000);  // 정상동작 (예외상황확인)
			me.inquiry();   // 123-456(잔고: 0원)
			you.inquiry();  // 654-321(잔고: 100000원)
		} catch (DepositException e) {
			System.out.println(e.getMessage());
		} catch (WithdrawException e) {
			System.out.println(e.getMessage());
		}

	}

}
