package model;

public class CartaoDebito implements Cartao {
    private double saldo;

    public CartaoDebito(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public void pagar(double valor) {

    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
