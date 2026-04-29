package model;

public class Usuario {
    private String nome;
    private String cpf;
    private String senha;
    private double salario;
    private int score;

    public Usuario(String nome, String cpf, String senha, double salario, ServicoScore servicoScore) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.salario = salario;
        this.score = servicoScore.calcularScore(this);
    }

    public Usuario(String nome, String cpf,  double salario, ServicoScore servicoScore) {
        this(nome, cpf, "", salario, servicoScore);
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
