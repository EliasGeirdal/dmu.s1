package model;

public class TeamApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team team = new Team("SuperTeam");
		Player p1 = new Player("Alpha", 20);
		Player p2 = new Player("Bravo", 24);
		Player p3 = new Player("Charlie", 20);
		team.addPlayer(p1);
		team.addPlayer(p2);
		team.addPlayer(p3);
		p1.addScore(500);
		p2.addScore(300);
		p3.addScore(200);
		team.printPlayers();
		System.out.println("The average age of the team is: " + team.calcAverageAge());
		System.out.println("The best player is: " + team.bestPlayer());
		System.out.println("The total score is: " + team.calcTotalScore());
		System.out.println("The total score of players younger than limit is: " + team.calcOldPlayersScore(21));
	}

}
