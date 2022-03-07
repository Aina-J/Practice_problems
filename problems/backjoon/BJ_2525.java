package problems.backjoon;

import java.util.Scanner;

public class BJ_2525 {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt() + sc.nextInt();

		while (minute > 59) {
			hour++;
			minute -= 60;
		}

		while (hour > 23)
			hour -= 24;

		System.out.printf("%d %d", hour, minute);
	}
} 

	//	Scanner sc = new Scanner(System.in);

	//	int hour = sc.nextInt();	// 시
	//	int minute = sc.nextInt();	// 분
	//	int requiredTime = sc.nextInt();	// 필요시간
	//	int sum = minute + requiredTime;

	//	hour += sum/60;
	//	minute += requiredTime - (60 * (sum/60));
	
		// if(hour >= 24)
		//	hour -= 24;

		// System.out.println(hour + " " + minute);

	//	sc.close();
	//	} 
// }
