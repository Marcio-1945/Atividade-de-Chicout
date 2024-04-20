package br.edu.uniaeso;

import java.io.*;

public class RemoverPalavra {

  public static void main(String[] args) {

    String ArquivoEntrada = "arquivo.txt";
    String ArquivoSaida = "arquivo_sem_excluir.txt";

    try {

      BufferedReader br = new BufferedReader(new FileReader(ArquivoEntrada));
      BufferedWriter bw = new BufferedWriter(new FileWriter(ArquivoEntrada));

      String linha;

      while ((linha = br.readLine()) != null){

        if (linha.contains("excluir")) {

          bw.write(linha);
          bw.newLine();
          
        }

        bw.close();
        br.close();

      }
    
      System.out.println("Arquivo ordenado criado com sucesso: " + ArquivoSaida);
    } catch (IOException e) {
      System.err.println("Erro ao processar o arquivo: " + e.getMessage());
      
      }
    }
}
