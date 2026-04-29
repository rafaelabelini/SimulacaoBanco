package model;

public class CartaoDebito implements Cartao {
    private double saldo;

    public CartaoDebito(double saldo) {
        this.saldo = saldo;
    }


    @Override
    public void pagar(double valor) {
        if (valor <= 0) {
            return;
        }
        if (valor <= saldo) {
            saldo -= valor;
        }
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
