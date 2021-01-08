package com.koreait.quiz2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@ImportResource("app-context2.xml")
@Configuration
public class AppContext2 {

	@Bean
	public Engine engine2() {
		Engine engine = new Engine();
		engine.setFuelType("가솔린");
		engine.setCc(1990);
		engine.setHp(250);
		engine.setFuelEfficiency(13.5);
		return engine;
	}
	
	@Bean(name="car2")
	public Car a() {
		return new Car("520i", engine2());
	}
	
}
