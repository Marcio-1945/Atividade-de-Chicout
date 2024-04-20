package br.edu.uniaeso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lerjava {

    public static void main(String[] args) {

        String arquivo = "meuarquivo.txt";
        String palavraAlvo = "Java";
        int contador = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] palavras = linha.split(" ");
                for (String palavra : palavras) {

                    if (palavra.equalsIgnoreCase(palavraAlvo)) {
                        contador++;

                        }
                    }

                }
            
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
            System.out.println("A palavra '" + palavraAlvo + "' aparece " + contador + " vezes no arquivo.");

    }
}