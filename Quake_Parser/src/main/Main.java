package main;

import java.io.*;
import java.util.Scanner;
import parser.Parser;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String input;
		int gameId = 0;
		System.out.println("Digite o valor de identificação do jogo : ");
		input = in.next();
		try {
			gameId = Integer.valueOf(input);
		} catch (NumberFormatException ne) {
			System.out.println("Digite um número!");
		}

	

	}

}
