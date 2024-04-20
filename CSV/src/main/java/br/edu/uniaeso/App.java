package br.edu.uniaeso;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String arquivoCSV = "alunos.csv";

        try (OpenCSV reader = new OpenCSV()) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                for (String campo : linha) {
                    System.out.print(campo + "\t");
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}