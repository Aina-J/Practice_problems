package problems.backjoon;

import java.util.Scanner;

public class BJ_1110 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
		in.close();
        
		int copy = N;
		int count = 0;
        
		while (true) {
			N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
			count++;
 
			if (copy == N) {
				break;
			}
		}
		System.out.println(count);
	}
}