package br.edu.uniaeso;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

public class LojinhaModificada3 {
    
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

    @SuppressWarnings("resource")
    public static void main(String[] args) throws CsvException {
        Scanner scanner = new Scanner(System.in);

        try {
            FileReader fileReader = new FileReader("produtos.csv");
            CSVReader csvReader = new CSVReader(fileReader);

            List<String[]> linhas = csvReader.readAll();
            List<Produto> produtos = new ArrayList<>();

            System.out.println("Produtos no arquivo:");
            for (String[] linha : linhas) {
                Produto produto = new Produto(linha[0], Double.parseDouble(linha[1]), Integer.parseInt(linha[2]));
                produtos.add(produto);
                System.out.println(produto.getNome() + " | Preço: $" + produto.getPreco() + " | Quantidade: "
                        + produto.getQuantidade());
            }

            System.out.println("\nDigite o nome do produto que deseja excluir (ou 'exit' para sair):");
            String produtoExcluir = scanner.nextLine();

            if (produtoExcluir.equalsIgnoreCase("exit")) {
                System.out.println("Saindo...");
                return;
            }

            boolean encontrado = false;
            for (Produto produto : produtos) {
                if (produto.getNome().equalsIgnoreCase(produtoExcluir)) {
                    encontrado = true;
                    produtos.remove(produto);
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("Produto não encontrado.");
            } else {
                FileWriter fileWriter = new FileWriter("produtos.csv");
                CSVWriter csvWriter = new CSVWriter(fileWriter);

                for (Produto produto : produtos) {
                    csvWriter.writeNext(produto.toArray());
                }

                csvWriter.close();
                fileWriter.close();

                System.out.println("Produto excluído com sucesso do arquivo produtos.csv.");
            }

            csvReader.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever no arquivo CSV: " + e.getMessage());
        }
    }
}