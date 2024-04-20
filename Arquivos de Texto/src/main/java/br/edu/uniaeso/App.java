package br.edu.uniaeso;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {

        Scanner ler = new Scanner(System.in);

        System.out.print("Digite o nome do arquivo: ");
        String fileName = ler.nextLine();

        ler.close();

        try {
                FileWriter fileWriterileWriter = new FileWriter(fileName);
                PrintWriter printWriter = new PrintWriter(fileWriterileWriter);

                printWriter.println("Olá Mundo.");
                printWriter.println("Isso é uma adição!");
                printWriter.println("Java");

                printWriter.close();
                fileWriterileWriter.close();

            System.out.println("Arquivo criado com sucesso: " + fileName);
        } catch (IOException e) {

            System.err.println("Arquivo não criado com sucesso: " + e.getMessage());
        }
    }
}