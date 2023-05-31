package Exercicios;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class exercicio4 {
	public static void main(String[] args){
		FileWriter saida = null;
		FileReader entrada = null;
		
		String arquivo = "";
		String notas[] = new String[3];
		
		int x=0;
		
		try {
			entrada = new FileReader("notas.txt");
			
			int c;
			while((c = entrada.read()) != -1) {
				arquivo += (char) c;
			}
			notas = arquivo.split(" ");
			double n1 = Double.valueOf(notas[0]).doubleValue();
			double n2 = Double.valueOf(notas[1]).doubleValue();
			double n3 = Double.valueOf(notas[2]).doubleValue();
			
			double media = (n1+n2+n3)/3;
			
			String mediaTexto = Double.toString(media);
			
			arquivo += " ";
			arquivo += mediaTexto;
			
			saida = new FileWriter("notas.txt");
			saida.write(arquivo);			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				saida.close();
				entrada.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
