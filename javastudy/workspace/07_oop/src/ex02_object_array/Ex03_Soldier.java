package ex02_object_array;

class Gun {
	
	// field
	String model;
	int bullet;
	
	// constructor
	Gun(String model, int bullet) {
		this.model = model;
		this.bullet = bullet;
	}
	
	// method
	void shoot() {
		if (bullet > 0) {
			bullet--;
			System.out.println(model + " 빵야! (" + bullet + "발 남음)");
		} else if (bullet == 0) {
			System.out.println(model + " 총알이 없습니다.");	
		}
	}
	
	void info() {
		System.out.println(model + "(" + bullet + "발)");
	}
	
}

class Soldier {
	
	// field
	String name;
	Gun[] gunList;
	int idx;  // gunList의 인덱스(실제로는 저장된 Gun의 개수)
	
	// constructor
	Soldier(String name, int gunCount) {
		this.name = name;
		this.gunList = new Gun[gunCount];
		// this.idx = 0;  생략해도 되는 작업
	}
	
	// method
	void addGun(Gun gun) {
		gunList[idx++] = gun;
	}
	void shoot() {  // 모든 총을 한 발씩 쏜다.
		// shoot 을 호출하는 시점에 Gun은 몇 개가 있는가?
		// 호출 시점에 따라 다르다.
		// 그럼에도 불구하고 답이 있다 : idx개
		for (int i = 0; i < idx; i++) {
			// gunList[i] : 하나의 Gun
			gunList[i].shoot();
		}
	}
	void shoot(int gunNo) {
		// gunNo  : 1, 2, 3, ...
		// 인덱스 : 0, 1, 2, ...
		// gunList[인덱스] == gunList[gunNo - 1]
		gunList[gunNo - 1].shoot();
	}
	void shoot(String model) {
		for (Gun gun : gunList) {
			if (model.equals(gun.model)) {
				gun.shoot();
			}
		}
	}
	void info() {
		System.out.println("이름: " + name);
		for (int i = 0; i < idx; i++) {
			gunList[i].info();
		}
	}
	
}

public class Ex03_Soldier {

	public static void main(String[] args) {
		
		Soldier soldier = new Soldier("람보", 3);  // Gun을 3개 가질 수 있는 람보

		soldier.addGun( new Gun("콜트", 10) );
		soldier.addGun( new Gun("베레타", 10) );
		soldier.addGun( new Gun("스미스웨슨", 10) );
		
		// 총 쏘는 방법이 3가지
		soldier.shoot(); 	// 모든 총을 한 발씩 쏜다.
		soldier.shoot(1);	// 1번째 총만 한 발 쏜다.  shoot(2), shoot(3)
		soldier.shoot("베레타");	// 베레타만 한 발 쏜다.
		
		soldier.info();
		// 이름: 람보
		// 콜트(8발)
		// 베레타(8발)
		// 스미스웨슨(9발)
		
	}

}








