package ex01_list;

import java.util.ArrayList;
import java.util.List;

public class Ex02_ArrayList {

	public static void main(String[] args) {
		
		
		// 1. 1~10000 모든 정수를 저장한 ArrayList 2개 생성
		List<Integer> iList1 = new ArrayList<Integer>();
		List<Integer> iList2 = new ArrayList<Integer>();
		for (int n = 1; n <= 10000; n++) {
			iList1.add(n);
			iList2.add(n);
		}
		
		// 2. 마지막 요소부터 하나씩 전체 삭제(나노초 단위로 수행 시간)
		long start1 = System.nanoTime();
		for (int i = iList1.size() - 1; i > -1; i--) {
			iList1.remove(i);
		}
		long end1 = System.nanoTime();
		System.out.println("총 소요시간: " + (end1 - start1) + "나노초");
		
		// 3. 첫 번째 요소만 계속 지우는 방법으로 전체 삭제(나노초 단위로 수행 시간)
		long start2 = System.nanoTime();
		for (int i = 0, size = iList2.size(); i < size; i++) {
			iList2.remove(0);
		}
		long end2 = System.nanoTime();
		System.out.println("총 소요시간: " + (end2 - start2) + "나노초");

	}

}
