package br.edu.uniaeso;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.opencsv.CSVWriter;

public class OpenCSV {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter("funcionarios.csv");
            CSVWriter csvWriter = new CSVWriter(writer);

            while (true) {
                System.out.println("Insira o nome do funcionário (ou 'exit' para sair):");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("exit"))
                    break;

                System.out.println("Insira o cargo do funcionário:");
                String cargo = scanner.nextLine();

                System.out.println("Insira o salário do funcionário:");
                double salario = scanner.nextDouble();
                scanner.nextLine();

                String[] linha = { nome, cargo, String.valueOf(salario) };
                csvWriter.writeNext(linha);
            }

            csvWriter.close();
            writer.close();

            System.out.println("Dados dos funcionários foram gravados no arquivo funcionarios.csv.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}
