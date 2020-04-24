package dicegames;

import java.util.Scanner;

public class CrapsPlay {

	private Die die1; // die1 one of the two dices used in the game.
	private Die die2; // die2 one of the two dices used in the game.
	private boolean won = false; // won this variable is updated depending if the player won or lost.
	private int point = 0; // point the sum of the dices in the first throw.
	private boolean active = true; // active keeps the loop activated in method: startGame.
	private Scanner in = new Scanner(System.in); // Scanner the scanner is used in multiple methods.
	private int win = 0; // stats for how many wins and loses.
	private int lose = 0;

	// constructs CrapsPlay with two dices from the Die class. Both dices has 6
	// sides.
	public CrapsPlay() {
		die1 = new Die();
		die2 = new Die();
	}

	// welcomeToGame prints a greeting.
	public void welcomeToGame() {
		System.out.println("Welcome to Craps!");
	}

	// gameover, tells the player if they lost or won, and prompts the user if they
	// want to restart the game.
	public void gameOver() {
		if (won) {
			win++;
			System.out.println("Congratulations you won the game!");
		} else {
			lose++;
			System.out.println("You have lost the game!");
		}
		System.out.println("Do you want to play again?");
		String response = in.next();
		if (response.equalsIgnoreCase("yes")) {
			point = 0;
			active = true;
			won = false;
			startGame();
		} else {
			System.out.println("Thank you for playing.");
			System.out.println("loses: " + lose + "\nWins: " + win); // prints stats.
		}

	}

	// First updates points to be the sum of the first throw
	// Then compares every throw after that with points.
	public void takeTurn() {
		die1.roll();
		die2.roll();
		if (point == 0) { // first it checks roll number one.
			point = (die1.getFaceValue() + die2.getFaceValue());
			if (point == 7 || point == 11) {
				System.out.println("Your come out roll is: " + point);
				won = true;
				active = false;
			} else if (point == 2 || point == 3 || point == 12) {
				System.out.println("Your come out roll is: " + point);
				won = false;
				active = false;
			} else {
				System.out.println("Your come out roll is " + point + "\nTo win, roll " + point + " again.");
			}
		} else {
			int newThrow = (die1.getFaceValue() + die2.getFaceValue()); // newThrow is the throw after first throw.
			System.out.println("You have rolled: " + newThrow);
			if (newThrow == 7) { // 7 loses the game.
				won = false;
				active = false;
			} else if (newThrow == point) {
				won = true;
				active = false;
			}
		}
	}

	// Simulates procedure of the game.
	public void startGame() {
		welcomeToGame();
		while (active) {
			System.out.println("Do you want to roll?");
			String response = in.next();
			if (response.equalsIgnoreCase("yes"))
				takeTurn();
			else if (response.equalsIgnoreCase("no"))
				active = false;
			else {
				System.out.println("Please try again.");
			}
		}
		gameOver(); // prints stats.
		in.close();
	}

}
