package br.edu.uniaeso;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.opencsv.CSVWriter;

public class LojinhaModificada {

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
        return new String[] { nome, String.valueOf(preco), String.valueOf(quantidade) };
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter fileWriter = new FileWriter("produtos.csv", true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            while (true) {
                System.out.println("Insira o nome do produto (ou 'exit' para sair):");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("exit"))
                    break;

                System.out.println("Insira o preço do produto:");
                double preco = Double.parseDouble(scanner.nextLine());

                System.out.println("Insira a quantidade em estoque:");
                int quantidade = Integer.parseInt(scanner.nextLine());

                Produto produto = new Produto(nome, preco, quantidade);
                csvWriter.writeNext(produto.toArray());
            }

            csvWriter.close();
            fileWriter.close();

            System.out.println("Produtos foram adicionados ao arquivo produtos.csv.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: " + e.getMessage());
        }
    }
}