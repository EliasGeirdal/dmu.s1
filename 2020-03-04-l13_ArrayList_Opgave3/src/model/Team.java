package model;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players;

	public Team(String name) {
		this.name = name;
		players = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void printPlayers() {
		for (Player element : players) {
			System.out.println(
					"Name: " + element.getName() + "\nAge: " + element.getAge() + "\nScore: " + element.getScore());
			System.out.println("_______________________________");
		}
	}

	public double calcAverageAge() {
		double sum = 0;
		for (int i = 0; i < players.size(); i++) {
			sum += players.get(i).getAge();
		}
		if (players.size() == 0)
			return 0;
		else
			return sum / players.size();
	}

	// totale score for alle spillere på holdet.
	public int calcTotalScore() {
		int totalScore = 0;
		for (int i = 0; i < players.size(); i++) {
			totalScore += players.get(i).getScore();
		}
		return totalScore;
	}

	// udregner score for alle spillere under age limit.
	public int calcOldPlayersScore(int ageLimit) {
		int totalScore = 0;
		for (int i = 0; i < players.size(); i++) {
			if (ageLimit > players.get(i).getAge()) {
				totalScore += players.get(i).getScore();
			}
		}
		return totalScore;
	}

	// Returnerer den højeste score for samtlige spillere.
	public int maxScore() {
		int maxScore = Integer.MIN_VALUE;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getScore() > maxScore)
				maxScore = players.get(i).getScore();
		}
		return maxScore;
	}

	public String bestPlayer() {
		String bestPlayer = " ";
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getScore() == maxScore()) {
				bestPlayer = players.get(i).getName();
			}
		}
		return bestPlayer;
	}
}
