package br.edu.uniaeso;

import java.io.BufferedReader;
import java.io.FileReader;

public class dadoscsv {

    public static void main(String[] args) {

        String caminhoArquivo = "dados.csv";


        try {

            FileReader arquivoLeitura = new FileReader(caminhoArquivo);
            BufferedReader leitor = new BufferedReader(arquivoLeitura);

            String linha;

            while ((linha = leitor.readLine()) != null){
                String[] campos = linha.split(",");
                
                for (String campo : campos) {
                    System.out.print(campo + " | ");
                }

                System.out.println();
            }
            
            leitor.close();
            
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());

        }
    }
}