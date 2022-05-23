package model;

public class Player {

	private int id;
	private String name;
	private Integer[] game_kills;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer[] getGame_kills() {
		return game_kills;
	}
	public void setGame_kills(Integer[] game_kills) {
		this.game_kills = game_kills;
	}

	

}
