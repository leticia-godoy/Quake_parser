package main;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import model.*;
import parser.*;


public class Main {

	public static void main(String[] args) throws IOException {
		
		File logFile = new File("/Users/macbook/git/Quake_parser/Quake_Parser/src/main/games.log");
		Parser log = new Parser(logFile.getPath());

		Scanner in = new Scanner(System.in);
		int input,id;
		int gameId = 0;
		LinkedList<Game> gameList = new LinkedList<>();
		do{

			System.out.println("_____________game.log-parser-Menu:________________");
			System.out.println("1-Vizualize dados do jogo.");
			System.out.println("2-Vizualize todos os jogos.");
			System.out.println("0-Sair");
			input = in.nextInt();
			
			while(input<0 || input>2 ){
				System.out.println("Valor inválido!Digite novamente");
				input = in.nextInt();
			}
			switch(input){
					case 1:
						System.out.println("Digite o valor de identificação do jogo : ");
						id = in.nextInt();
						Game aux = new Game(id);
						if(log.getAllGames().contains(aux)){
							System.out.println(log.getAllGames().get(id).printGameDetails());
						}
						System.out.println("Jogo não encontrado!");
						break;
					case 2:
						System.out.println(log.getAllGames());
						break;
					case 0:
						break;
				}	
		
		}while(input != 0);
		

	}

}
