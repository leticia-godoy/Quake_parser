package view;

public class PlayerView {

	public void printPlayerDetails(Integer id, String name, Integer[] game_kills) {
		System.out.println("Player ID : " + id);
		System.out.println("Player's name : " + name);
		System.out.println("Player's kills in each game: " + game_kills);
		System.out.println("Total kills : " );		
	}
}
