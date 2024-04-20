package br.edu.uniaeso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ContarLInhas {

    public static void main(String[] args){
        int count = 0;
        try {
             File file = new File ("arquivo.txt");
             Scanner sc = new Scanner(file);

             while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
             }

             System.out.println("O número total de linhas: " + count);

             sc.close();

            } catch (IOException e) {
                System.err.println("Arquivo não encontrado: " + e.getMessage());
        }
    }
}
