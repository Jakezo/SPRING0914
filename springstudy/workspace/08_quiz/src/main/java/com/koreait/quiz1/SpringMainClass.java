package com.koreait.quiz1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLocations = "app-context1.xml";  // classpath:  생략 가능
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		Soldier s = ctx.getBean("soldier", Soldier.class);
		// Soldier s = (Soldier)ctx.getBean("soldier");  // 이렇게 해도 됩니다.

		System.out.println("이름: " + s.getName());
		System.out.println("부대명: " + s.getArmyInfo().get("armyName"));
		System.out.println("부대위치: " + s.getArmyInfo().get("armyLoc"));
		System.out.println("총기모델: " + s.getGun().getModel());
		System.out.println("총알: " + s.getGun().getBullet() + "발");
		
		ctx.close();
		
	}

}
