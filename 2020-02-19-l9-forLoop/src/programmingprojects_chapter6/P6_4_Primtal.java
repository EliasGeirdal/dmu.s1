package programmingprojects_chapter6;

import java.util.Scanner;

public class P6_4_Primtal {

	public static void primTal(int number) {

		for (int tal = 2; tal <= number; tal++) {
				int checker = 1;
				while (checker <= tal) {
						if (tal % checker == 0) {
							if (checker == 1) {
								if (tal == 2) {
									System.out.println(tal);
									break;
								}
								else
									checker++;
							}
							else 
								break;
						} else {
							if (checker == tal - 1) {
								System.out.println(tal);
								break;
								}
							else {
								checker++;;
							}
						}
					}
				}
			}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = in.nextInt();
		primTal(number);
		in.close();
	}
}
