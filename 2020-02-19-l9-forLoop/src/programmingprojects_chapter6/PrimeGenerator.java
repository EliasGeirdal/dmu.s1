package programmingprojects_chapter6;

public class PrimeGenerator {

	/*
	 * isPrime is checking if given number is a prime number. using a while loop
	 * with a created counter, it checks all numbers from 0 -> number to check if
	 * number is a multiplum.
	 */

	public boolean isPrime(int number) {
		boolean prime = false;
		int checker = 1;
		while (checker <= number) {
			if (number % checker == 0 && checker != 1) {
				prime = false;
				break;
			} else {
				if (checker == number - 1) {
					prime = true;
					break;
				} else
					checker++;
			}
		}
		return prime;
	}

//	public int nextPrime() {
//		int prime = isPrime;
//		int checker = 1;
//		boolean primeCheck = false;
//		while (primeCheck == false) {
//			if (prime % checker == 0 && checker != 1) {
//				primeCheck = false;
//				break;
//			}
//			else {
//				if (checker == prime - 1) {
//					primeCheck = true;
//					break;
//				}
//				else
//					checker++;
//			}
//		}
//		
//		
//		return prime;
//	}

	// Checking and printing every prime number from 0 -> chosen number.
	// tal is the number being checked, it rises in a for loop every time
	// - every single number from 0 -> tal has been checked.
	// while loop is used to make a counter rising from 0 -> tal
	// - checking if tal is a multiplum.
	// 2 is the lowest and the only even prime number and is executed individually.
	public void primTal(int number) {

		for (int tal = 2; tal <= number; tal++) {
			int checker = 1;
			while (checker <= tal) {
				if (tal % checker == 0) {
					if (checker == 1) {
						if (tal == 2) {
							System.out.println(tal);
							break;
						} else
							checker++;
					} else
						break;
				} else {
					if (checker == tal - 1) {
						System.out.println(tal);
						break;
					} else {
						checker++;
						;
					}
				}
			}
		}
	}

}
