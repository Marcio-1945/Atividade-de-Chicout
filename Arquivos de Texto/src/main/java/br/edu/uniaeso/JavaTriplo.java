package br.edu.uniaeso;

import java.io.*;

public class JavaTriplo {

    public static void main(String[] args) {

        String conteudoArquivo1 = "Português: Olá!";
        String conteudoArquivo2 = "Español: Hola!";

        criarEAtualizarArquivo("arquivo1.txt", conteudoArquivo1);
        criarEAtualizarArquivo("arquivo2.txt", conteudoArquivo2);

        String conteudoConcatenado = lerArquivo("arquivo1.txt") + lerArquivo("arquivo2.txt");

        criarEAtualizarArquivo("arquivo_concatenado.txt", conteudoConcatenado);

        
        System.out.println("Arquivos foram concatenados com sucesso!");
    }

    private static void criarEAtualizarArquivo(String nomeArquivo, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
    }

    private static String lerArquivo(String nomeArquivo) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + nomeArquivo);
            e.printStackTrace();
        }
        return conteudo.toString();
    }

}
