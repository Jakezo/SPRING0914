package com.koreait.quiz.dto;

public class Calculator {
	
	private int n1;
	private int n2;
	
	public Calculator() {
		
	}
	
	public Calculator(int n1, int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}
	
	public int summary () {
		int result = n1 + n2;
		
		return result;
	}
	public int subtract() {
		int result = n1 - n2;
		
		return result;
	}
	
	public int multyply() {
		int result = n1 * n2;
		
		return result;
	}
	
	public double divide() {
		double result = (double)n1 / (double)n2;
		
		return result;
	}
	
}
