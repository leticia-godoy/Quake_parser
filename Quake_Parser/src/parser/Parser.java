package parser;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Integer.*;

import model.Game;
import model.Player;

public class Parser {

	LinkedList <Game> games = new LinkedList<>();

	public Parser(String file) throws IOException{
			
		FileInputStream fstream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;		
		int roll = 0;
		int kills_total = 0;
					
		try {
			
			
			// leitura de todas as linhas do doc
			while ((strLine = br.readLine()) != null) {
				
				if (strLine.contains("InitGame:")) {
					roll = +1;
					Game newGame = new Game(roll);
					kills_total = 0;
					games.add(newGame);
					
					while(!strLine.contains("ShutdownGame:")){
						
						if (strLine.contains("ClientUserinfoChanged:")) {
							clientNameChanged(strLine, newGame);
						
						}						
						else if (strLine.contains("Kill:")) {
							kills_total++;
							newGame.setKills_total(kills_total);
							gameKill(strLine, kills_total, newGame);
						
						}

					}
				
				
				}										
			}fstream.close();								
			
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}
		
	//criação de jogadores para adição na lista do jogo atual
	public void clientNameChanged(String line, Game game) {
		// recupera tudo entre o "n/" e o "\t"
		String regexName = "(n\\\\)(.*?)(\\\\t)"; // matcher.group(2) == nome player
		// recupera o dígito antes do espaço + "n/"
		String regexId = "(\\d)(\\sn\\\\)"; // matcherId.group(1) == id do player

		Pattern pattern = Pattern.compile(regexName);
		Matcher matcher = pattern.matcher(line);

		Pattern patternId = Pattern.compile(regexId);
		Matcher matcherId = patternId.matcher(line);

		if (matcher.find() && matcherId.find()) {
			int newId = parseInt(matcherId.group(1));
			String newName = matcher.group(2);
			
			//Quando o jogador já existe
			//procurar e não encontrar id na lista == null
			if(game.searchPlayer(newId) != null){
				game.getPlayers().get(newId).setName(newName);
			}else{
				Player newP = new Player(newId, newName);
				game.getPlayers().add(newP);
			}				
		    
		}	
			
	}

	public void gameKill(String line,Integer kills_total, Game game) {
		game.setKills_total(kills_total);
		// IDs de quem matou, morreu e método (respectivamente)
		String regexKill = "(:\\s)(\\d*)\\s(\\d*)\\s(\\d*)"; // matcher.group a partir do 2

		Pattern patternK = Pattern.compile(regexKill);
		Matcher matcherK = patternK.matcher(line);

		if (matcherK.find()) {
			int idKiller = parseInt(matcherK.group(2));
			int idVictim = parseInt(matcherK.group(3));
			//int idDeath = parseInt(matcherK.group(4));
			
			//Quando a morte não envolve outro jogador = -1kill da vítima			
			if (idKiller == 1022) {
				if(game.searchPlayer(idVictim) != null){
					// -1 kill para a vítima do mundo
					int kills = game.getPlayers().get(idVictim).getGame_kills();
					game.getPlayers().get(idVictim).setGame_kills(kills-1);
				}
			}else{				
				if(game.searchPlayer(idKiller) != null){					
					int kills = game.getPlayers().get(idKiller).getGame_kills();
					game.getPlayers().get(idKiller).setGame_kills(kills+1);
				}
			}
			
		}

	}	
	public LinkedList<Game> getAllGames() {
		return games;
	}	
}
