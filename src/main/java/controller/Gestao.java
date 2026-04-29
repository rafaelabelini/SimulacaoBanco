package controller;

import model.*;

import java.util.HashMap;
import java.util.Map;

public class Gestao {
    private static final double TAXA_CARTAO_CREDITO = 0.15;

    private static final ServicoScore servicoScore = new ServicoScoreSimples();
    private static final Map<String, Usuario> usuarios = new HashMap<>();
    private static final Map<String, CartaoCredito> cartoesCredito = new HashMap<>();
    private static final Map<String, CartaoDebito> cartoesDebito = new HashMap<>();

    public static void main(String[] args) {
        view.Inicio.main(args);
    }

    public static Usuario cadastrarUsuario(String nome, String cpf, String senha, double salario) {
        validarCadastro(nome, cpf, senha, salario);

        String cpfNormalizado = normalizarCpf(cpf);
        if (usuarios.containsKey(cpfNormalizado)) {
            throw new IllegalArgumentException("Ja existe um usuario cadastrado com esse CPF.");
        }

        Usuario usuario = new Usuario(nome.trim(), cpfNormalizado, senha, salario, servicoScore);
        usuarios.put(cpfNormalizado, usuario);
        cartoesCredito.put(cpfNormalizado, new CartaoCredito(usuario, TAXA_CARTAO_CREDITO));
        cartoesDebito.put(cpfNormalizado, new CartaoDebito(salario));

        return usuario;
    }

    public static Usuario buscarUsuario(String nome, String cpf, String senha) {
        String cpfNormalizado = normalizarCpf(cpf);
        Usuario usuario = usuarios.get(cpfNormalizado);

        if (usuario == null) {
            throw new IllegalArgumentException("Usuario nao encontrado.");
        }

        boolean nomeConfere = usuario.getNome().equalsIgnoreCase(nome.trim());
        boolean senhaConfere = usuario.getSenha().equals(senha);

        if (!nomeConfere || !senhaConfere) {
            throw new IllegalArgumentException("Nome, CPF ou senha invalidos.");
        }

        return usuario;
    }

    public static int consultarScore(String nome, String cpf, String senha) {
        return buscarUsuario(nome, cpf, senha).getScore();
    }

    public static CartaoCredito consultarCartaoCredito(String nome, String cpf, String senha) {
        Usuario usuario = buscarUsuario(nome, cpf, senha);
        return cartoesCredito.get(usuario.getCpf());
    }

    public static CartaoDebito consultarCartaoDebito(String nome, String cpf, String senha) {
        Usuario usuario = buscarUsuario(nome, cpf, senha);
        return cartoesDebito.get(usuario.getCpf());
    }

    private static void validarCadastro(String nome, String cpf, String senha, double salario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe o nome.");
        }
        if (normalizarCpf(cpf).length() != 11) {
            throw new IllegalArgumentException("Informe um CPF valido com 11 digitos.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Informe a senha.");
        }
        if (salario <= 0) {
            throw new IllegalArgumentException("Informe um salario maior que zero.");
        }
    }

    private static String normalizarCpf(String cpf) {
        if (cpf == null) {
            return "";
        }
        return cpf.replaceAll("\\D", "");
    }
}
