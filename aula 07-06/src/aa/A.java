package aa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class A {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		FileWriter saida = null;
		FileReader entrada = null;
		
		int c;
		String texto = "";
		
		System.out.println("Insira o nome do arquivo: ");
		String nomeArquivo = scan.next();
		
		Integer comecaVogal = 0;
		Integer palavraMaior3 = 0;
		Integer palavraTotal = 0;
		Integer palavraCrase = 0;
		Integer palavraAO = 0;
		
		ArrayList<Character> caractereEspecial = new ArrayList<Character>();
		caractereEspecial.add('.'); caractereEspecial.add(','); caractereEspecial.add(';'); caractereEspecial.add(':'); caractereEspecial.add('?'); caractereEspecial.add('/');
		caractereEspecial.add('!'); caractereEspecial.add('"'); caractereEspecial.add('%'); caractereEspecial.add('0'); caractereEspecial.add('1'); caractereEspecial.add('2');
		caractereEspecial.add('3'); caractereEspecial.add('4'); caractereEspecial.add('5'); caractereEspecial.add('6'); caractereEspecial.add('7'); caractereEspecial.add('8');
		caractereEspecial.add('9');
		
		HashMap<String, Integer> palavrasRepetidas = new HashMap<String, Integer>();
		
		try {
			entrada = new FileReader(nomeArquivo);
			
			while((c=entrada.read()) != -1) {
				char caractere = (char)c;
				if(caractereEspecial.contains(caractere)) {
					
				}else
				texto += caractere;
				if(caractere == 'à' || caractere == 'À') {
					palavraCrase += 1;
				}
			}
			StringTokenizer st = new StringTokenizer(texto);
			String palavra;
			
			texto.toLowerCase();
			
			for(int i = 0; i < st.countTokens(); i++) {
				palavra = st.nextToken();
				palavraTotal += 1;
				//System.out.println("--- " + palavra);
				if(palavra.charAt(0) == 'a' || palavra.charAt(0) == 'e' || palavra.charAt(0) == 'i' || palavra.charAt(0) == 'o' || palavra.charAt(0) == 'u') {
					comecaVogal += 1;
				}
				if(palavra.length() > 3) {
					palavraMaior3 += 1;
					
					if(!palavrasRepetidas.containsKey(palavra)) {
						palavrasRepetidas.put(palavra, 1);
					}else {
						Integer valor = palavrasRepetidas.get(palavra);
						Integer novoValor = valor + 1;
						palavrasRepetidas.replace(palavra, valor, novoValor);						
					}					
				}
				if(palavra.endsWith("ão")) {
					palavraAO += 1;
				}
				
			}
			
			saida = new FileWriter("resultado.txt");
		}catch(IOException e) {
			e.printStackTrace();
		}	
		
		final Map<String, Integer> palavrasRepetidasOrdenada = palavrasRepetidas.entrySet()
		        .stream()
		        .sorted(Map.Entry.comparingByValue())
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println("palavras com mais de 3 letras: " + palavraMaior3);
		System.out.println("palavras que comecam com 'a''e''i''o''u': " + comecaVogal);
		
		int indice=0;
		for(String a : palavrasRepetidasOrdenada.keySet()) {
			
			if(indice++ <=5) {
				System.out.println(a+" = " + palavrasRepetidasOrdenada.get(a));
				System.out.println("------------------------------------");
			}
			
			if(indice >= (palavrasRepetidasOrdenada.size()-5)) {
				System.out.println(a+" = " + palavrasRepetidasOrdenada.get(a));
				System.out.println("------------------------------------");
			}

		}

		System.out.println("total de palavras: " + palavraTotal);
		System.out.println("palavras com crase: " + palavraCrase);
		System.out.println("palavras que terminam com 'ão': " + palavraAO);
	}
}
