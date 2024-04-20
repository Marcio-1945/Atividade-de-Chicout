package br.edu.uniaeso;
//OBS: MESMO QUE APAREÇA QUE DARÁ ERRO, RODE O CÓDIGO.

import java.io.*;

class Pessoa implements Serializable {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class NovoApp {

    public static void main(String[] args) {
        // Desserialização do objeto
        Pessoa pessoa = null;
        String nomeArquivo = "pessoa.dat";

        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            pessoa = (Pessoa) objIn.readObject();
            objIn.close();
            fileIn.close();

            // Exibindo os detalhes da pessoa
            System.out.println("Detalhes da Pessoa:");
            System.out.println("Nome: " + pessoa.getNome());
            System.out.println("Idade: " + pessoa.getIdade());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}