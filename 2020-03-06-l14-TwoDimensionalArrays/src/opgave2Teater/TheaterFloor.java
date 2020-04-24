package opgave2Teater;

import java.util.Scanner;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
			{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
	private Scanner in = new Scanner(System.in);

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */

	public int buySeat(int row, int seat) {
		// TODO
		int price;
		if (seats[row][seat] == 0)
			price = 0;
		else {
			price = seats[row][seat];
			seats[row - 1][seat - 1] = 0;
		}
		return price;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param row
	 * @param seat
	 * @return
	 */
	public int buySeat(int price) {
		// TODO
		int seatPrice = 0;
		for (int i = seats.length - 1; i >= 0; i--) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seatPrice == 0 && seats[i][j] == price) {
					seatPrice = seats[i][j];
					seats[i][j] = 0;
				}
			}
		}
		return seatPrice;

	}

	public void printTheaterFloor() {
		// TODO
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				System.out.printf("%3s", (seats[i][j] + " "));
			}
			System.out.println();
		}
	}

	public void run() {
		boolean buy = true;
		while (buy) {
			System.out.println("Do you want to choose price or seat?");
			String respons = in.next();
			if (respons.equalsIgnoreCase("price")) {
				System.out.println("Choose between 10, 20, 30, 40 and 50 whatever valuta.");
				int price = in.nextInt();
				buySeat(price);
				buy = false;
			} else if (respons.equalsIgnoreCase("seat")) {
				System.out.println("Choose row number");
				int row = in.nextInt();
				System.out.println("Choose seat number");
				int seat = in.nextInt();
				buySeat(row, seat);
				buy = false;
			} else
				System.out.println("Try again.");
		}
	}
}
