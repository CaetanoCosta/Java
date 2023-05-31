//package Exercicios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class exercicio1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		FileWriter saida = null;
		
		try {
			saida = new FileWriter("mensagem.txt");
			
			System.out.println("Insira sua mensagem: ");
			String mensagem = scan.nextLine();
			
			saida.write(mensagem);
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				saida.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
