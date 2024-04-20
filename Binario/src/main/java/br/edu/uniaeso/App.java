package br.edu.uniaeso;

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

public class App {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Jair", 32);
        String nomeArquivo = "pessoa.dat";

        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(pessoa);
            objOut.close();
            fileOut.close();
            System.out.println("Objeto Pessoa serializado e salvo em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}