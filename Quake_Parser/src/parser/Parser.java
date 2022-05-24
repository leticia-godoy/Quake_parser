package parser;

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Integer.*;

import model.Game;
import model.Player;

public class Parser {


	public Parser(String file) throws IOException{
		
		try {
			FileInputStream fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			
			int roll = 0;
			int kills_total = 0;
			LinkedList <Game> games = new LinkedList<>();

			// leitura de todas as linhas do doc
			while ((strLine = br.readLine()) != null) {
				if (strLine.contains("InitGame:")) {
					roll++;
					Game newGame = new Game(roll);
					if (strLine.contains("ClientConnect:")) {
						clientConnected(strLine, newGame);
					}
					if (strLine.contains("ClientUserinfoChanged:")) {
						clientNameChanged(strLine, newGame);
					}
					if (strLine.contains("Kill:")) {
						kills_total++;
						gameKill(strLine, kills_total, newGame);
					}
				}//quando jogo acabar, add na lista de jogos principal (games)
				
			}
			fstream.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			
		}
		
	}

	public void clientConnected(String line, Game game) {
		// recupera o dígito após ": "
		String regex = "(:\\s)(\\d)"; // matcher.group(2) == id do player

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);

		if (matcher.find()) {
			int newId = parseInt(matcher.group(2));
			Player player = new Player(newId, null);
			if(!game.getPlayers().equals(player)){
				game.getPlayers().add(player);
			}
		}
	}

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
			int newId = parseInt(matcher.group(2));
			String newName = matcher.group(2);
			Player player = new Player(newId, newName);
			if(!game.getPlayers().equals(player)){
				game.getPlayers().add(player);
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
			int idDeath = parseInt(matcherK.group(4));

			if (idKiller == 1022) {
				for(Player aux : game.getPlayers()){
					if(aux.getId().equals(idVictim)){
						// -1 kill para a vítima do mundo
						int kills = aux.getGame_kills();
						aux.setGame_kills(kills-1);
					}
				}
			}else{
				for(Player aux : game.getPlayers()){
					if(aux.getId().equals(idKiller)){
						// -1 kill para a vítima do mundo
						int kills = aux.getGame_kills()+1;
						aux.setGame_kills(kills);
						aux.getAll_kills().add(kills);
					}
				}
			}
			
		}

	}
}
