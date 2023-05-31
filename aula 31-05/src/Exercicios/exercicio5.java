//package Exercicios;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

public class exercicio5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		FileWriter saida = null;
		
		String numero = "";
		
		for(int contador=0; contador<10; contador++) {
			System.out.println("Insira um numero: ");
			numero += scan.nextLine();
			numero += " ";
		}
		
		try {
			saida = new FileWriter("num.txt");
			
			saida.write(numero);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				saida.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
