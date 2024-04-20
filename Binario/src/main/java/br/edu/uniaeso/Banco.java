package br.edu.uniaeso;

import java.io.*;

class ContaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
        }
    }

    public String toString() {
        return "ContaBancaria[" +
                "Titular: '" + titular + '\'' +
                "|| Saldo: " + saldo +
                ']';
    }
}

public class Banco {

public static void main(String[] args) {
        ContaBancaria conta = null;
        String nomeArquivo = "conta.dat";

        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            conta = (ContaBancaria) objIn.readObject();
            objIn.close();
            fileIn.close();

            conta.depositar(500);

            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(conta);
            objOut.close();
            fileOut.close();

            System.out.println("ContaBancaria atualizada e salva em " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}