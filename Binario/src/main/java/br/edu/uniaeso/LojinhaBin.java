package br.edu.uniaeso;
//OBS: MESMO QUE APAREÇA QUE DARÁ ERRO, RODE O CÓDIGO.

import java.io.*;

class Produto implements Serializable {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String toString() {
        return "Lojinha [" +
                "ID: " + id +
                "|| Nome: " + nome + '\'' +
                "|| Preço: " + preco +
                ']';
    }
}

public class LojinhaBin {

    public static void main(String[] args) {
        Produto[] produtos = {
                new Produto(1, "Banana", 6.00),
                new Produto(2, "Creme", 17.99),
                new Produto(3, "Água de Coco", 7.99)
        };

        String nomeArquivo = "produtos.dat";

        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(produtos);
            objOut.close();
            fileOut.close();
            System.out.println("O Array da Lojinha está serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Produto[] produtosDesserializados = null;
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            produtosDesserializados = (Produto[]) objIn.readObject();
            objIn.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (produtosDesserializados != null) {
            System.out.println("\nLojinha Desserializados:");
            for (Produto produto : produtosDesserializados) {
                System.out.println(produto);
            }
        }
    }
}
