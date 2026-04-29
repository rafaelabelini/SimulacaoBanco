package controller;

import model.*;

import java.util.Scanner;

public class Gestao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ServicoScore servicoScore = new ServicoScoreSimples();
        Usuario usuario = new Usuario("Rafael", "123456789", 1478, servicoScore);

        CartaoCredito cartaoCredito = new CartaoCredito(usuario, 0.15);
        CartaoDebito cartaoDebito = new CartaoDebito(1000);

        System.out.println(cartaoCredito.consultarSaldo());
        System.out.println(cartaoDebito.consultarSaldo());
        System.out.println(usuario.getScore());




    }
}
