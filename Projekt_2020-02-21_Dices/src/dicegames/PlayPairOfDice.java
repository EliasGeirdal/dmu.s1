package dicegames;

import java.util.Scanner;

public class PlayPairOfDice {
	private int side1; // amount of sides each die has.
	private int side2;
	private Scanner scan = new Scanner(System.in);

	public PlayPairOfDice() { // parameterless constructor.
	}

	// prints greeting.
	public void welcome() {
		System.out.println("Welcome to Dices");
	}

	// prompts player for how many sides of the dices they want to play with.
	public void decideDices() {
		System.out.println("How many sides for dice 1? ");
		// check if input is an integer
		if (scan.hasNextInt()) {
			side1 = scan.nextInt();
		} else {
			System.out.println("invalid number. Dice assigned 6 sides.");
			side1 = 6;
		}
		scan.nextLine(); // Skip the internal buffer in the scanner. (in case it has a string stored).
		System.out.println("How many sides for dice 2? ");
		if (scan.hasNextInt())
			side2 = scan.nextInt();
		else { // assigns 6 sides to the die, if player doesn't enter an integer.
			System.out.println("invalid number. Dice assigned 6 sides.");
			side2 = 6;
		}
	}

	// method for playing the game. Simulates the procedure of the game.
	public void Start() {
		PairOfDices p = new PairOfDices(side1, side2);
		welcome();
		decideDices();
		p.gameActive();
		p.gameOver();
		scan.close();
	}
}