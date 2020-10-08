package ex04_abstract_quiz;

abstract class Fighter {
	// field
	private String name;
	private boolean isAlive;
	private int energy; // 에너지 (0 ~ 100)
	private int power;  // 공격력 (0 ~ 9)
	// constructor
	public Fighter(String name, int energy, int power) {
		super();
		this.name = name;
		this.power = power;
		this.energy = energy;
		this.isAlive = this.energy > 0;
	}
	// method
	public abstract void attack(Fighter fighter);
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
		this.energy = this.energy < 0 ? 0 : this.energy;
		setAlive(this.energy > 0);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
}

class KoreanFighter extends Fighter {
	// constructor
	public KoreanFighter(String name) {
		super(name, (int)(Math.random() * 101), (int)(Math.random() * 10));
	}
	// method
	@Override
	public void attack(Fighter fighter) {
		// 매개변수 Fighter fighter는 상대편이다.
		// KoreanFighter 는 20% 확률로 한 방에 죽임
		if (Math.random() < 0.2) {  // 0.0 <= Math.random() < 1
			fighter.setEnergy(0);
			System.out.println(fighter.getName() + " 한 번에 죽었다.");
		} else {
			// 얼마의 상대편 energy를 줄일 수 있는가? 내 power 만큼.
			// 결론 : 상대편 energy = 상대편 energy - 내 power
			fighter.setEnergy(fighter.getEnergy() - this.getPower());
			System.out.println(fighter.getName() + " 남은 에너지: " + fighter.getEnergy());
		}
	}
}

class ForeignFighter extends Fighter {
	// constructor
	public ForeignFighter(String name) {
		super(name, (int)(Math.random() * 101), (int)(Math.random() * 10));
	}
	// method
	@Override
	public void attack(Fighter fighter) {
		// 매개변수 Fighter fighter는 상대편이다.
		// ForeignFighter 는 10% 확률로 한 방에 죽임
		if (Math.random() < 0.1) {  // 0.0 <= Math.random() < 1
			fighter.setEnergy(0);
			System.out.println(fighter.getName() + " 한 번에 죽었다.");
		} else {
			// 얼마의 상대편 energy를 줄일 수 있는가? 내 power 만큼.
			// 결론 : 상대편 energy = 상대편 energy - 내 power
			fighter.setEnergy(fighter.getEnergy() - this.getPower());
			System.out.println(fighter.getName() + " 남은 에너지: " + fighter.getEnergy());
		}
	}
}

public class Quiz01 {

	public static void main(String[] args) {
		
		Fighter fighter1 = new KoreanFighter("정찬성");
		Fighter fighter2 = new ForeignFighter("에드가");
		
		System.out.println("fighter1: " + fighter1.getName() + ", 에너지: " + fighter1.getEnergy() + ", 파워: " + fighter1.getPower());
		System.out.println("fighter2: " + fighter2.getName() + ", 에너지: " + fighter2.getEnergy() + ", 파워: " + fighter2.getPower());
		
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
