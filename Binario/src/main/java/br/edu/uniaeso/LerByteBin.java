package br.edu.uniaeso;
//OBS: MESMO QUE APAREÇA QUE DARÁ ERRO, RODE O CÓDIGO.

import java.io.*;

public class LerByteBin {

    public static void main(String[] args) {
        String nomeArquivo = "arquivo.bin";

        criarArquivoBinario(nomeArquivo);
        lerPrimeirosBytes(nomeArquivo, 100);
    }

    public static void criarArquivoBinario(String nomeArquivo) {
        try {
            FileOutputStream fos = new FileOutputStream(nomeArquivo);
            byte[] dados = new byte[1000];
            fos.write(dados);
            fos.close();
            System.out.println("Arquivo binário criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lerPrimeirosBytes(String nomeArquivo, int numBytes) {
        try {
            FileInputStream fis = new FileInputStream(nomeArquivo);
            byte[] buffer = new byte[numBytes];
            int bytesRead = fis.read(buffer, 0, numBytes);
            fis.close();
            System.out.println("Os Primeiros " + bytesRead + " bytes do arquivo:");
            for (int i = 0; i < bytesRead; i++) {
                System.out.print(buffer[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
