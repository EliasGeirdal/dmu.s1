package dicegames;

import java.util.Scanner;

public class PigPlay {

	private Die die;
	private int player1Sum = 0; // Accumulated points of current game.
	private int player2Sum = 0;
	private Scanner in = new Scanner(System.in);
	private boolean playerTurn = true; // if playerTurn is true, it is player 1's turn.
	private int goal; // goal is 100 in parameterless constructor and can be set in the constructor
						// with parameters.
	private double turnCounter1 = 0.0;
	private double turnCounter2 = 0.0;
	private double rollCounter1 = 0.0;
	private double rollCounter2 = 0.0;
	private boolean computer = false;

	// Constructor - game is by default ending after 100 points.
	public PigPlay() {
		die = new Die();
		this.goal = 100;
	}

	// Constructor - player chooses how many points they want to play to.
	public PigPlay(int goal) {
		die = new Die();
		this.goal = goal;
	}

	// greets the player to the game.
	public void welcomeToGame() {
		System.out.println("Greetings! \nWelcome to Pig!");
	}

	// Prints whom won. The one with the greatest sum has won.
	public void gameOver() {
		if (player1Sum > player2Sum)
			System.out.println("\nCongratulations player 1, you have won.");
		else {
			if (computer == false)
				System.out.println("\nCongratulations player 2");
			else
				System.out.println("\nThe computer has won, better luck next time.");
		}
		System.out.println("Player 1 averagely rolled: " + (rollCounter1 / turnCounter1) + " per turn.");
		// takes into account if the computer wins.
		if (computer == false)
			System.out.println("Player 2 averagely rolled: " + (rollCounter2 / turnCounter2) + " per turn.");
		else
			System.out.println("The computer averagely rolled: " + (rollCounter2 / turnCounter2) + " per turn.");

	}

	// randomizes the initial turn. if it is 1, player one begins.
	public void initialTurn() {
		int random = (int) (Math.random() * 2 + 1);
		if (random == 1)
			playerTurn = true;
		else
			playerTurn = false;
	}

	// changes the turn of the player.
	public void swapTurn() {
		if (playerTurn)
			playerTurn = false;
		else
			playerTurn = true;
	}

	// Called after each rolled. Tracking how many rolls to keep statistics over
	// average rolls per round.
	public void updateRollCounter() {
		if (playerTurn)
			rollCounter1++;
		else
			rollCounter2++;
	}

	// Called after each turn. Tracking how many turns each player has been through.
	// Same reason as above.
	public void updateTurnCounter() {
		if (playerTurn)
			turnCounter1++;
		else
			turnCounter2++;
	}

	// Simulates the turn of given player.
	public void takeTurn() {
		int points = 0; // keeps track of accumulated points during the round. Adds up to greater sum
						// unless player rolls 1.
		boolean turn = true;
		while (turn) {
			System.out.println("Do you want to roll?");
			String response = in.next();
			if (response.equalsIgnoreCase("yes")) {
				die.roll();
				updateRollCounter();
				System.out.println("you rolled: " + die.getFaceValue());
				if (die.getFaceValue() == 1) { // ends turn if rolled 1.
					turn = false;
					System.out.println("Too bad, you have scored 0 points this round.");
				} else { // if not, gives update of accumulated points.
					points = points + die.getFaceValue();
					System.out.println("You have scored: " + points + " so far.");
				}
			} else if (response.equalsIgnoreCase("no")) { // ends turn and updates the adds the points into the greater
															// sum i.e. player1Sum/player2Sum.
				if (playerTurn) {
					player1Sum += points;
					System.out.println("Well done, player 1. You scored: " + points + " this round.");
					System.out.println("Player 1 has: " + player1Sum + " in total.");
				} else {
					player2Sum += points;
					System.out.println("Well done, player 1. You scored: " + points + " this round.");
					System.out.println("Player 2 has: " + player2Sum + " in total.");
				}
				turn = false; // ends turn.
			} else
				System.out.println("please try again."); // typos' restarts loop.
		}
		updateTurnCounter();
		swapTurn(); // Changes players turn.
	}

	// If player 1 chose to play against the computer.
	// Same procedure as in method takeTurn.
	public void versusComputer() {
		int rolls = (int) (Math.random() * 5); // the computer can maximum roll 5 times, and it is random between 1 and
												// 5.
		int counter = 0;
		int points = 0;
		while (counter <= rolls && !playerTurn) {
			die.roll();
			updateRollCounter();
			System.out.println("The computer has rolled: " + die.getFaceValue());
			if (rolls == 1) {
				updateTurnCounter();
				swapTurn();
			} else {
				points += die.getFaceValue();
				System.out.println("The computer has scored: " + points + " so far.");
				counter++;
			}
		}
		if (!playerTurn) {
			player2Sum += points;
			System.out.println("The computer has: " + player2Sum + " in total.");
			updateTurnCounter();
			swapTurn();
		}
	}

	// the player is prompted if they want to play against a computer.
	public void chooseOpponent() {
		System.out.println("Do you want to play against a computer?");
		String response = in.next();
		if (response.equalsIgnoreCase("yes")) {
			computer = true;
		} else if (response.equalsIgnoreCase("no")) {
			computer = false;
		} else {
			System.out.println("Invalid response, please type 'yes' or 'no'.");
			chooseOpponent(); // if there's a typo, we want to prompt the user again until they type
								// correctly.
		}

	}

	// begin the game by method; startGame.
	public void startGame() {
		welcomeToGame(); // greets player.
		chooseOpponent(); // Chooses if they want to play against the computer or player.
		initialTurn(); // mixes up who begins.
		while (player1Sum < goal && player2Sum < goal) { // The game ends when one player has reached the goal.
			if (computer == true && playerTurn == false) { // If player 1 plays against the computer.
				System.out.println("\nComputer begins.");
				versusComputer(); // calls method for computers actions.
			} else { // if player 1 plays against player 2.
				if (playerTurn == true) {
					System.out.println("\nPlayer one begins.");
				} else
					System.out.println("\nPlayer two begins.");
				takeTurn();
			}
		}
		gameOver(); // prints out statistics from previous game.
		in.close();
	}
}
