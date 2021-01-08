package com.koreait.quiz2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext2.class);
		
		Car car1 = ctx.getBean("car1", Car.class);
		Car car2 = ctx.getBean("car2", Car.class);
		
		car1.carInfo();
		car2.carInfo();
		
		ctx.close();

	}

}
