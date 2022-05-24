package view;

import java.util.LinkedList;

import model.Player;

public class GameView {

	public void printGameDetails(int roll, int kills_total, LinkedList<Player> players) {
		System.out.println("Game Number : " + roll);
		System.out.println("Total kills : " + kills_total);
		System.out.println("Players : " + players);
		System.out.println("");
	}
}
