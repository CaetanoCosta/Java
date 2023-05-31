//package Exercicios;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class exercicio3 {
	public static void main(String[] args) {
		Integer contadorVogais = 0;
		Integer contadorConsoantes = 0;
		Integer contadorOutrosCaracteres = 0;
		Integer contadorCaracteresTotais = 0;
		
		FileReader entrada = null;
		
		ArrayList<Character> vogais = new ArrayList<Character>();
		
		vogais.add('a'); vogais.add('e'); vogais.add('i'); vogais.add('o'); vogais.add('u');
		
		ArrayList<Character> consoantes = new ArrayList<Character>();
		
		consoantes.add('b'); consoantes.add('c'); consoantes.add('d'); consoantes.add('f'); consoantes.add('g'); consoantes.add('h'); consoantes.add('j'); 
		consoantes.add('k'); consoantes.add('l'); consoantes.add('m'); consoantes.add('n'); consoantes.add('p'); consoantes.add('q'); consoantes.add('r'); 
		consoantes.add('s'); consoantes.add('t'); consoantes.add('v'); consoantes.add('w'); consoantes.add('x'); consoantes.add('y'); consoantes.add('z');
		
		try {
			entrada = new FileReader("arquivo.txt");
			
			int c;
			while((c = entrada.read()) != -1) {
				Character caracter = (char) c;
				caracter = Character.toLowerCase(caracter);
				
				if(vogais.contains(caracter)) {
					contadorVogais += 1;
					contadorCaracteresTotais += 1;
				} else if(consoantes.contains(caracter)) {
							contadorConsoantes += 1;
							contadorCaracteresTotais += 1;
						} else {
							contadorOutrosCaracteres += 1;
							contadorCaracteresTotais += 1;
						}
			}
			
			System.out.println("Total de vogais: " + contadorVogais);
			System.out.println("Total de consoantes: " + contadorConsoantes);
			System.out.println("Total de outros caracteres: " + contadorOutrosCaracteres);
			System.out.println("Total de caracteres: " + contadorCaracteresTotais);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				entrada.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
