package br.edu.uniaeso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class JavapraPython {

    public static void main(String[] args) {

        String ArquivoEntrada = "arquivo.txt";
        String ArquivoSaida = "arquivopython.txt";

        try {

            Scanner scanner = new Scanner(new File(ArquivoEntrada));
            PrintWriter writer = new PrintWriter(ArquivoSaida);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                linha = linha.replaceAll("Java", "Python");
                writer.println(linha);
            }

            scanner.close();
            writer.close();


            System.out.println("Substituição concluída com sucesso.");
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}
