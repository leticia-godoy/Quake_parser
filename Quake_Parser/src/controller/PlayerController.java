package controller;

import model.Player;
import view.PlayerView;

public class PlayerController {

	private Player model_player;
	private PlayerView view_player;
	
	public PlayerController(Player model_player, PlayerView view_player) {
		super();
		this.model_player = model_player;
		this.view_player = view_player;
	}
	
	public int getPlayerId() {
		return model_player.getId();
	}
	public void setPlayerId(int id) {
		model_player.setId(id);
	}

	public String getPlayerName() {
		return model_player.getName();
	}

	public void setPlayerName(String name) {
		model_player.setName(name);
	}

	public Integer[] getPlayersGame_kills() {
		return model_player.getGame_kills();
	}

	public void setPlayersGame_kills(Integer[] game_kills) {
		model_player.setGame_kills(game_kills);
	}
	
	
}
