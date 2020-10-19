package ex04_quiz;

import java.io.File;
import java.util.Scanner;

public class Quiz03 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 파일명을 입력하세요 >>>  ");
		String findFile = sc.nextLine();
		
		File file = new File("C:" + File.separator + "test" + File.separator + findFile);
		
		if (file.exists()) {
			System.out.println(file.getName() + "파일이 삭제되었습니다.");
			file.delete();
		} else {
			System.out.println(findFile + "파일이 존재하지 않습니다.");
		}
		
		sc.close();

	}

}