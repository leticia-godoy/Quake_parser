package model;

import java.util.LinkedList;

public class Player {

	private Integer id;
	private String name;
	private Integer game_kills;
	private LinkedList<Integer> all_kills;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGame_kills() {
		return game_kills;
	}
	public void setGame_kills(Integer game_kills) {
		this.game_kills = game_kills;
	}
	public LinkedList<Integer> getAll_kills() {
		return all_kills;
	}
	public void setAll_kills(LinkedList<Integer> all_kills) {
		this.all_kills = all_kills;
	}

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String printPlayerDetails() {
		return "Player ID : " + this.id + "/n" + "Player's name : " + this.name+ "/n" + "Player's kills in each game: " + this.game_kills+"/n";		
	}
	

}
