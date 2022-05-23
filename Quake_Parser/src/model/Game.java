package model;

public class Game {

	private int roll;
	private int Kills_total;
	private Player[] players;
	private String[] kills_specif;

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

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] p) {
		players = p;
	}

	public String[] getKills_specif() {
		return kills_specif;
	}

	public void setKills_specif(String[] kills_specif) {
		this.kills_specif = kills_specif;
	}


}
