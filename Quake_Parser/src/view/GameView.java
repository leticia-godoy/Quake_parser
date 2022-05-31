package view;

import model.Player;

public class GameView {

	public void printGameDetails(int roll, int kills_total, Player[] players, String[] kills_specif) {
		System.out.println("Game Number : " + roll);
		System.out.println("Total kills : " + kills_total);
		System.out.println("Players : " + players);
		System.out.println("Kills : " + kills_specif);
		System.out.println("");
	}
}
