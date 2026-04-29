package model;

import java.util.Random;

public class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private double salario;
    private int score;

    public Usuario(String nome, String cpf,  double salario, ServicoScore servicoScore) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.score = servicoScore.calcularScore(this);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
}
