package main;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import model.Game;
import parser.Parser;

public class Main {

	public static void main(String[] args) throws IOException {
		File logFile = new File("/Users/macbook/git/Quake_parser/Quake_Parser/src/main/games.log");
		Parser log = new Parser(logFile.getPath());
		
		Scanner in = new Scanner(System.in);
		String input;
		int gameId = 0;
		
		System.out.println("Digite o valor de identificação do jogo : ");
		input = in.next();
		try {
			gameId = Integer.valueOf(input);
			System.out.println(log.getClass());
		} catch (NumberFormatException ne) {
			System.out.println("Digite um número!");
		}

	

	}

}
