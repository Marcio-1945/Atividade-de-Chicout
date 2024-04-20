package br.edu.uniaeso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private double salario;

    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionário [ID: " + id + ", Nome: " + nome + ", Salario:" + salario + "]";
    }
}

class ArquivoFuncionarios {
    private String nomeArquivo;

    public ArquivoFuncionarios(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo, true))) {
            outputStream.writeObject(funcionario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            while (true) {
                Funcionario funcionario = (Funcionario) inputStream.readObject();
                funcionarios.add(funcionario);
            }
        } catch (EOFException e) {


        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void atualizarFuncionario(int id, Funcionario novoFuncionario) {
        List<Funcionario> funcionarios = listarFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                funcionarios.set(i, novoFuncionario);
                salvarLista(funcionarios);
                return;
            }
        }
        System.out.println("Funcionário com ID " + id + " não encontrado.");
    }

    public void excluirFuncionario(int id) {
        List<Funcionario> funcionarios = listarFuncionarios();
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getId() == id) {
                funcionarios.remove(i);
                salvarLista(funcionarios);
                return;
            }
        }
        System.out.println("Funcionário com ID " + id + " não encontrado.");
    }

    private void salvarLista(List<Funcionario> funcionarios) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            for (Funcionario funcionario : funcionarios) {
                outputStream.writeObject(funcionario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArquivoFuncionarios arquivo = new ArquivoFuncionarios("funcionarios.dat");

        arquivo.adicionarFuncionario(new Funcionario(1, "Renato", 5300));
        arquivo.adicionarFuncionario(new Funcionario(2, "Luiza", 2400));

        List<Funcionario> funcionarios = arquivo.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        arquivo.atualizarFuncionario(1, new Funcionario(1, "Douglas Costa", 3100));

        arquivo.excluirFuncionario(2);

        funcionarios = arquivo.listarFuncionarios();
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}