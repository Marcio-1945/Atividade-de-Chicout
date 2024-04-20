package br.edu.uniaeso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class arquivocsv {
    public static void main(String[] args) {

        String caminhoArquivo = "dados.csv";

        try {

            FileWriter arquivoEscrita = new FileWriter(caminhoArquivo);

            PrintWriter gravador = new PrintWriter(arquivoEscrita);

            gravador.println("Nome,Idade,Cidadania");
            gravador.println("Walter,42,Brasileiro");
            gravador.println("Paul,22,Estadunidense");
            gravador.println("Zao,100,Chinês");

            gravador.close();

            System.out.println("Arquivo CSV criado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
