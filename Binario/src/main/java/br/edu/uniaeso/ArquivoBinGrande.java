package br.edu.uniaeso;
//OBS: MESMO QUE APAREÇA QUE DARÁ ERRO, RODE O CÓDIGO.

import java.io.*;

public class ArquivoBinGrande {

    public static void main(String[] args) {
        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        criarArquivoBinario(arquivoOrigem, 100 * 1024 * 1024);

        copiarArquivoBinarioComBuffer(arquivoOrigem, arquivoDestino);

        System.out.println("Cópia do arquivo concluída!");
    }

    public static void criarArquivoBinario(String nomeArquivo, int tamanhoBytes) {
        try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
            byte[] buffer = new byte[1024];
            for (int i = 0; i < tamanhoBytes / 1024; i++) {
                fos.write(buffer);
            }
            System.out.println("Arquivo binário grande criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copiarArquivoBinarioComBuffer(String arquivoOrigem, String arquivoDestino) {
        try (FileInputStream fis = new FileInputStream(arquivoOrigem);
                FileOutputStream fos = new FileOutputStream(arquivoDestino)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}