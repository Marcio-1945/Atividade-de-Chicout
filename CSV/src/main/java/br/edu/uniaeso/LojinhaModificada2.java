package br.edu.uniaeso;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class LojinhaModificada2 {

    private String nome;
    private double preco;
    private int quantidade;

    public void Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String[] toArray() {
        return new String[]{nome, String.valueOf(preco), String.valueOf(quantidade)};
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) throws CsvException {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        try {
            FileReader fileReader = new FileReader("produtos.csv");
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> linhas = csvReader.readAll();

            System.out.println("Produtos no arquivo:");
            for (String[] linha : linhas) {
                System.out.println(linha[0] + " | Preço: $" + linha[1] + " | Quantidade: " + linha[2]);
            }

            System.out.println("\nDigite o nome do produto que deseja atualizar (ou 'exit' para sair):");
            String produtoAtualizar = scanner.nextLine();

            if (produtoAtualizar.equalsIgnoreCase("exit")) {
                System.out.println("Saindo...");
                return;
            }

            boolean encontrado = false;
            for (String[] linha : linhas) {
                if (linha[0].equalsIgnoreCase(produtoAtualizar)) {
                    encontrado = true;

                    System.out.println("Produto encontrado. Insira os novos detalhes:");

                    System.out.println("Novo preço:");
                    double novoPreco = Double.parseDouble(scanner.nextLine());

                    System.out.println("Nova quantidade em estoque:");
                    int novaQuantidade = Integer.parseInt(scanner.nextLine());

                    linha[1] = String.valueOf(novoPreco);
                    linha[2] = String.valueOf(novaQuantidade);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado.");
            } else {
                FileWriter fileWriter = new FileWriter("produtos.csv");
                CSVWriter csvWriter = new CSVWriter(fileWriter);

                for (String[] linha : linhas) {
                    csvWriter.writeNext(linha);
                }

                csvWriter.close();
                fileWriter.close();

                System.out.println("Produto atualizado com sucesso no arquivo produtos.csv.");
            }

            csvReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo CSV: " + e.getMessage());
        }
    }
}