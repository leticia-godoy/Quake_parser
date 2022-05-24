package model;

import java.util.LinkedList;

public class Game {

	private int roll;
	private int Kills_total;
	private LinkedList<Player> players;

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public int getKills_total() {
		return Kills_total;
	}

	public void setKills_total(int kills_total) {
		Kills_total = kills_total;
	}

	public LinkedList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(LinkedList<Player> players) {
		this.players = players;
	}
	public Game(int roll) {
		super();
		this.roll = roll;
	}

}
