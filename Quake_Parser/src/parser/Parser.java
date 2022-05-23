package parser;

import java.io.*;
import java.util.ArrayList;

import model.Game;

public class Parser {

	public void parse() {
		try {
			FileInputStream fstream = new FileInputStream("abc.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			int roll = 0, kills_total = 0;

			// leitura de todas as linhas do doc
			while ((strLine = br.readLine()) != null) {

				// System.out.println (strLine);

				if (strLine.contains("InitGame:") == true) {
					roll++;
					newGame(roll, strLine, kills_total);
				}
			}
			fstream.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();

		}

	}

	public void newGame(Integer roll, String strLine, Integer kills_total) {
		Game gamedata = new Game();
		kills_total = 0;
		gamedata.setRoll(roll);
		if(strLine.contains("ClientUserinfoChanged:") == true) {
			String player = null;
			//filtrar nome do jogador do documento
			
		}
		if (strLine.contains("Kill:") == true) {
			kills_total++;
			// retornar string de dados e separar o que for nome de jogador
		}

	}
}
