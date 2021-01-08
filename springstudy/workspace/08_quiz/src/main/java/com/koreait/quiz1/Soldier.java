package com.koreait.quiz1;

import java.util.HashMap;

public class Soldier {
	
	// field
	private String name;
	private HashMap<String, String> armyInfo;
	private Gun gun;
	
	// constructor
	public Soldier() {
	
	}
	public Soldier(String name, HashMap<String, String> armyInfo, Gun gun) {
		super();
		this.name = name;
		this.armyInfo = armyInfo;
		this.gun = gun;
	}
	
	// method
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, String> getArmyInfo() {
		return armyInfo;
	}
	public void setArmyInfo(HashMap<String, String> armyInfo) {
		this.armyInfo = armyInfo;
	}
	public Gun getGun() {
		return gun;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	
}
