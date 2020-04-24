package dicegames;

import java.util.Scanner;

/**
 * This class models one pair of dices.
 *
 */
public class PairOfDices {
	/**
	 * Attributter:
	 * 
	 * @param
	 * @param
	 * @param
	 * @param
	 * @param
	 * @param
	 * @param
	 */
	private Die die1; // die1 dice number 1
	private Die die2; // die2 dice number 2
	private int rollCount = 0; // rollCount Counts the amount of times dices has been rolled.
	private int sixCount = 0; // sixCount counts the amount of times sixes has been rolled.
	private int underSixCount = 0; // underSixCount counts the amount of times 1 to 5 has been rolled.
	private int pairCount = 0; // pairCount counts how many times a pair has been rolled.
	private int biggestSum = 0; // biggestSum stores the current biggest sum that has been rolled.

	// Contructor: create 6 sides for dice 1 & 2.
	public PairOfDices() {
		die1 = new Die();
		die2 = new Die();
	}

	/**
	 * Constructor: create specific side values for both dices
	 * 
	 * @param value1 value of dice 1
	 * @param value2 value of dice 2
	 */
	public PairOfDices(int value1, int value2) {
		die1 = new Die(value1);
		die2 = new Die(value2);
	}

	// returns the individual faces of each dice
	public int getDieOne() {
		return die1.getFaceValue();
	}

	public int getDieTwo() {
		return die2.getFaceValue();
	}

	// metode: rollBothDices, rolling both dices.
	public void rollBothDices() {
		die1.roll();
		die2.roll();
		if (die1.getFaceValue() == 6)
			sixCount++; // keeps stats of 6's rolled.
		else if (die1.getFaceValue() < 6)
			underSixCount++; // keeps stats of 1, 2, 3, 4, 5's
		if (die2.getFaceValue() == 6)
			sixCount++;
		else if (die2.getFaceValue() < 6)
			underSixCount++;
		// if dices equals each other.
		if (die1.getFaceValue() == die2.getFaceValue())
			pairCount++; // keeps stats of how many pairs.
		// if sum of dices is bigger than the previous biggest sum, then the sum of
		// current dices becomes biggest sum.
		if (sumOfDices() > biggestSum)
			biggestSum = sumOfDices();
		rollCount++; // keeps stats of how many rolls.

		// returns amount of times there has been rolled a six.
	}

	public int getSixCount() {
		return sixCount;
	}

	// returns amount of times there has been rolled 1 to 5.
	public int getUnderSixCount() {
		return underSixCount;
	}

	// returns the sum of both face values.
	public int sumOfDices() {
		return die1.getFaceValue() + die2.getFaceValue();
	}

	// return how many times there has been rolled a pair.
	public int getPairCount() {
		return pairCount;
	}

	// returns the current biggest sum of dices.
	public int getBiggestSum() {
		return biggestSum;
	}

	// resets all counters to start of game.
	public void resetPairOfDice() {
		rollCount = 0;
		sixCount = 0;
		underSixCount = 0;
		pairCount = 0;
		biggestSum = 0;
	}

	// keeps the game in a loop, if player wants to keep playing, then the game
	// rolls the dices again.
	public void gameActive() {
		Scanner in = new Scanner(System.in);
		boolean active = true;
		while (active) { // loop ends when player responds 'no' and active is set to false.
			System.out.println("Do you want to keep rolling? Yes or no: ");
			String response = in.next();
			if (response.equalsIgnoreCase("yes")) {
				rollBothDices();
				System.out.println("\n" + "Dice one rolled: " + getDieOne());
				System.out.println("Dice two rolled: " + getDieTwo());
				System.out.println("The sum of both dices equals: " + sumOfDices());
			} else if (response.equalsIgnoreCase("no"))
				active = false;
			else
				System.out.println("Please try again.");
		}
		in.close();
	}

	// Prints out statistics of the game.
	public void gameOver() {
		System.out.println("\nGame over!\n");
		System.out.println("Game stats:");
		System.out.println("Numbers rolled between 1 and 6: " + (getSixCount() + getUnderSixCount()));
		System.out.println("Number of pairs rolled: " + getPairCount());
		System.out.println("Biggest sum rolled: " + getBiggestSum());
	}
}
