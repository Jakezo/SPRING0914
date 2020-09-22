package ex02_2d_array;

public class Ex04_forEach {

	public static void main(String[] args) {
		
		
		// 2차원 배열은 1차원 배열을 모아 놓은 것이다.
		
		
		// 2차원 배열의 각 행을 1차원 배열로 생각한다.
		
		// int[][] a = new int[3][2];
		// a[0] : 1차원 배열   a[0] = new int[2];
		// a[1] : 1차원 배열   a[1] = new int[2];
		// a[2] : 1차원 배열   a[2] = new int[2];

		
		// 1차원 배열의 향상 for문(forEach)
		// int[] a = new int[3];
		// for (int n : a) {
		//	   System.out.println(n);
		// }
		
		
		// 2차원 배열의 향상 for문(forEach)
		int[][] a = new int[3][2];
		for (int[] arr : a) {  // a[0], a[1], a[2]가 arr로 전달된다.
			for (int n : arr) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
		
	}

}