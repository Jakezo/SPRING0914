package ex03_array_quiz;

import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
		
		// 문제. 친구 3명을 저장할 수 있는 배열을 생성하고,
		// 초기화를 통해 배열에 입력한다.
		// 새로 사귄 친구의 수를 입력 받아서,
		// 기존 친구들이 저장된 배열의 길이를 늘리시오.
		
		String[] friendList = {"타요", "띠띠뽀", "뽀로로"};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("새로 사귄 친구가 몇 명인가요? >>> ");
		int newFriend = sc.nextInt();
		
		String[] t = new String[friendList.length + newFriend];
		
		for (int i = 0; i < friendList.length; i++) {
			t[i] = friendList[i];
		}
		
		friendList = t;
		
		System.out.println(friendList.length);

		sc.close();
		
	}

}