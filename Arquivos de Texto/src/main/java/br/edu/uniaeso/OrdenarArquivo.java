package br.edu.uniaeso;

import java.io.*;
import java.util.*;

public class OrdenarArquivo {

  public static void main(String[] args) {

    String ArquivoEntrada = "arquivo.txt";
    String ArquivoSaida = "arquivo_ordenado.txt";

    List<String> linhas = new ArrayList<>();

    try{

    BufferedReader br = new BufferedReader(new FileReader(ArquivoEntrada));
    String linha;

    while ((linha = br.readLine()) != null) {
      linhas.add(linha);
    }

    br.close();

    Collections.sort(linhas);

    BufferedWriter bw = new BufferedWriter(new FileWriter(ArquivoSaida));
    for (String l : linhas) {
        
        bw.write(l);
        bw.newLine();
    }

    bw.close();

    System.out.println("Arquivo ordenado criado com sucesso: " + ArquivoSaida);
        } catch (IOException e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
    }
  }
}