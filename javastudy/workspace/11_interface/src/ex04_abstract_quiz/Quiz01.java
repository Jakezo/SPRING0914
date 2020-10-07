package ex04_abstract_quiz;

class Fighter {
	// field
	private String name;
	private boolean isAlive;
	private int energy; // 에너지 (100)
	private int power;  // 공격력 (0 ~ 9)
	// constructor
	
	// method
	public abstract void attack(Fighter fighter);
	// KoreanFighter 는 20% 확률로 한 방에 죽임
	// ForeignFighter 는 10% 확률로 한 방에 죽임
}





public class Quiz01 {

	public static void main(String[] args) {
		
		Fighter fighter1 = new KoreanFighter("정찬성");
		Fighter fighter2 = new ForeignFighter("에드가");
		
		System.out.println("싸움 시작");
		
		// 공격 차례
		boolean myTurn = Math.random() < 0.5 ? false : true;
		
		do {  // 둘 다 살아있으면 진행
			if (myTurn) {
				System.out.println(fighter1.getName() + "의 공격");
				fighter1.attack(fighter2);
				myTurn = false;
			} else {
				System.out.println(fighter2.getName() + "의 공격");
				fighter2.attack(fighter1);
				myTurn = true;
			}
		} while (fighter1.isAlive() && fighter2.isAlive());
		
		System.out.println("싸움 끝");
		
		// 누가 이겼는가?
		if (fighter1.isAlive()) {
			System.out.println(fighter1.getName() + "의 승리. 남은 에너지: " + fighter1.getEnergy());
		} else {
			System.out.println(fighter2.getName() + "의 승리. 남은 에너지: " + fighter2.getEnergy());
		}
		
	}

}
