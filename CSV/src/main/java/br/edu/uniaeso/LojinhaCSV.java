package br.edu.uniaeso;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class LojinhaCSV {

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

    public String toString() {
        return "Nome: " + nome + ", Preço: R$" + preco + ", Quantidade: " + quantidade;
    }

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("Produtos.csv");
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> linhas = csvReader.readAll();

            for (String[] linha : linhas) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);
                Produto produto = new Produto(nome, preco, quantidade);
                System.out.println(produto);
            }

            csvReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }
}
