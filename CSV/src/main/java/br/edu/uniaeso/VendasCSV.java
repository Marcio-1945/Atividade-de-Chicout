package br.edu.uniaeso;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

public class VendasCSV {

    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader("funcionarios.csv"));
            Scanner scanner = new Scanner(System.in);

            String[] headers = reader.readNext();
            System.out.println("Critérios de filtro disponíveis: ");
            for (String header : headers) {
                System.out.print(header + " ");
            }
            System.out.println("\n");

            System.out.println("Funcionários disponíveis: ");
            List<String[]> funcionarios = reader.readAll();
            for (String[] funcionario : funcionarios) {
                for (String info : funcionario) {
                    System.out.print(info + " ");
                }
                System.out.println();
            }
            System.out.println();

            System.out.print("Digite o critério de filtro (ex: Cargo ou Salário): ");
            String criterio = scanner.nextLine();

            System.out.print("Digite o valor para o critério de filtro: ");
            String valor = scanner.nextLine();

            System.out.println("\nResultados do filtro:");
            for (String[] funcionario : funcionarios) {
                if (funcionario[getIndex(headers, criterio)].equalsIgnoreCase(valor)) {
                    for (String info : funcionario) {
                        System.out.print(info + " ");
                    }
                    System.out.println();
                }
            }

            reader.close();
            scanner.close();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }

    private static int getIndex(String[] headers, String header) {
        for (int i = 0; i < headers.length; i++) {
            if (headers[i].equalsIgnoreCase(header)) {
                return i;
            }
        }
        return -1;
    }
}