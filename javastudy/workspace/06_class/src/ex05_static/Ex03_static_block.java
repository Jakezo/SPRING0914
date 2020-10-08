package ex05_static;

import java.util.Arrays;

class StaticClass {
	// field
	static int a;
	static int[] b;
	// static 블록 : static 필드의 초기화 작업 진행
	static {
		a = 10;
		b = new int[10];
		for (int i = 0; i < b.length; i++) {
			b[i] = (int)(Math.random() * 101);
		}
	}
}
public class Ex03_static_block {
	public static void main(String[] args) {
		// static 필드(클래스 필드)는 클래스로 접근한다.
		System.out.println(StaticClass.a);  // 10
		System.out.println(Arrays.toString(StaticClass.b));
	}
}
