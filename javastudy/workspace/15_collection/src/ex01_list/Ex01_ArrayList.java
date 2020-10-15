package ex01_list;

import java.util.ArrayList;

/*
 * ArrayList
 * 1. List 인터페이스를 구현하는 클래스이다.
 *    1) ArrayList<Integer> iList = new ArrayList<Integer>();
 *    2) List<Integer> iList = new ArrayList<Integer>();
 * 2. 배열을 사용하기 쉽게 만들어 놓은 클래스이다.
 * 3. 장점: 순차적인 접근이 빠르다.
 * 4. 단점: 중간 위치에 요소를 추가/삭제할 때 느리다.
 */

public class Ex01_ArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> iList = new ArrayList<Integer>();
		
		// 1. 저장: add() 메소드
		iList.add(10);
		iList.add(new Integer(20));
		iList.add(new Integer("30"));
		
		// 2. 크기: size() 메소드
		System.out.println("iList 크기: " + iList.size());
		
		// 3. 저장된 요소 가져오기: get() 메소드
		System.out.println("첫 번째 요소: " + iList.get(0));
		System.out.println("마지막 요소: " + iList.get(iList.size() - 1));  // 마지막 인덱스 = 배열 크기 - 1   
		
		// 4. 전체 순회하는 for문
		for (int i = 0; i < iList.size(); i++) {
			System.out.println((i + 1) + "번째 요소: " + iList.get(i));
		}

		// 5. 개선된 for문 (size() 메소드 호출 횟수를 1번으로 줄임)
		for (int i = 0, size = iList.size(); i < size; i++) {
			System.out.println((i + 1) + "번째 요소: " + iList.get(i));
		}
		
		// 6. 삭제: remove() 메소드
		iList.remove(0);  // 인덱스0 의 요소 삭제
		iList.remove(new Integer(20));  // 요소20 찾아서 삭제
		
		// 7. 검색: contains() 메소드
		if (iList.contains(new Integer(30))) {  // iList에 30이 있는가?
			System.out.println("30이 있습니다.");
		} else {
			System.out.println("30이 없습니다.");
		}
		
		// 8. 출력
		System.out.println(iList);  // [30]
		
		// 9. 초기화 (모두 삭제)
		iList.clear();
		System.out.println(iList);  // []
		
	}

}
