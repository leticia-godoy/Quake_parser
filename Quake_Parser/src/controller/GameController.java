package controller;

import model.*;
import view.*;


public class GameController {

	private Game model_game;
	private GameView view_game;

	public GameController(Game model_game, GameView view_game) {
		super();
		this.model_game = model_game;
		this.view_game = view_game;
	}

	public int getGameRoll() {
		return model_game.getRoll();
	}

	public void setGameRoll(int roll) {
		model_game.setRoll(roll);
	}

	public int getGameKills_total() {
		return model_game.getKills_total();
	}

	public void setGameKills_total(int kills_total) {
		model_game.setKills_total(kills_total);
	}

	public Player[] getGamePlayers() {
		return (Player[]) model_game.getPlayers();
	}

	public void setGamePlayers(Player[] players) {
		model_game.setPlayers(players);
	}

	public String[] getGameKills_specif() {
		return model_game.getKills_specif();
	}

	public void setGameKills_specif(String[] kills_specif) {
		model_game.setKills_specif(kills_specif);
	}

	public void updateView() {
		view_game.printGameDetails(model_game.getRoll(), model_game.getKills_total(), model_game.getPlayers(),
				model_game.getKills_specif());
	}

}
