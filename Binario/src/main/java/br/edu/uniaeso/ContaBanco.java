package br.edu.uniaeso;

import java.io.*;

public class ContaBanco {
    
    public static void main(String[] args) {

        ContaBancaria contaInicial = new ContaBancaria("Silva", 1200.0);
        String nomeArquivo = "conta.dat";

        try {

            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(contaInicial);
            
            objOut.close();
            fileOut.close();
           
            System.out.println("ContaBancaria inicial foi criada e salva em " + nomeArquivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}